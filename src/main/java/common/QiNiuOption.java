package common;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

import java.io.File;

/**
 * @description: // TODO
 * @author: Seven-Steven
 * @create: 2018-11-23 15:48
 **/
public class QiNiuOption {
  private String accessKey = "ak";
  private String secretKey = "sk";
  private String bucket = "bucket";
  private String domain;
  private String upToken = null;

  private String getDomain() {
    // TODO 从配置文件读取 domain
    // TODO 判断是不是以 / 结尾
    domain = "";
    return domain;
  }

  private String getUpToken() {
    if (upToken == null) {
      Auth auth = Auth.create(accessKey, secretKey);
      upToken = auth.uploadToken(bucket);
    }

    return upToken;
  }

  /**
   * @Description: 将本地文件上传至七牛云
   * @Param: [filePath] 本地文件路径
   * @Return: java.lang.String 文件链接
   * @Author: Seven-Steven
   * @Date: 18-11-23
   **/
  public String uploadLocalFile(String filePath) {
    //构造一个带指定Zone对象的配置类
    Configuration cfg = new Configuration(Zone.zone2());
    UploadManager uploadManager = new UploadManager(cfg);

    String key = new File(filePath).getName();

    DefaultPutRet putRet = null;
    try {
      Response response = uploadManager.put(filePath, key, getUpToken());
      //解析上传成功的结果
      putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
    } catch (QiniuException ex) {
      Response r = ex.response;
      System.err.println(r);
      try {
        System.err.println(r.bodyString());
      } catch (QiniuException ex2) {
        //ignore
      }
    }
    return getDomain() + putRet.key;
  }
}

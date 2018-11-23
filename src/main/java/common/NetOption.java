package common;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @description: // TODO
 * @author: Seven-Steven
 * @create: 2018-11-23 11:49
 **/
public class NetOption {

  public static File file;

  public static void main(String[] args) {
    String path = "https://img-blog.csdn.net/20150401112132559?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2luYXRfMjI2NTc0NTk=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center";
    try {
      new NetOption().downloadImage(path, "/home/seven/Downloads/test1.png");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * @Description: 下载网络图片到本地
   * @Param: [imagePath, savePath]
   *          imagePath: 网络图片 url
   *          savePath: 本地保存路径
   * @Author: Seven-Steven
   * @Date: 18-11-23
   **/
  public void downloadImage(String imagePath, String savePath) throws IOException {
    BufferedReader reader = null;
    URL url = null;
    try {
      url = new URL(imagePath);
    } catch (MalformedURLException e) {
      throw new MalformedURLException("URL 不合法");
    }

    try {
      URLConnection urlConnection = url.openConnection();
      FileOutputStream fileOutputStream = new FileOutputStream(savePath);
      InputStream inputStream = urlConnection.getInputStream();
      byte[] buf = new byte[1024];
      int len = 0;
      while ((len = inputStream.read(buf)) != -1) {
        fileOutputStream.write(buf, 0, len);
      }
    } catch (FileNotFoundException e) {
      throw e;
    } catch (IOException e) {
      throw e;
    } finally {
      if (reader != null) {
        reader.close();
      }
    }
  }

  /**
   * 读取图像的二进制流
   *
   * @param infile
   * @return
   */
  // public static FileInputStream getByteImage(String infile) {
  //   FileInputStream inputImage = null;
  //   file = new File(infile);
  //   try {
  //     inputImage = new FileInputStream(file);
  //   } catch (FileNotFoundException e) {
  //     e.printStackTrace();
  //   }
  //   return inputImage;
  // }

  // /**
  //  * 输出图片
  //  *
  //  * @param inputStream
  //  * @param path
  //  */
  // public static void readBlob(FileInputStream inputStream, String path) {
  //   try {
  //     FileOutputStream fileOutputStream = new FileOutputStream(path);
  //     byte[] buf = new byte[1024];
  //     int len = 0;
  //     while ((len = inputStream.read(buf)) != -1) {
  //       fileOutputStream.write(buf, 0, len);// 写
  //     }
  //     inputStream.close();
  //     fileOutputStream.close();
  //   } catch (FileNotFoundException e) {
  //     e.printStackTrace();
  //   } catch (IOException e) {
  //     e.printStackTrace();
  //   }
  // }
  //
}

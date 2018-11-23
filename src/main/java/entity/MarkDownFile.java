package entity;

import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description: markdown 文件操作类
 * @author: Seven-Steven
 * @create: 2018-11-22 16:02
 **/
public class MarkDownFile extends File {
  private StringBuilder content = new StringBuilder(5000);
  private List<String> pictureUrl = new ArrayList<>(10);

  public MarkDownFile(String pathname) throws IOException {
    super(pathname);
    this.init();
  }

  public MarkDownFile(String parent, String child) throws IOException {
    super(parent, child);
    this.init();
  }

  public MarkDownFile(File parent, String child) throws IOException {
    super(parent, child);
    this.init();
  }

  public MarkDownFile(URI uri) throws IOException {
    super(uri);
    this.init();
  }

  /**
   * @Description: 初始化方法, 读取文件内容并提取图片地址
   * @Author: Seven-Steven
   * @Date: 18-11-22
   **/
  private void init() throws IOException {
    this.getContent();
    this.getPictures();
  }

  /**
   * @Description: 读取文件内容
   * @Author: Seven-Steven
   * @Date: 18-11-22
   **/
  private void getContent() throws IOException {
    BufferedReader in = new BufferedReader(new FileReader(this.getPath()));
    String str;
    while ((str = in.readLine()) != null) {
      content.append(str).append('\n');
    }
  }

  /**
   * @Description: 提取 markdown 文件中的图片地址
   * @Author: Seven-Steven
   * @Date: 18-11-22
   **/
  private void getPictures() {
    String regex = "!\\[.*?\\]\\((.*?)\\)";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(content);
    while (matcher.find()) {
      pictureUrl.add(matcher.group(1));
    }
  }

  /**
   * @Description: 备份文件到当期文件夹
   * @Author: Seven-Steven
   * @Date: 18-11-23
   **/
  public void backup() throws IOException {
    // TODO 备份文件可自定义后缀
    File backup = new File(toPath() + ".bak");
    System.out.println(backup);
    Files.copy(toPath(), backup.toPath());
  }

  /**
   * @Description: 将 markdown 对象内容写入文件
   * @Author: Seven-Steven
   * @Date: 18-11-23
   **/
  public void write() throws IOException {
    BufferedWriter out = new BufferedWriter(new FileWriter(this));
    out.write(String.valueOf(content));
    out.close();
  }

  /**
   * @Description: 过滤掉不需要替换的图片
   * @Param: [whiteList] 白名单
   * @Author: Seven-Steven
   * @Date: 18-11-23
   **/
  public void pictureUrlFilter(String[] whiteList) {
    Pattern pattern = null;
    Matcher matcher = null;
    String picture;
    for (int i = 0, pictureUrlLength = pictureUrl.size(); i < pictureUrlLength; i++) {
      picture = pictureUrl.get(i);
      for (String regx : whiteList) {
        pattern = Pattern.compile(regx);
        matcher = pattern.matcher(picture);
        if (matcher.find()) {
          pictureUrl.remove(picture);
          i--;
          pictureUrlLength--;
          break;
        }
      }
    }
  }

  /**
   * @Description: 将 markdown 文件中的所有就字符串替换为新字符串
   * @Param: [oldStr, newStr]
   * oldStr: 需要被替换的旧字符串
   * newStr: 用于替换旧字符串的新字符串
   * @Author: Seven-Steven
   * @Date: 18-11-22
   **/
  public void replaceAll(String oldStr, String newStr) {
    // 参数校验
    if (this.content == null || this.content.length() == 0 || oldStr == null || oldStr.length() == 0) {
      return;
    }
    // 如果替换字符串为null, 将其重置为空字符串
    newStr = newStr == null ? "" : newStr;
    int oldStringLength = oldStr.length();
    int newStringLength = newStr.length();

    // 执行替换
    int index = this.content.indexOf(oldStr);
    if (index > -1 && !oldStr.equals(newStr)) {
      int lastIndex = 0;
      while (index > -1) {
        this.content.replace(index, index + oldStringLength, newStr);
        lastIndex = index + newStringLength;
        index = this.content.indexOf(oldStr, lastIndex);
      }
    }
  }

  /**
   * @Description: 获取 markdown 文件的图片列表
   * @Return: java.util.List<java.lang.String> 图片列表
   * @Author: Seven-Steven
   * @Date: 18-11-22
   **/
  public List<String> getPictureUrl() {
    return pictureUrl;
  }
}

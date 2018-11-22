package entity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
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
   * @Description: 初始化方法, 读取文件内容并提取图片地址
   * @Author: Seven-Steven
   * @Date: 18-11-22
   **/
  private void init() throws IOException {
    this.getContent();
    this.getPictures();
  }


  private void getContent() throws IOException {
    BufferedReader in = new BufferedReader(new FileReader(this.getPath()));
    String str;
    while ((str = in.readLine()) != null) {
      this.content.append(str);
    }
    System.out.println(this.content);
  }

  /**
   * @Description: 提取 markdown 文件中的图片地址
   * @Author: Seven-Steven
   * @Date: 18-11-22
   **/
  private void getPictures() {
    String regex = "!\\[.*?\\]\\((.*?)\\)";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(this.content);
    while (matcher.find()) {
      this.pictureUrl.add(matcher.group(1));
    }
  }

  public List<String> getPictureUrl() {
    return pictureUrl;
  }
}

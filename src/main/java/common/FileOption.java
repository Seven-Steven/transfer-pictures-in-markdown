package common;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;

/**
 * @description: 文件操作类
 * @author: Seven-Steven
 * @create: 2018-11-21 13:34
 **/
public class FileOption {

  private File file;

  /**
   * @Description: 空参构造器
   * @Param: null
   * @Author: Seven-Steven
   * @Date: 18-11-21
   **/
  public FileOption() {
    super();
  }

  /**
   * @Description: 构造器
   * @Param: [file] 文件参数
   * @Author: Seven-Steven
   * @Date: 18-11-22
   **/
  public FileOption(File file) throws FileNotFoundException {
    if (!file.exists()) {
      throw new FileNotFoundException();
    }

    this.file = file;
  }

  /**
   * @Description: 构造器, 根据参数指定的文件创造对象
   * @Param: [path] 文件路径
   * @Author: Seven-Steven
   * @Date: 18-11-22
   **/
  public FileOption(String path) throws FileNotFoundException {
    File file = new File(path);
    if (!file.exists()) {
      throw new FileNotFoundException();
    }

    this.file = file;
  }

  /**
   * @Description: 获取当前文件夹下的文件列表
   * @Return: java.io.File[] 返回当前文件夹下的文件列表
   * @Author: Seven-Steven
   * @Date: 18-11-22
   **/
  public File[] getFileList() {
    if (this.file.isDirectory()) {
      return this.file.listFiles();
    } else {
      return null;
    }
  }

  /**
   * @Description: 根据文件名后缀过滤文件
   * @Param: [endWith] 用于过滤的后缀名
   * @Return: java.io.File[] 返回当前文件夹下符合条件的文件和目录
   * @Author: Seven-Steven
   * @Date: 18-11-22
   **/
  public File[] getFileListByEndString(String endWith) {
    return this.file.listFiles((dir, name) -> {
      if (name.endsWith(endWith)) {
        return true;
      } else {
        return false;
      }
    });
  }

  public File[] getFileList(FileFilter fileFilter) {
    return this.file.listFiles(fileFilter);
  }
}

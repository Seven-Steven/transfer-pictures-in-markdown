package entity;

import com.beust.jcommander.Parameter;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: // TODO
 * @author: Seven-Steven
 * @create: 2018-11-22 11:54
 **/
public class Arguments {
  @Parameter
  private List<String> parameters = new ArrayList<>();

  @Parameter(names = {"-config-file"}, description = "use a specified config file")
  // TODO 确定配置文件名
  private String configFile = "./config";

  @Parameter(names = {"-backupFiles"}, description = "backup MarkDown files before transfer picture")
  private Boolean backupFiles = true;

  @Parameter(names = {"-h", "-help"}, description = "show the help information")
  private Boolean help = false;

  @Parameter(names = {"-v", "--version"}, description = "show the version information")
  // TODO 确定字段类型
  private String version;

}

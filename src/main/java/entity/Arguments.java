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

  @Parameter(names = {"-backup"}, description = "backup MarkDown files before transfer picture")
  private Boolean backupFiles = true;

  @Parameter(names = {"-h", "-help"}, description = "show the help information")
  private Boolean help = false;

  @Parameter(names = {"-v", "--version"}, description = "show the version information")
  // TODO 确定字段类型
  private String version;

  public List<String> getParameters() {
    return parameters;
  }

  public void setParameters(List<String> parameters) {
    this.parameters = parameters;
  }

  public String getConfigFile() {
    return configFile;
  }

  public void setConfigFile(String configFile) {
    this.configFile = configFile;
  }

  public Boolean getBackupFiles() {
    return backupFiles;
  }

  public void setBackupFiles(Boolean backupFiles) {
    this.backupFiles = backupFiles;
  }

  public Boolean getHelp() {
    return help;
  }

  public void setHelp(Boolean help) {
    this.help = help;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }
}

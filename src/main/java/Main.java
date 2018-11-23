import entity.MarkDownFile;

import java.io.IOException;

public class Main {
  public static void main(String[] args) {

    try {
      MarkDownFile md = new MarkDownFile("/home/seven/Downloads/test.md");
      String[] whiteList = {"18-1-20"};
      md.pictureUrlFilter(whiteList);
      int i = 1;
      for (String s : md.getPictureUrl()) {
        System.out.println(i++ + "  " + s);
      }
      System.out.println("Done");
      // md.backup();
      // md.replaceAll("http", "==========================================================");
      // md.write();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return;

    // 读取命令行参数
    // Arguments arguments = new Arguments();
    // JCommander.newBuilder()
    //     .addObject(arguments)
    //     .build()
    //     .parse(args);
    // List parameters = arguments.getParameters();
    // for (Object o : parameters) {
    //   System.out.println(o);
    // }
    //
    // for (Object parameter : parameters) {
    //
    // }


    //测试七牛sdk
    // String accessKey = "ak";
    // String secretKey = "sk";
    // String bucket = "bucket";
    //
    // Auth auth = Auth.create(accessKey, secretKey);
    // String upToken = auth.uploadToken(bucket);
    // // System.out.println(upToken);

    // 测试 FileOption
    // try {
    //   FileOption fileOption = new FileOption("./");
    //   File[] files = fileOption.getFileList();
    //   for (File file : files) {
    //     System.out.println(file);
    //   }
    // } catch (FileNotFoundException e) {
    //   e.printStackTrace();
    // }
  }
}

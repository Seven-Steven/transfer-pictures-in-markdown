import entity.MarkDownFile;

import java.io.IOException;

public class Main {
  public static void main(String[] args) {

    try {
      MarkDownFile md = new MarkDownFile("/home/seven/Downloads/test.md");
      md.getContent();
      md.getPictures();
      System.out.println(md.getPictureUrl());
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


    // String accessKey = "ak";
    // String secretKey = "sk";
    // String bucket = "bucket";
    //
    // Auth auth = Auth.create(accessKey, secretKey);
    // String upToken = auth.uploadToken(bucket);
    // // System.out.println(upToken);


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

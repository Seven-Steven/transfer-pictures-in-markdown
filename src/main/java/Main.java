public class Main {
  public static void main(String[] args) {
    // String accessKey = "ak";
    // String secretKey = "sk";
    // String bucket = "bucket";
    //
    // Auth auth = Auth.create(accessKey, secretKey);
    // String upToken = auth.uploadToken(bucket);
    // // System.out.println(upToken);

    for (String arg : args) {
      System.out.println(arg);
    }

    //
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

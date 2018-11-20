import com.qiniu.util.Auth;

public class Main {
  public static void main(String[] args) {
    String accessKey = "ak";
    String secretKey = "sk";
    String bucket = "bucket";

    Auth auth = Auth.create(accessKey, secretKey);
    String upToken = auth.uploadToken(bucket);
    System.out.println(upToken);
  }
}

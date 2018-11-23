import com.beust.jcommander.JCommander;
import common.NetOption;
import common.QiNiuOption;
import entity.Arguments;
import entity.MarkDownFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    Arguments arguments = new Arguments();
    JCommander.newBuilder().addObject(arguments).build().parse(args);
    List<String> parameters = arguments.getParameters();

    QiNiuOption qiNiuOption = new QiNiuOption();

    MarkDownFile md = null;
    for (String filePath : parameters) {
      try {
        md = new MarkDownFile(filePath);
        md.backup();
      } catch (IOException e) {
        System.out.println("markdown 文件路径不合法!");
        e.printStackTrace();
      }

      // TODO 白名单过滤
      List<String> pictureUrlList = md.getPictureUrl();
      int i = 0;
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      String date = dateFormat.format(new Date());

      for (String pictureUrl : pictureUrlList) {
        String fileName = new SimpleDateFormat("HHmmssSSS").format(new Date());
        String savePath = "/tmp/markdown/" + date + fileName + ".png";
        // 抓取网络图片
        NetOption netOption = new NetOption();
        try {
          netOption.downloadImage(pictureUrl, savePath);
          String qiNiuUrl = qiNiuOption.uploadLocalFile(savePath);
          md.replaceAll(pictureUrl, qiNiuUrl);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }

      try {
        md.write();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}

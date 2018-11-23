package common;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @description: // TODO
 * @author: Seven-Steven
 * @create: 2018-11-23 11:49
 **/
public class NetOption {
  // /**
  //  * @Description: 读取网络流图片格式
  //  * @Param: [srcInputStream] 网络流
  //  * @Return: java.lang.String 图片格式
  //  * @Author: Seven-Steven
  //  * @Date: 18-11-23
  //  **/
  // public String getImageFormat(InputStream srcInputStream) throws IOException {
  //   String formatName = null;
  //
  //   // 获取ImageInputStream 对象
  //   ImageInputStream imageInputStream = ImageIO.createImageInputStream(srcInputStream);
  //   // 获取ImageReader对象的迭代器
  //   Iterator<ImageReader> iterator = ImageIO.getImageReaders(imageInputStream);
  //
  //   // 如果能获得ImageReader对象则说明流中含有图片文件
  //   if (iterator.hasNext()) {
  //     formatName = iterator.next().getFormatName();
  //   }
  //
  //   imageInputStream.close();
  //   return formatName;
  // }

  /**
   * @Description: 下载网络图片到本地
   * @Param: [imageUrl, savePath]
   * imageUrl: 网络图片 url
   * savePath: 本地保存路径
   * @Author: Seven-Steven
   * @Date: 18-11-23
   **/
  public void downloadImage(String imageUrl, String savePath) throws IOException {
    BufferedImage image = null;
    URL url = new URL(imageUrl);
    image = ImageIO.read(url);

    // TODO 图片格式自动读取
    ImageIO.write(image, "png", new File(savePath));
  }
}

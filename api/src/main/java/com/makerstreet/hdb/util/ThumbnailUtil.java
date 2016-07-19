package com.makerstreet.hdb.util;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 * 缩略图辅助工具类
 * 将大图片 可以生成 小的缩略图
 * 生成的格式为 例如：     a.jpg   --->   a.jpgsmall
 * @author admin
 */
public class ThumbnailUtil {
	public static String toSmallJpg(String bigJpgPath) {
		if (!bigJpgPath.toLowerCase().endsWith("jpg")
				&& !bigJpgPath.toLowerCase().endsWith("jpeg")) {
			return bigJpgPath;
		}
		//StringBuffer small = new StringBuffer(bigJpgPath);
		//small.insert(small.lastIndexOf("."), "small");
		String smallPath = bigJpgPath + "small";

		// 新建源图片和生成的小图片的文件对象
		File fi = new File(bigJpgPath);
		File fo = new File(smallPath);
		// 生成图像变换对象
		AffineTransform transform = new AffineTransform();
		// 通过缓冲读入源图片文件
		BufferedImage bsrc = null;
		try {
			bsrc = ImageIO.read(fi);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		int pic_big_width = bsrc.getWidth();// 原图像的长度
		int pic_big_height = bsrc.getHeight();// 原图像的宽度
		double scale = (double) pic_big_width / pic_big_height;// 图像的长宽比例
		double sx = (double) 250 / pic_big_width;// 小/大图像的宽度比例
		double sy = (double) 250 / pic_big_height;// 小/大图像的高度比例
		transform.setToScale(sx, sy);// 设置图像转换的比例
		// 生成图像转换操作对象
		AffineTransformOp ato = new AffineTransformOp(transform, null);
		// 生成缩小图像的缓冲对象
		BufferedImage bsmall = new BufferedImage(250, 250,
				BufferedImage.TYPE_3BYTE_BGR);
		// 生成小图像
		ato.filter(bsrc, bsmall);
		// 输出小图像
		try {
			ImageIO.write(bsmall, "jpeg", fo);
		} catch (Exception ex1) {
			ex1.printStackTrace();
		}
		return smallPath;
	}
}

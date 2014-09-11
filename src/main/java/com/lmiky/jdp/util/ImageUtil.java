package com.lmiky.jdp.util;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.Thumbnails.Builder;
import net.coobird.thumbnailator.geometry.Positions;

/**
 * 图片工具类
 * @author lmiky
 * @date 2013-10-18
 */
public class ImageUtil {

	/**
	 * 按原比例重新设置图片尺寸
	 * @author lmiky
	 * @date 2013-10-18
	 * @param file	图片文件
	 * @param width	宽
	 * @param height	高
	 * @param outputQuality	清晰度，完全清晰值为1.0
	 * @param outputFile	生成的图片文件路径(包含图片名)
	 * @throws IOException 
	 */
	public static void resize(String file, int width, int height, float outputQuality, String outputFile) throws IOException {
		Builder<File> builder = Thumbnails.of(new File(file));
		builder = setSize(builder, width, height);
		outputFile(builder, outputQuality, outputFile);
	}
	
	/**
	 * 给图片增加水印
	 * @author lmiky
	 * @date 2013-10-18
	 * @param file	图片文件
	 * @param watermarkFile	水印文件
	 * @param watermarkPositions	水印增加的位置
	 * @param watermarkQuality	水印清晰度，完全清晰值为1.0
	 * @param outputQuality	清晰度，完全清晰值为1.0
	 * @param outputFile	生成的图片文件路径(包含图片名)
	 * @throws IOException
	 */
	public static void watermark(String file, String watermarkFile, Positions watermarkPositions, float watermarkQuality, float outputQuality, String outputFile) throws IOException {
		Builder<File> builder = Thumbnails.of(new File(file));
		builder = watermark(builder, watermarkFile, watermarkPositions, watermarkQuality);
		outputFile(builder, outputQuality, outputFile);
	}
	
	/**
	 * 按原比例重新设置图片尺寸并增加水印
	 * @author lmiky
	 * @date 2013-10-18
	 * @param file
	 * @param width
	 * @param height
	 * @param watermarkFile
	 * @param watermarkPositions
	 * @param watermarkQuality
	 * @param outputQuality
	 * @param outputFile
	 * @throws IOException
	 */
	public static void resizeAndWatermark(String file, int width, int height, String watermarkFile, Positions watermarkPositions, float watermarkQuality, float outputQuality, String outputFile) throws IOException {
		Builder<File> builder = Thumbnails.of(new File(file));
		builder = setSize(builder, width, height);
		outputFile(builder, outputQuality, outputFile);
	}
	
	/**
	 * 设置大小
	 * @author lmiky
	 * @date 2013-10-18
	 * @param builder
	 * @param width
	 * @param height
	 * @return
	 */
	private static Builder<File> setSize(Builder<File> builder, int width, int height) {
		return builder.size(width, height);
	}
	
	/**
	 * 增加水印
	 * @author lmiky
	 * @date 2013-10-18
	 * @param builder
	 * @param watermarkFile
	 * @param watermarkPositions
	 * @param watermarkQuality
	 * @return
	 * @throws IOException
	 */
	private static Builder<File> watermark(Builder<File> builder, String watermarkFile, Positions watermarkPositions, float watermarkQuality) throws IOException {
		return builder.watermark(watermarkPositions, ImageIO.read(new File(watermarkFile)), watermarkQuality);
	}
	
	/**
	 * 输出文件
	 * @author lmiky
	 * @date 2013-10-18
	 * @param builder
	 * @param outputQuality
	 * @param outputFile
	 * @throws IOException 
	 */
	private static void outputFile(Builder<File> builder, float outputQuality, String outputFile) throws IOException {
		builder.outputQuality(outputQuality).toFile(new File(outputFile));
	}
	
}

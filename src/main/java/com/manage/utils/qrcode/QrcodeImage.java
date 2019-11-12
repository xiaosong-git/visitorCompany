package com.manage.utils.qrcode;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.OutputStream;


public class QrcodeImage {
	public static void main(String[] args) {
		String code = "FHGDHDHHUEHFDD";
		System.out.println("FHGDHDHHUEHFDD:" + code.length());
		encoderQRCode(
				"http://cx094320:8080/fd203?invitation_code=FHGDHDHHUEHFD",
				new String[] { "ABCDEFGHIJKLMN", "0123456789012" }, "E:/fd.png",
				"E:/icon_32.png");
	}

	public static void encoderQRCode(String content, String bottStr[],String imgPath, String centerImgPath) {

		//System.out.println(content.length());
		try {
			BufferedImage bufImg = qRCodeCommon(content, bottStr, centerImgPath);
			File imgFile = new File(imgPath);
			// 生成二维码QRCode图片
			ImageIO.write(bufImg, "png", imgFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 生成二维码(QRCode)图片
	 * 
	 * @param content
	 *            存储内容
	 * @param output
	 *            输出流
	 * @param imgType
	 *            图片类型
	 * @param centerImgPath
	 *            二维码尺寸
	 */
	public static void encoderQRCode(String content, String bottStr[],
			OutputStream output, String imgType, String centerImgPath) {
		try {
			BufferedImage bufImg = qRCodeCommon(content, bottStr, centerImgPath);
			// 生成二维码QRCode图片
			ImageIO.write(bufImg, imgType, output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 生成二维码(QRCode)图片的公共方法
	 * 
	 * @param content
	 *            存储内容
	 * @param bottStr
	 *            图片类型
	 * @param centerImgPath
	 *            二维码尺寸
	 * @return
	 */
	private static BufferedImage qRCodeCommon(String content, String bottStr[],
			String centerImgPath) {
		BufferedImage bufImg = null;
		try {
			Qrcode qrcodeHandler = new Qrcode();
			// 设置二维码排错率，可选L(7%)、M(15%)、Q(25%)、H(30%)，排错率越高可存储的信息越少，但对二维码清晰度的要求越小
			qrcodeHandler.setQrcodeErrorCorrect('M');
			qrcodeHandler.setQrcodeEncodeMode('B');
			// 设置设置二维码尺寸，取值范围1-40，值越大尺寸越大，可存储的信息越大
			int size_ = 7;
			qrcodeHandler.setQrcodeVersion(size_);
			// 获得内容的字节数组，设置编码格式
			byte[] contentBytes = content.getBytes("utf-8");
			// 图片尺寸
			int imgSize = 68 + 12 * (size_ - 1);
			bufImg = new BufferedImage(imgSize, imgSize + 15,
					BufferedImage.TYPE_INT_RGB);
			Graphics2D gs = bufImg.createGraphics();
			// 设置背景颜色
			gs.setBackground(Color.WHITE);
			gs.clearRect(0, 0, imgSize, imgSize + 26);
			// 设定图像颜色> BLACK
			gs.setColor(Color.black);
			// 设置偏移量，不设置可能导致解析出错
			int pixoff = 2;
			// 输出内容> 二维码
			if (contentBytes.length > 0 && contentBytes.length < 800) {
				boolean[][] codeOut = qrcodeHandler.calQrcode(contentBytes);
				for (int i = 0; i < codeOut.length; i++) {
					for (int j = 0; j < codeOut.length; j++) {
						if (codeOut[j][i]) {
							gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
						}
					}
				}
				//Lucida Console 
				//Courier New
				//Terminus 
				Font f = new Font("Terminus ", Font.BOLD, 12);
				gs.setFont(f);
				gs.drawString( bottStr[0], 5, imgSize + 10);// 画出字符串
				//gs.drawString(bottStr[1], 7, imgSize + 22);// 画出字符串
				/* 判断是否需要添加logo图片 */
				if (centerImgPath != null) {
					int width_4 = imgSize / 4;
					int width_8 = width_4 / 2;
					int height_4 = imgSize / 4;
					int height_8 = height_4 / 2;
					gs.setBackground(Color.WHITE);
					gs.clearRect(width_4 + width_8, height_4 + height_8,
							width_4, height_4);
					Image img = ImageIO.read(new File(centerImgPath));
					gs.drawImage(img, width_4 + width_8, height_4 + height_8,
							width_4, height_4, null);
				}
			} else {
				throw new Exception("QRCode content bytes length = "
						+ contentBytes.length + " not in [0, 800].");
			}
			gs.dispose();
			bufImg.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bufImg;
	}
}
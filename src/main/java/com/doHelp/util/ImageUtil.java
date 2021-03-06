package com.doHelp.util;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
/*  生成随机验证码，再生成一张图片，将他们保存在Map中，Map<随机字符，图片验证码>  然后返回Map  */
public final class ImageUtil {
		private static final String[] chars = { "0", "1", "2", "3", "4", "5", "6",
		"7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H","J","K","L","M","N","P"};
		private static final int SIZE = 5;//字符长度
		private static final int LINES = 7;//干扰线数
		private static final int WIDTH = 100;//宽度
		private static final int HEIGHT = 50;//高度
		private static final int FONT_SIZE = 30;//字体大小
		public static Map<String,BufferedImage> createImage() {
			StringBuffer sb = new StringBuffer();
			BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
			BufferedImage.TYPE_INT_RGB); // 宽度，高度以及固定写法
			Graphics graphic = image.getGraphics();
			graphic.setColor(Color.LIGHT_GRAY);
			graphic.fillRect(0, 0, WIDTH, HEIGHT);
			Random ran = new Random();
			//画随机字符
			for(int i=1;i<=SIZE;i++){
			int r = ran.nextInt(chars.length);
			graphic.setColor(getRandomColor());
			graphic.setFont(new Font(null,Font.BOLD+Font.ITALIC,FONT_SIZE));
			graphic.drawString(chars[r],(i-1)*WIDTH/SIZE , HEIGHT/2);
			sb.append(chars[r]);//将字符保存，存入Session
			}
			// 查干扰
			for(int i=1;i<=LINES;i++){
				graphic.setColor(getRandomColor());
				graphic.drawLine(ran.nextInt(WIDTH), ran.nextInt(HEIGHT), ran.nextInt(WIDTH),ran.nextInt(HEIGHT));
		}		
			Map<String,BufferedImage> map = new HashMap<String,BufferedImage>();map.put(sb.toString(), image);
			return map;
			}
		//生成随机颜色
		public static Color getRandomColor(){
			Random ran = new Random();
			Color color = new Color(ran.nextInt(156),ran.nextInt(156),ran.nextInt(156));
			return color;
		}
	}


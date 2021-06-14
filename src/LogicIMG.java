import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JTextArea;

public class LogicIMG {


	public String[] colors_x4 = new String[] {
			"\u2588","\u2593","\u2592","\u2591",	
	};

	public String[] colors_eco = new String[] {
			"\u2500","\u2584","\u2580","\u2588"	//\u2588\u2580\u2584 
	};

	ArrayList<String> ln = new ArrayList<String>();

	String mainString = "";

//	private int size = 500;

	BufferedImage img; 

	public String /*BufferedImage*/ Convert(BufferedImage imgLoad, int type) {

		// CREATING STRING

		if(type == 0) {
			for (int y = 0; y < imgLoad.getHeight(); y++) {
				for (int x = 0; x < imgLoad.getWidth(); x++) {
					Color color = new Color(imgLoad.getRGB(x, y));
					int gray = (color.getRed() + color.getGreen() + color.getBlue())/3;
					double k = 300 / colors_x4.length; 
					
					//System.out.println(gray);

					mainString += colors_x4[(int) (gray/k)];
					mainString += colors_x4[(int) (gray/k)];
				}
				mainString += "\n";
			}
		}

		if(type == 1) {
			for (int y = 0; y < imgLoad.getHeight()-1; y+=2) {
				for (int x = 0; x < imgLoad.getWidth(); x++) {
					double k = 255 / 1; 
					//System.out.println(gray);
					Color color = new Color(imgLoad.getRGB(x, y));
					int gray = (color.getRed() + color.getGreen() + color.getBlue())/3;
					int i1 = (int) (gray/k);
					color = new Color(imgLoad.getRGB(x, y+1));
					gray = (color.getRed() + color.getGreen() + color.getBlue())/3;
					int i2 = (int) (gray/k);

					int i = (i1 *2) + i2;

					mainString += colors_eco[3-i];
				}
				mainString += "\n";
			}
		}
		
		if(type == 2) {
			int rgb = 0;
			for (int y = 0; y < imgLoad.getHeight(); y++) {
				for (int x = 0; x < imgLoad.getWidth(); x++) {
//					ifColor color = new Color();
//					int gray = (color.getRed() + color.getGreen() + color.getBlue())/3;
//					double k = 300 / colors_x4.length;
					if(rgb == imgLoad.getRGB(x, y)) {
						mainString += colors_x4[0];
						mainString += colors_x4[0];
					}else {
						rgb = imgLoad.getRGB(x, y);
						mainString += "[/color]";
						String colorHex =  Integer.toHexString(new Color(rgb).getRGB());
						mainString+= "[color=#" + colorHex.substring(2) + "]";
						mainString += colors_x4[0];
						mainString += colors_x4[0];
					}
				}
				mainString += "\n";
			}
		}
		
		if(type == 3) {
			int rgb = 0;
			mainString = "<!doctype html>\r\n<head><style>lineHeight {line-height: 0;} \r\n p{line-height: 0;}\r\n </style>\r\n<title>by Agzam4</title>\r\n<head>\r\n" + 
					"	<body><pre style=\"white-space: pre-wrap;\"><lineHeight>\r\n";
					//line-height: 1.5;
			for (int y = 0; y < imgLoad.getHeight(); y++) {
				for (int x = 0; x < imgLoad.getWidth(); x++) {
//					ifColor color = new Color();
//					int gray = (color.getRed() + color.getGreen() + color.getBlue())/3;
//					double k = 300 / colors_x4.length;
					if(rgb == imgLoad.getRGB(x, y)) {
						mainString += colors_x4[0];
						mainString += colors_x4[0];
					}else {
						rgb = imgLoad.getRGB(x, y);
						mainString += "</ByAgzam4>";
						String colorHex =  Integer.toHexString(new Color(rgb).getRGB());
						mainString+= "<ByAgzam4 style=\"color: #" + colorHex.substring(2) + ";\">";
						mainString += colors_x4[0];
						mainString += colors_x4[0];
					}
				}
				mainString += "</ByAgzam4>\n";
				String colorHex =  Integer.toHexString(new Color(rgb).getRGB());
				mainString+= "<ByAgzam4 style=\"color: #" + colorHex.substring(2) + ";\">";
			}
			mainString += "</lineHeight></pre></body>\r\n" + 
					"</html>";
		}

		File_ file = new File_();
		try {
			file.WriteFile("data.txt", mainString, "UTF-8");
		} catch (IOException e) {
		}

		//System.out.println(mainString);
		return mainString;//CroppedIMG;
	}

	public String GetTxt() {
		return mainString;
	}

	public void AddToLN(String str) {
		String lnn = "";
		for (int i = 0; i < str.length(); i++) {
			String oneS = str.substring(i, i + 1);
			lnn += oneS;
			if (oneS.equals("\n")) {
				ln.add(lnn);
				lnn = "";
			}
		}
	}
}

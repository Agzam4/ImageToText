import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JTextArea;

public class Logic {
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
	
	public String /*BufferedImage*/ Convert(JTextArea textArea, int type, String fg) {
		
//		for (int x = 0; x < img.getWidth(); x++) {
//			for (int y = 0; y < img.getHeight(); y++) {
//				img.setRGB(x, y, Color.WHITE.getRGB());
//			}
//		}
		for (int i = 0; i < ln.size(); i++) {
			ln.remove(i);
		}
		
		AddToLN("\n" + textArea.getText() + "\n");
		
		img = new BufferedImage(((textArea.getText().length()+1) * textArea.getFont().getSize()),((ln.size()+1) * textArea.getFont().getSize()),  BufferedImage.TYPE_INT_RGB);
		
		Graphics graphics = img.getGraphics();
        Graphics2D g = (Graphics2D) graphics;
		
        g.setFont(textArea.getFont());
        

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, img.getWidth(), img.getHeight());
        g.setColor(new Color(Integer.parseInt(fg,16)));
        
        for (int i = 0; i < ln.size(); i++) {
//        	System.out.println(ln.get(i));
    		g.drawString(ln.get(i), 0, textArea.getFont().getSize() * i);
		}
        
        g.dispose();
        
        // CUTTING

        int height = img.getHeight();
        int width = img.getWidth();
        
        boolean allWhite = true;
        
        // HEIGHT
        
        for (int y = img.getHeight()-1; y > 0 ; y--) {
        	for (int x = 0; x < img.getWidth(); x++) {
        		if(allWhite) {
        			if(!(img.getRGB(x, y) == Color.WHITE.getRGB())) {
        				allWhite = false;
        			}
        		}
        	}
        	if(allWhite) {
        		height--;
        	}else {
        		y = 0;
        	}
        }
        
        // WIDTH
        
        allWhite = true;
        
        for (int x = img.getWidth()-1; x > 0 ; x--) {
        	for (int y = 0; y < img.getHeight(); y++) {
        		if(allWhite) {
        			if(!(img.getRGB(x, y) == Color.WHITE.getRGB())) {
        				allWhite = false;
        			}
        		}
        	}
//    		System.err.println(x + " " + allWhite + "");
        	if(allWhite) {
        		width--;
        	}else {
        		x = 0;
        	}
        }
        
        height += 4;
        width += 4;
//        System.out.println(width + " " + height);
        
        BufferedImage CroppedIMG = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < CroppedIMG.getHeight(); y++) {
        	for (int x = 0; x < CroppedIMG.getWidth(); x++) {
        		CroppedIMG.setRGB(x, y, img.getRGB(x, y));
        	}
        }
        
        img = CroppedIMG;
        
        // CREATING STRING
        
//        if(type == 0) {
//        	for (int y = 0; y < CroppedIMG.getHeight(); y++) {
//            	for (int x = 0; x < CroppedIMG.getWidth(); x++) {
//    				Color color = new Color(CroppedIMG.getRGB(x, y));
//    				int gray = (color.getRed() + color.getGreen() + color.getBlue())/3;
//    				double k = 300 / colors_x4.length; 
//    				//System.out.println(gray);
//
//    				mainString += colors_x4[(int) (gray/k)];
//    				mainString += colors_x4[(int) (gray/k)];
//    			}
//    			mainString += "\n";
//    		}
//        }
//        
//        if(type == 1) {
//        	for (int y = 0; y < CroppedIMG.getHeight()-1; y+=2) {
//            	for (int x = 0; x < CroppedIMG.getWidth(); x++) {
//    				double k = 255 / 1; 
//    				//System.out.println(gray);
//    				Color color = new Color(CroppedIMG.getRGB(x, y));
//    				int gray = (color.getRed() + color.getGreen() + color.getBlue())/3;
//    				int i1 = (int) (gray/k);
//    				color = new Color(CroppedIMG.getRGB(x, y+1));
//    				gray = (color.getRed() + color.getGreen() + color.getBlue())/3;
//    				int i2 = (int) (gray/k);
//    				
//    				int i = (i1 *2) + i2;
//    				
//    				mainString += colors_eco[3-i];
//    			}
//    			mainString += "\n";
//    		}
//        }
//
//        File_ file = new File_();
//        try {
//			file.WriteFile("data.txt", mainString, "UTF-8");
//		} catch (IOException e) {
//		}
//        
//		//System.out.println(mainString);
        
        LogicIMG imggg = new LogicIMG();
        
        return imggg.Convert(CroppedIMG, type);//CroppedIMG;
	}
	
	public String GetTxt() {
		return mainString;
	}
	
	private void AddToLN(String str) {
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

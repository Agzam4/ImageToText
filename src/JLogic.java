import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class JLogic extends JFrame {

	private JPanel contentPane;
	JProgressBar progressBar = new JProgressBar();
	JLabel info = new JLabel("Preparation for work");
	JLabel operation = new JLabel("Operation 1/2\u2588\u2580\u2584 \u2500");

	/**
	 * Launch the application.
	 */
	public static void main(String agrs[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLogic frame = new JLogic();
					frame.setVisible(true);
					frame.setBounds(100, 100, 450, 159);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public void Hide() {
		setVisible(false);
	}
	
	public JLogic() {
		Convert();
	}
	
	//public class Logic {
		public String[] colors_x4 = new String[] {
				"\u2588","\u2593","\u2592","\u2591",	
		};
		
		ArrayList<String> ln = new ArrayList<String>();
		
		String mainString = "";
		
		private int size = 500;
		
		BufferedImage img; 
		
		public String/**BufferedImage**/ Convert() {
			
			
			setUndecorated(true);
			
			
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");//UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (UnsupportedLookAndFeelException e) {
				e.printStackTrace();
			}
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 159);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			progressBar.setValue(0);
			progressBar.setBounds(15, 72, 398, 32);
			contentPane.add(progressBar);
			
			info.setHorizontalAlignment(SwingConstants.CENTER);
			info.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
			info.setBounds(15, 16, 398, 32);
			contentPane.add(info);
			
			operation.setHorizontalAlignment(SwingConstants.RIGHT);
			operation.setBounds(15, 120, 398, 20);
			contentPane.add(operation);
			
			
//			for (int x = 0; x < img.getWidth(); x++) {
//				for (int y = 0; y < img.getHeight(); y++) {
//					img.setRGB(x, y, Color.WHITE.getRGB());
//				}
//			}
			
			info.setText("Preparation for work");
			progressBar.setMaximum(ln.size());
			
			for (int i = 0; i < ln.size(); i++) {
				ln.remove(i);
				progressBar.setValue(i);
			}
			
			
			// Converting to pixels

			info.setText("Converting to pixels");
			progressBar.setMaximum(ln.size());
			
//			Graphics graphics = img.getGraphics();
//	        Graphics2D g = (Graphics2D) graphics;
//			
//	        
//
//	        g.setColor(Color.WHITE);
//	        g.fillRect(0, 0, img.getWidth(), img.getHeight());
//	        g.setColor(Color.BLACK);
//	        
//	        for (int i = 0; i < ln.size(); i++) {
//	        	System.out.println(ln.get(i));
//				progressBar.setValue(i);
//			}
//	        
//	        g.dispose();
	        
	        // CUTTING
	        

			info.setText("Cutting");
			progressBar.setMaximum((img.getHeight()*2) + (img.getWidth() * 2));

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

					progressBar.setValue(progressBar.getValue() + 1);
	        	}
	        	if(allWhite) {
	        		height--;
	        	}else {
	        		y = 0;
	        	}
	        }
	        
	        progressBar.setValue(progressBar.getMaximum()/2);
	        
	        // WIDTH
	        
	        allWhite = true;
	        
	        for (int x = img.getWidth()-1; x > 0 ; x--) {
	        	for (int y = 0; y < img.getHeight(); y++) {
	        		if(allWhite) {
	        			if(!(img.getRGB(x, y) == Color.WHITE.getRGB())) {
	        				allWhite = false;
	        			}
	        		}
					progressBar.setValue(progressBar.getValue() + 1);
	        	}
	    		System.err.println(x + " " + allWhite + "");
	        	if(allWhite) {
	        		width--;
	        	}else {
	        		x = 0;
	        	}
	        }
	        
	        progressBar.setValue(progressBar.getMaximum());
	        
	        height += 4;
	        width += 4;
	        System.out.println(width + " " + height);
	        
			info.setText("Cutting");
			progressBar.setMaximum((img.getHeight()*2) + (img.getWidth() * 2));
	        
	        BufferedImage CroppedIMG = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	        for (int y = 0; y < CroppedIMG.getHeight(); y++) {
	        	for (int x = 0; x < CroppedIMG.getWidth(); x++) {
	        		CroppedIMG.setRGB(x, y, img.getRGB(x, y));
					progressBar.setValue(progressBar.getValue() + 1);
	        	}
	        }
	        
	        img = CroppedIMG;
	        
	        
	        for (int y = 0; y < CroppedIMG.getHeight(); y++) {
	        	for (int x = 0; x < CroppedIMG.getWidth(); x++) {
					Color color = new Color(CroppedIMG.getRGB(x, y));
					int gray = (color.getRed() + color.getGreen() + color.getBlue())/3;
					double k = 300 / colors_x4.length; 
					//System.out.println(gray);

					mainString += colors_x4[(int) (gray/k)];
					mainString += colors_x4[(int) (gray/k)];
				}
				mainString += "\n";
			}
	        

			info.setText("Creating a document");
			progressBar.setMaximum(100);
			progressBar.setValue(50);
	        
	        File_ file = new File_();
	        try {
				file.WriteFile("data.txt", mainString, "UTF-8");
			} catch (IOException e) {
			}
	        
			//System.out.println(mainString);
			
	        info.setText("");
			progressBar.setMaximum(0);
			progressBar.setValue(0);
			
			JComboBox comboBox = new JComboBox(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
			//comboBox.setModel(new DefaultComboBoxModel(new String[] {"123"}));
			comboBox.setBounds(32, 16, 298, 26);
			contentPane.add(comboBox);

	        return null;
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

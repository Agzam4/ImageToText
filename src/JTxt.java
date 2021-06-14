import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ItemEvent;
import javax.swing.JTextField;

public class JTxt extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> family;
	private JComboBox<String> mode;
	private JTextField size;
	private JTextField colorHeX;

	private String mainString = "";
	
	private BufferedImage loading;
	private BufferedImage demo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTxt frame = new JTxt();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JTxt() {
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton exit = new JButton("\u2A2F");
		exit.setForeground(Color.WHITE);
		exit.setFont(new Font("Cambria Math", Font.PLAIN, 25));
		exit.setMargin(new Insets(2, 2, 2, 2));
		exit.setBounds(500, 0, 50, 30);
		contentPane.add(exit);
		
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
		});
		
		JButton info = new JButton("\uD835\uDCF2");
		info.setForeground(Color.WHITE);
		info.setFont(new Font("Cambria Math", Font.PLAIN, 20));
		info.setMargin(new Insets(2, 2, 2, 2));
		info.setBounds(450, 0, 50, 30);
		contentPane.add(info);
		
		info.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JInfo info = new JInfo();
				info.main();
			}
		});
		
		WindowsButtons buttons = new WindowsButtons();
		buttons.ConvertToWindowsButton(exit, new Color(255,75,75), Color.DARK_GRAY, new Color(150,75,75));
		buttons.ConvertToWindowsButton(info, new Color(75,155,255), Color.DARK_GRAY, new Color(25,105,205));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBounds(15, 45, 520, 169);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		textArea.setText("by Agzam4");
		textArea.setBorder(new EmptyBorder(5, 5, 5, 5));
		scrollPane.setViewportView(textArea);
		
		JButton ok = new JButton("Преобразовать");
		ok.setBounds(330, 374, 205, 26);
		contentPane.add(ok);
		
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Thread T = new Thread() {
					@Override
					public void run() {
						Logic logic = new Logic();
						mainString = logic.Convert(textArea, mode.getSelectedIndex(), colorHeX.getText());
						JOptionPane.showMessageDialog(null, "Ready!!!", "", 1);
						FC_Save(mainString);
					}
				};
				T.start();
				JOptionPane.showMessageDialog(null, "Creating doc", "Please wait", 2);
			}
		});
		
		JLabel menu123 = new JLabel("    Text Images (Offline Creator) - by Agzam4");
		menu123.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		menu123.setForeground(Color.WHITE);
		menu123.setBackground(new Color(65, 65, 65));
		menu123.setOpaque(true);
		menu123.setBounds(0, 0, 450, 30);
		contentPane.add(menu123);
		
		// SETTINGS OF IMAGE (SOI)
		
		JLabel txtJLabel = new JLabel("Текст:");
		txtJLabel.setBounds(330, 345, 205, 20);
		contentPane.add(txtJLabel);

		JLabel imageJLabel = new JLabel("Картинка");
		imageJLabel.setBounds(330, 230, 205, 20);
		contentPane.add(imageJLabel);

		JLabel imgDemo = new JLabel("");
		imgDemo.setBounds(330, 255, 65, 80);
		contentPane.add(imgDemo);
		
		demo = new BufferedImage(imgDemo.getWidth(), imgDemo.getHeight(), BufferedImage.TYPE_INT_RGB/*TYPE_BYTE_GRAY);/*/);
		imgDemo.setIcon(new ImageIcon(demo));
		
		JButton loadIMG = new JButton("Загрузить картинку");
		loadIMG.setMargin(new Insets(0, 0, 0, 0));
		loadIMG.setBounds(400, 255, 130, 40);
		contentPane.add(loadIMG);
		
		loadIMG.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FC_Open();
				
				Graphics graphics = demo.getGraphics();
				Graphics2D g = (Graphics2D) graphics;
				
				g.drawImage(loading, 0, 0, demo.getWidth(), demo.getHeight(), null);
				
				g.dispose();
				
				imgDemo.setIcon(new ImageIcon(demo));
			}
		});
		
		JButton okIMG = new JButton("Преобразовать");
		okIMG.setBounds(400, 295, 130, 40);
		contentPane.add(okIMG);
		
		okIMG.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(loading == null) {
					JOptionPane.showMessageDialog(null, "Загрузите картинку!", "", 2);
				}else {
					Thread T = new Thread() {
						@Override
						public void run() {
							LogicIMG logic = new LogicIMG();
							mainString = logic.Convert(loading, mode.getSelectedIndex());
							JOptionPane.showMessageDialog(null, "Ready!!!", "", 1);
							FC_Save(mainString);
						}
					};
					T.start();
					JOptionPane.showMessageDialog(null, "Creating doc", "Please wait", 1);
				}
			}
		});

		
		// SETTING OF FONT (SOF)
		
		JPanel sof = new JPanel();
		sof.setBackground(new Color(230, 230, 230));
		sof.setBounds(15, 230, 300, 130);
		contentPane.add(sof);
		sof.setLayout(null);
		
		JLabel sofJLablel = new JLabel("   Settings of Font:");
		sofJLablel.setBackground(new Color(210, 210, 210));
		sofJLablel.setOpaque(true);
		sofJLablel.setBounds(0, 0, 300, 30);
		sof.add(sofJLablel);
		
		JLabel familyJLablel = new JLabel("Family:");
		familyJLablel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		familyJLablel.setBounds(10, 40, 62, 20);
		sof.add(familyJLablel);
		

		family = new JComboBox<String>(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
		family.setBorder(new EmptyBorder(0, 0, 0, 0));
		family.setSelectedIndex(162);
		family.setEditable(true);
		family.setBounds(75, 37, 210, 26);
		sof.add(family);
		
		JLabel styleJLablel = new JLabel("Style:");
		styleJLablel.setBounds(10, 70, 69, 20);
		sof.add(styleJLablel);
		
		JComboBox<String> style = new JComboBox<String>();
		style.setBorder(new EmptyBorder(0, 0, 0, 0));
		style.setModel(new DefaultComboBoxModel<String>(new String[] {"PLAIN", "BOLD", "ITLIC", "BOLD ITALIC"}));
		style.setSelectedIndex(0);
		style.setBounds(75, 67, 127, 26);
		sof.add(style);
		
		style.setFocusable(false);
		style.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				textArea.setFont(new Font("Trebuchet MS", style.getSelectedIndex(), 15));
			}
		});
		
		JLabel sizeJLabel = new JLabel("Size:");
		sizeJLabel.setBounds(10, 100, 69, 15);
		sof.add(sizeJLabel);
		
		size = new JTextField();
		size.setText("15");
		size.setBorder(new EmptyBorder(0, 5, 0, 5));
		PlainDocument doc = (PlainDocument) size.getDocument();
		doc.setDocumentFilter(new DigitFilter());
		size.setBounds(75, 97, 75, 24);
		sof.add(size);
		size.setColumns(10);
		
		JLabel colorT = new JLabel("Color:");
		colorT.setBounds(165, 100, 69, 15);
		sof.add(colorT);
		
		colorHeX = new JTextField();
		colorHeX.setText("000");
		colorHeX.setBorder(new EmptyBorder(0, 5, 0, 5));
		PlainDocument doc2 = (PlainDocument) colorHeX.getDocument();
		doc2.setDocumentFilter(new HexFilter());
		colorHeX.setBounds(205, 97, 75, 24);
		sof.add(colorHeX);
		size.setColumns(10);
		
		mode = new JComboBox<String>();
		mode.setFocusable(false);
		mode.setModel(new DefaultComboBoxModel<String>(new String[] {"Классический", "Экономный", "BBCode для форумов", "HTML"}));
		mode.setBounds(76, 374, 239, 26);
		contentPane.add(mode);
		
		JLabel modeJLabel = new JLabel("Режим:");
		modeJLabel.setBounds(15, 376, 69, 20);
		contentPane.add(modeJLabel);
		
		family.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				try {
					textArea.setFont(new Font("" + family.getSelectedItem(), textArea.getFont().getStyle(), textArea.getFont().getSize()));
				} catch (Exception e) {
				}
			}
		});
		
		size.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				SetSize(textArea);
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				SetSize(textArea);
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});
		
		Dragged dragged = new Dragged();
		dragged.SetJFrame(this, false);
	}

	private void SetSize(JTextArea textArea) {
		try {
			int size2 = Integer.valueOf(size.getText());
			textArea.setFont(new Font(textArea.getFont().getFamily(), textArea.getFont().getStyle(), size2));
		} catch (Exception e) {
		}
	}
	
	class DigitFilter extends DocumentFilter {
	    private static final String DIGITS = "\\d+";

	    @Override
	    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
	    	if (string.matches(DIGITS)) {
	    		super.insertString(fb, offset, String.valueOf(Integer.valueOf(string)), attr);
	    	}
	    }
	    
	    @Override
	    public void replace(FilterBypass fb, int offset, int length, String string, AttributeSet attrs) throws BadLocationException {
	    	if (string.matches(DIGITS)) {
	    		super.replace(fb, offset, length, string, attrs);
	    	}
	    }
	}
	
	
	class HexFilter extends DocumentFilter {
	    private static final String DIGITS = "0?1?2?3?4?5?6?7?6?9?A?B?C?D?E?F?";//"\\d+?A?B?C?D?E?F?";

	    @Override
	    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
	    	if (string.toUpperCase().matches(DIGITS)) {
	    		super.insertString(fb, offset, String.valueOf(Integer.valueOf(string)).toUpperCase(), attr);
	    	}
	    }
	    
	    @Override
	    public void replace(FilterBypass fb, int offset, int length, String string, AttributeSet attrs) throws BadLocationException {
	    	if (string.toUpperCase().matches(DIGITS)) {
	    		super.replace(fb, offset, length, string.toUpperCase(), attrs);
	    	}
	    }
	}
	
	private void FC_Open() {
		JFileChooser fc = new JFileChooser();
		fc.setDialogTitle("Открыть файл");
		if(fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
			try {
				File file = new File(String.valueOf(fc.getSelectedFile()));
				loading = ImageIO.read(file);
				File output = new File(String.valueOf("data.png"));
				try {
					ImageIO.write(loading, "png", output);
				}catch (Exception e) {
				}
			} catch (Exception e1) {
			}
		}
	}
	
	private void FC_Save(String txt) {
		JFileChooser fc = new JFileChooser();
		 fc.setDialogTitle("Сохранить файл");
		 if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION ) {
			 File_ file = new File_();
			 try {
				 String[] names = new String[] {
						 "txt","txt","txt","html"
				 };
				file.WriteFile(fc.getSelectedFile() + "." + names[mode.getSelectedIndex()], txt, "UTF-8");
			} catch (IOException e) {
				System.err.println("Ошибка сохранения:\n" + fc.showSaveDialog(null) + "\n" + JFileChooser.APPROVE_OPTION );
			}
	     }
	}
}

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class JInfo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JInfo frame = new JInfo();
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
	public JInfo() {
		setResizable(false);
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 467, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JTextArea txtrTextImages = new JTextArea();
		txtrTextImages.setText(" \u25A3\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A3\r\n  \t  Text Images (Offline Creator)\r\n \u25A3\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A4\u25A3\r\n\u25AD \u0427\u0442\u043E \u0434\u0435\u043B\u0430\u0435\u0442: \u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\r\n \u25C8 \u0421\u043E\u0437\u0434\u0430\u0435\u0442 \u0440\u0438\u0441\u0443\u043D\u043A\u0438 \u0438\u0437 \u0441\u0438\u043C\u0432\u043E\u043B\u043E\u0432\r\n\u25AD \u0427\u0442\u043E \u043C\u043E\u0436\u0435\u0442: \u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\r\n \u25C8 \u041F\u0435\u0440\u043E\u0431\u0440\u0430\u0437\u043E\u0432\u044B\u0432\u0430\u0442\u044C \u043A\u0430\u043A \u0440\u0438\u0441\u0443\u043D\u043A\u0438, \u0442\u0430\u043A \u0438 \u0442\u0435\u043A\u0441\u0442\r\n \u25C8 \u041F\u0440\u0435\u043E\u0431\u0440\u0430\u0437\u043E\u0432\u044B\u0432\u0430\u0442\u044C \u0442\u0435\u043A\u0441\u0442 \u0440\u0430\u0437\u043D\u044B\u0445 \u0448\u0440\u0438\u0444\u0442\u043E\u0432,\r\n     \u0440\u0430\u0437\u043C\u0435\u0440\u043E\u0432, \u0441\u0442\u0438\u043B\u044F\r\n\u25AD \u0420\u0435\u0436\u0438\u043C\u044B: \u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\r\n \u25C8 \u041A\u043B\u0430\u0441\u0441\u0438\u0447\u0435\u0441\u043A\u0438\u0439:\r\n  \u2014 4 \u0446\u0432\u0435\u0442\u0430\r\n  \u2014 \u0420\u0430\u0437\u043C\u0435\u0440 \u043F\u0438\u043A\u0441\u0435\u043B\u044F: 2 \u0441\u0438\u043C\u0432\u043E\u043B\u0430\r\n \u25C8 \u042D\u043A\u043E\u043D\u043E\u043C\u043D\u044B\u0439\r\n  \u2014 2 \u0446\u0432\u0435\u0442\u0430\r\n  \u2014 \u0420\u0430\u0437\u043C\u0435\u0440 \u043F\u0438\u043A\u0441\u0435\u043B\u044F: 0.5 \u0441\u0438\u043C\u0432\u043E\u043B\u0430\r\n \u25C8 BBcode\r\n  \u2014 \u0412\u0441\u0435 \u0446\u0432\u0435\u0442\u0430\r\n  \u2014 \u0420\u0430\u0437\u043C\u0435\u0440 \u043F\u0438\u043A\u0441\u0435\u043B\u044F: 2 \u0441\u0438\u043C\u0432\u043E\u043B\u0430\r\n \u25C8 HTML\r\n  \u2014 \u0412\u0441\u0435 \u0446\u0432\u0435\u0442\u0430\r\n  \u2014 \u0420\u0430\u0437\u043C\u0435\u0440 \u043F\u0438\u043A\u0441\u0435\u043B\u044F: 2 \u0441\u0438\u043C\u0432\u043E\u043B\u0430\r\n  \u2014 \u0421\u043E\u0437\u0434\u0430\u0435\u0442 HTML \u0434\u043E\u043A\u0443\u043C\u0435\u043D\u0442\r\n\u25AD \u0427\u0442\u043E \u043D\u043E\u0432\u043E\u0433\u043E: \u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\u25AD\r\n \u25C8 \u041C\u043E\u0436\u043D\u043E \u043F\u0440\u0435\u043E\u0431\u0440\u0430\u0437\u043E\u0432\u044B\u0432\u0430\u0442\u044C \u0440\u0438\u0441\u0443\u043D\u043A\u0438\r\n\r\n V4.3");
		txtrTextImages.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtrTextImages.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		txtrTextImages.setBorder(new EmptyBorder(5, 5, 5, 5));
		txtrTextImages.setFocusable(false);
		scrollPane.setViewportView(txtrTextImages);
		
		txtrTextImages.setCaretPosition(0);
	}

}

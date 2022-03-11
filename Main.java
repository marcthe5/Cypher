package Cypher;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Cursor;
import javax.swing.border.LineBorder;
import java.awt.Window.Type;
/* 
 * PROJECT NAME : CYPHER
 * DEV : MAC
 * DATE DEV : 03/06/22
 */
public class Main extends JFrame {
    
	//FIELDS
	private JPanel contentPane;
    
	protected String text;
	protected String encrypt;
	protected int i;
	private JTextPane stringText;
	protected static String figures[] = {"1","2","3","4","5","6","7","8","9","0"};
	protected static char textChar;
    LinkedList<String> list = new LinkedList<String>();
    protected static int ascii;
    protected static char asciiText;
    protected static String res;

    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setType(Type.UTILITY);
		setTitle("CYPHER");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 492);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		stringText = new JTextPane();
		stringText.setBounds(6, 13, 543, 187);
		contentPane.add(stringText);
		
	
		
		JTextPane encryptedText = new JTextPane();
		encryptedText.setForeground(Color.BLACK);
		encryptedText.setBackground(Color.LIGHT_GRAY);
		encryptedText.setBounds(6, 262, 544, 190);
		contentPane.add(encryptedText);
		
		JButton button = new JButton("ENCRYPT");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setBorder(null);
		button.setForeground(Color.BLACK);
		button.setBackground(Color.WHITE);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				text = stringText.getText();
	
				encryption(text,list);
				encryptedText.setText(res);
				
				list.clear();
			}
		});
		
		
		button.setFont(new Font("Segoe UI", Font.BOLD, 16));
		button.setBounds(100, 212, 143, 39);
		contentPane.add(button);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				list.clear();
			    stringText.setText(null);
			    encryptedText.setText(null);
			}
		});
		btnClear.setFocusPainted(false);
		btnClear.setBackground(Color.DARK_GRAY);
		btnClear.setForeground(Color.WHITE);
		btnClear.setBorder(new LineBorder(Color.WHITE));
		btnClear.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnClear.setBounds(308, 212, 143, 39);
		contentPane.add(btnClear);
	}
	
	
    //algorithms
	public static String encryption (String str, LinkedList<String> list) {
		for(String fig : figures) {
		if (!str.contains(fig)) {
			for(int i=0; i<str.length(); i++) {
			textChar = str.charAt(i);
			ascii = (int)textChar;
			
			//encryption - true
			ascii = ascii-3;
			asciiText = (char) ascii;
			list.add(String.valueOf(asciiText));
			res = list.toString();
			res = res.substring(1, res.length() - 1);
			res = String.valueOf(res.replaceAll(" ",""));
			res = String.valueOf(res.replaceAll(",",""));
			
			}
			return res;
		}
		else {
			//return false
			res = null;
			return res;

		}
		}
		return res;
		
	}
}

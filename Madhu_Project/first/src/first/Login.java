package first;

import java.sql.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	
	private Connection con;
	private Statement st,st1,st2;
	private ResultSet rs,rs1,rs2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 1317, 778);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserId         :");
		lblNewLabel.setBackground(new Color(240, 128, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(334, 276, 219, 45);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(624, 273, 288, 48);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password       :");
		lblNewLabel_1.setBackground(new Color(255, 0, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(334, 382, 219, 45);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(624, 379, 288, 48);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?autoReconnect=true&serverTimezone=UTC&useSSL=False&allowPublicKeyRetrieval=true","root","");
						st = con.createStatement();
						
						int i=1;
						String sql = "select studentId from student where studentId = '"+textField.getText()+"' and Password = '"+passwordField.getText()+"'";
						rs=st.executeQuery(sql);
						
						if(rs.next()) {
							String sn = rs.getString(1);
							String[] arr = new String[1];
							arr[0] = sn;										
							StudentPortal.main(arr);
							dispose();
						}else if(i==1){						
									st1 = con.createStatement();
									String sql1 = "select facultyId from faculty where facultyId = '"+textField.getText()+"' and Password = '"+passwordField.getText()+"'";
									rs1=st1.executeQuery(sql1);
						
									if(rs1.next()) {
										String fn = rs1.getString(1);
										String[] arr = new String[1];
										arr[0] = fn;										
										FacultyPortal.main(arr);
										dispose();
									}else if(i==1){						
												st2 = con.createStatement();
												String sql2 = "select UserId from admin where UserId = '"+textField.getText()+"' and Password = '"+passwordField.getText()+"'";
												rs2=st2.executeQuery(sql2);
						
												if(rs2.next()) {								
													String an = rs2.getString(1);
													String[] arr = new String[1];
													arr[0] = an;										
													AdminPortal.main(arr);
													dispose();
												}else
													JOptionPane.showMessageDialog(null, "invalid user id or password..... ");
									}
						
						}
					
				}catch (Exception ex) {
					System.out.println("Erro : "+ex);
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 32));
		btnNewButton.setBackground(new Color(34, 139, 34));
		btnNewButton.setBounds(501, 508, 203, 55);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.main(null);
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(220, 20, 60));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_1.setBounds(10, 10, 107, 38);
		contentPane.add(btnNewButton_1);
	}
}

package first;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.*;
import java.sql.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;

public class FacultyPortal extends JFrame {

	private JPanel contentPane;

	private String fnn;
	private Connection con;
	private Statement st1,st2;
	private ResultSet rs1,rs2;	
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacultyPortal frame = new FacultyPortal(args[0]);
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
	public FacultyPortal(String fn) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 1317, 778);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add Marks");
		btnNewButton.setBackground(new Color(154, 205, 50));
		btnNewButton.setForeground(new Color(139, 69, 19));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.setBounds(542, 242, 202, 57);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add Attendance");
		btnNewButton_1.setBackground(new Color(154, 205, 50));
		btnNewButton_1.setForeground(new Color(139, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1.setBounds(542, 374, 202, 57);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Student Details");
		btnNewButton_2.setBackground(new Color(154, 205, 50));
		btnNewButton_2.setForeground(new Color(139, 0, 0));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(542, 512, 202, 57);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("LogOut");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login.main(null);
				dispose();
				
			}
		});
		btnNewButton_3.setForeground(Color.RED);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_3.setBounds(1166, 37, 110, 42);
		contentPane.add(btnNewButton_3);
		

		

		try {	Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?autoReconnect=true&serverTimezone=UTC&useSSL=False&allowPublicKeyRetrieval=true","root","");
			st1 = con.createStatement();
			
			String sql = "select facultyName from faculty where facultyId = '"+fn+"'";
			rs1 = st1.executeQuery(sql);
			if(rs1.next()) {
				lblNewLabel = new JLabel("Hi "+rs1.getString(1));
				lblNewLabel.setForeground(Color.MAGENTA);
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblNewLabel.setBounds(102, 61, 449, 57);
				contentPane.add(lblNewLabel);
			}
		}catch (Exception ex) {
			System.out.println("Erro : "+ex);
		}	
		

	}
}

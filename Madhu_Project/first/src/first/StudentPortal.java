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
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class StudentPortal extends JFrame {

	private JPanel contentPane;
	private JLabel username;
	
	private Connection con;
	private Statement st1,st2;
	private ResultSet rs1,rs2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentPortal frame = new StudentPortal(args[0]);
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
	public StudentPortal(String sn) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 1317, 778);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Menu.selectionBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Select Course");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 18));
		btnNewButton.setBounds(380, 323, 249, 46);
		contentPane.add(btnNewButton);
		
		JButton btnDropCourse = new JButton("Drop Course");
		btnDropCourse.setBackground(new Color(0, 255, 0));
		btnDropCourse.setForeground(new Color(0, 0, 0));
		btnDropCourse.setFont(new Font("Tahoma", Font.ITALIC, 18));
		btnDropCourse.setBounds(380, 418, 249, 46);
		contentPane.add(btnDropCourse);
		
		JButton btnCheckCourses = new JButton("Check courses");
		btnCheckCourses.setBackground(new Color(0, 255, 0));
		btnCheckCourses.setForeground(new Color(0, 0, 0));
		btnCheckCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCheckCourses.setFont(new Font("Tahoma", Font.ITALIC, 18));
		btnCheckCourses.setBounds(734, 323, 249, 46);
		contentPane.add(btnCheckCourses);
		
		JButton btnGradeCard = new JButton("Grade Card");
		btnGradeCard.setBackground(new Color(0, 255, 0));
		btnGradeCard.setForeground(new Color(0, 0, 0));
		btnGradeCard.setFont(new Font("Tahoma", Font.ITALIC, 18));
		btnGradeCard.setBounds(380, 512, 249, 46);
		contentPane.add(btnGradeCard);
		
		JButton btnNewButton_1 = new JButton("Check Attendance");
		btnNewButton_1.setBackground(new Color(0, 255, 0));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.ITALIC, 18));
		btnNewButton_1.setBounds(734, 418, 249, 46);
		contentPane.add(btnNewButton_1);
		
		JButton btnUpdateProfile = new JButton("Change Password");
		btnUpdateProfile.setBackground(new Color(0, 255, 0));
		btnUpdateProfile.setForeground(new Color(0, 0, 0));
		btnUpdateProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UpdateProfile.main(null);
				dispose();
			}
		});
		btnUpdateProfile.setFont(new Font("Tahoma", Font.ITALIC, 18));
		btnUpdateProfile.setBounds(734, 509, 249, 52);
		contentPane.add(btnUpdateProfile);
		
		JButton btnLogout = new JButton("LogOut");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				dispose();
				
			}
		});
		btnLogout.setBackground(new Color(255, 0, 0));
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogout.setBounds(1156, 10, 137, 36);
		contentPane.add(btnLogout);
		
		try {	
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?autoReconnect=true&serverTimezone=UTC&useSSL=False&allowPublicKeyRetrieval=true","root","");
			st1 = con.createStatement();
		
			String sql = "select studentName from student where studentId = '"+sn+"'";
			rs1 = st1.executeQuery(sql);
			if(rs1.next()) {
				username = new JLabel("Hi, "+rs1.getString(1));
				username.setForeground(Color.MAGENTA);
				username.setFont(new Font("Tahoma", Font.BOLD, 20));
				username.setBounds(88, 40, 559, 72);
				contentPane.add(username);
		}
	}catch (Exception ex) {
		System.out.println("Erro : "+ex);
	}	

	}
}

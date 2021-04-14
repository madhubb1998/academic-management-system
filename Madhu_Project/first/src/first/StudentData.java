package first;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.*;
import java.sql.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.DriverManager;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class StudentData extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	private Connection con;
	private Statement st1,st2;
	private ResultSet rs1,rs2;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentData frame = new StudentData();
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
	public StudentData() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 1317, 778);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?autoReconnect=true&serverTimezone=UTC&useSSL=False&allowPublicKeyRetrieval=true","root","");
			
			int  length = 0;
			st1 = con.createStatement();
			String sql = "select * from student";
			rs1 = st1.executeQuery(sql);
			
			while(rs1.next()) {
				length++;
			}
			
			int i=0;
			Object[][] data = new Object[length][8];
			st2 = con.createStatement();
			String sql1 = "select studentId,studentName,courseId,courseName,Department,branch,semester,Attendance from student";
			rs2 = st2.executeQuery(sql1);
			while(rs2.next()) {
				data[i][0] = i+1;
				data[i][1] = rs2.getString(1);
				data[i][2] = rs2.getString(2);
				data[i][3] = rs2.getString(3);
				data[i][4] = rs2.getString(4);
				data[i][5] = rs2.getString(5);
				data[i][6] = rs2.getString(6);
				data[i][7] = rs2.getString(7);
				i++;
			}
			
			String[] columns = {"S.no", "StudentId", "StudentName", "CourseId", "CourseName", "Department", "Branch", "Semester","Attendance"};
			
		    scrollPane = new JScrollPane();
		    scrollPane.setBounds(39, 121, 1220, 589);
		    contentPane.add(scrollPane);
		
		    table = new JTable(data,columns);
		    scrollPane.setViewportView(table);
		
		}catch (Exception ex) {
			System.out.println("Erro : "+ex);
		}
		
		JLabel lblNewLabel = new JLabel("Student Details");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setBounds(473, 50, 312, 50);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(23, 21, 128, 50);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("logout");
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBounds(1106, 21, 153, 50);
		contentPane.add(btnNewButton_1);
	}
}

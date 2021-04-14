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
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.DriverManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FacultyData extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
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
					FacultyData frame = new FacultyData();
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
	public FacultyData() {
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
			String sql = "select * from faculty";
			rs1 = st1.executeQuery(sql);
			
			if(rs1.next()) {
				length++;
			}
			
			int i=0;
			Object[][] data = new Object[length][8];
			st2 = con.createStatement();
			String sql1 = "select facultyId, facultyName, course, Department, mobile, email, office from faculty";
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
			
			String[] columns = {"S.no", "Facluty Id", "Faculty Name", "Course", "Department", "Mobile", "Email", "Office"};
			
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 159, 1207, 572);
		contentPane.add(scrollPane);
		
		table = new JTable(data, columns);
		scrollPane.setViewportView(table);
		}catch (Exception ex) {
			System.out.println("Erro : "+ex);
		}
		
		JLabel lblNewLabel = new JLabel("Faculty details");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(524, 70, 354, 53);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home.main(null);
				dispose();
			}
		});
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(1169, 29, 103, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPortal.main(null);
				dispose();
			}
		});
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(23, 29, 103, 41);
		contentPane.add(btnNewButton_1);
	}
}

package first;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class DropCourse extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private Statement st,st1;
	private Connection con;
	private ResultSet rs,rs1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DropCourse frame = new DropCourse();
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
	public DropCourse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 1317, 778);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Course Id           :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(116, 219, 174, 36);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(312, 219, 215, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Drop");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(211, 333, 137, 47);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPortal.main(null);
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(255, 99, 71));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton_1.setBounds(10, 0, 96, 43);
		contentPane.add(btnNewButton_1);
		
		JButton btnLogout = new JButton("LogOut");
		btnLogout.setForeground(new Color(255, 0, 0));
		btnLogout.setBackground(new Color(240, 248, 255));
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnLogout.setBounds(1182, 0, 111, 43);
		contentPane.add(btnLogout);
		
		JLabel lblNewLabel_1 = new JLabel("Dropping Course");
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(514, 2, 287, 36);
		contentPane.add(lblNewLabel_1);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?autoReconnect=true&serverTimezone=UTC&useSSl=False&allowPublicKeyRetrieval=true","root","");
			st = con.createStatement();
			String sql = "select * from courses";
			rs = st.executeQuery(sql);
			
			int length = 0;
			while(rs.next()) {
				length++;
			}
			
			int i = 0;
			Object[][] data = new Object[length][3];
			st1 = con.createStatement();
			String sql1 = "select * from courses";
			rs1 = st1.executeQuery(sql1);
			while(rs1.next()) {
				data[i][0] = rs1.getString(1);
				data[i][1] = rs1.getString(2);
				data[i][2] = rs1.getString(3);
				i++;
			}	
			
			String [] columns = { "course Id","courseName","credit"};
			
			

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(627, 122, 506, 498);
			contentPane.add(scrollPane);
			
			table = new JTable(data,columns);
			scrollPane.setViewportView(table);
				
		}catch(Exception e){
			System.out.println("err :"+e);
				
			}
		}
		
		
	}



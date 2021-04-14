package first;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.util.*;
import java.sql.*;
import javax.swing.*;

import javax.swing.*;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AdminPortal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel name;

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
					AdminPortal frame = new AdminPortal(args[0]);
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
	public AdminPortal(String an) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 1317, 778);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 128, 114));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("LogOut");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login.main(null);
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton_1.setBounds(1181, 0, 122, 46);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(501, 226, 292, 61);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setIcon(new ImageIcon("D:\\PROJECT IMAGES\\Webp.net-resizeimage (1).png"));
		btnNewButton.setBounds(793, 226, 51, 61);
		contentPane.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"     --STUDENT--", "ADD STUDENT", "REMOVE STUDENT", "STUDENT DETAILS"}));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(e.getSource()==comboBox) {
					 if(comboBox.getSelectedItem().equals("ADD STUDENT")) {
						 AddStudent.main(null);
						 dispose();
					 }else if(comboBox.getSelectedItem().equals("REMOVE STUDENT")) {
						 RemoveStudent.main(null);
						 dispose();
                        
					 }else if(comboBox.getSelectedItem().equals("STUDENT DETAILS")) {
						 StudentData.main(null);
						 dispose();
					 }
				 }
				
				
				
			}
		});
		comboBox.setBounds(129, 442, 246, 46);
		contentPane.add(comboBox);
		
		JComboBox comboBox1 = new JComboBox();
		comboBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==comboBox1) {
					 if(comboBox1.getSelectedItem().equals("ADD FACULTY")) {
						 AddFaculty.main(null);
						 dispose();
					 }else if(comboBox1.getSelectedItem().equals("REMOVE FACULTY")) {
						 RemoveFaculty.main(null);
						 dispose();
                       
					 }else if(comboBox1.getSelectedItem().equals("FACULTY LIST")) {
						 FacultyData.main(null);
						 dispose();
					 }
				 }
				
			}
		});
		comboBox1.setModel(new DefaultComboBoxModel(new String[] {"    --FACULTY--", "ADD FACULTY", "REMOVE FACULTY", "FACULTY LIST"}));
		comboBox1.setFont(new Font("Tahoma", Font.BOLD, 18));
		comboBox1.setBounds(501, 442, 246, 46);
		contentPane.add(comboBox1);
		
		JComboBox comboBox2 = new JComboBox();
		comboBox2.setModel(new DefaultComboBoxModel(new String[] {"    --COURSE--", "ADD COURSE", "REMOVE COURSE", "COURSE LIST"}));
		comboBox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==comboBox2) {
					 if(comboBox2.getSelectedItem().equals("ADD COURSE")) {
						 AddCourse.main(null);
						 dispose();
					 }else if(comboBox2.getSelectedItem().equals("REMOVE COURSE")) {
						DropCourse.main(null);
						 dispose();
		               
					 }else if(comboBox2.getSelectedItem().equals("COURSE LIST")) {
						 CourseList.main(null);
						 dispose();
					 }
				 }
				
			}
			
		});
		
		
		comboBox2.setFont(new Font("Tahoma", Font.BOLD, 18));
		comboBox2.setBounds(864, 442, 246, 46);
		contentPane.add(comboBox2);
		
		try {	
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?autoReconnect=true&serverTimezone=UTC&useSSL=False&allowPublicKeyRetrieval=true","root","");
			st1 = con.createStatement();
		
		String sql = "select Name from admin where UserId = '"+an+"'";
		rs1 = st1.executeQuery(sql);
		if(rs1.next()) {
			name = new JLabel("Hi "+rs1.getString(1));
			name.setForeground(Color.BLUE);
			name.setFont(new Font("Tahoma", Font.BOLD, 20));
			name.setBounds(62, 41, 525, 61);
			contentPane.add(name);
		}
	}catch (Exception ex) {
		System.out.println("Erro : "+ex);
	}	

	}
}

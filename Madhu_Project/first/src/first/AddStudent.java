package first;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddStudent extends JFrame {

	private JPanel contentPane;
	private JTextField sid;
	private JTextField sname;
	private JTextField dob;
	private JTextField fname;
	private JTextField mobile;
	private JTextField mname;
	private JTextField programming;
	private JTextField dept;
	private JTextField c2;
	private JTextField branch;
	private JTextField c1;
	private JTextField c3;
	private JTextField sem;
	
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
					AddStudent frame = new AddStudent();
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
	public AddStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(75, 25, 1169, 705);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBackground(new Color(210, 105, 30));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(10, 10, 96, 42);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("LogOut");
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(1197, 10, 96, 42);
		contentPane.add(btnNewButton_1);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?autoReconnect=true&serverTimezone=UTC&useSSL=False&allowPublicKeyRetrieval=true","root","");
										
					String s ="", ssid = sid.getText(), ssname = sname.getText(), sdob = dob.getText(), sfname = fname.getText(), smname = mname.getText(), smobile = mobile.getText();
					String ssem = sem.getText(), sdept = dept.getText(), sc1 = c1.getText(), sc2 = c2.getText(), sc3 = c3.getText(), sprogramming = programming.getText(), sbranch = branch.getText();
					
					if(ssid.equals(s) || ssname.equals(s) || sdob.equals(s) || sfname.equals(s) || smname.equals(s) || smobile.equals(s) || ssem.equals(s) || sdept.equals(s) ||
					 sc1.equals(s) || sc2.equals(s) || sc3.equals(s) || sprogramming.equals(s) || sbranch.equals(s) ) {
						JOptionPane.showMessageDialog(null, "fill all the details");
					}else {
						st1 = con.createStatement();
						String sql = "insert into student (studentId, studentName, FatheName, MotherName, DateOfBirth, Password, Department, branch, semester, Programming, specialization, courseName1, courseName2,courseName3) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
						PreparedStatement pst = preparedStatement.e
								
					}
						
				}catch (Exception ex) {
					System.out.println("Erro : "+ex);
				}
				
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnSubmit.setBounds(348, 606, 161, 35);
		contentPane.add(btnSubmit);
		
		JButton btnCancel = new JButton("Reset");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudent.main(null);
				dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnCancel.setBounds(598, 606, 135, 35);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel = new JLabel("Student Id");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(70, 140, 180, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblStudentName.setBounds(586, 138, 180, 35);
		contentPane.add(lblStudentName);
		
		JLabel lblFatherName = new JLabel("Department");
		lblFatherName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblFatherName.setBounds(70, 370, 180, 35);
		contentPane.add(lblFatherName);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblDateOfBirth.setBounds(70, 522, 180, 42);
		contentPane.add(lblDateOfBirth);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblMobileNumber.setBounds(586, 519, 222, 48);
		contentPane.add(lblMobileNumber);
		
		JLabel lblFatherName_1 = new JLabel("Father Name");
		lblFatherName_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblFatherName_1.setBounds(70, 208, 180, 32);
		contentPane.add(lblFatherName_1);
		
		JLabel lblMotherName_1 = new JLabel("Mother Name");
		lblMotherName_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblMotherName_1.setBounds(586, 208, 194, 42);
		contentPane.add(lblMotherName_1);
		
		sid = new JTextField();
		sid.setBounds(260, 140, 262, 41);
		contentPane.add(sid);
		sid.setColumns(10);
		
		sname = new JTextField();
		sname.setColumns(10);
		sname.setBounds(823, 140, 289, 38);
		contentPane.add(sname);
		
		dob = new JTextField();
		dob.setColumns(10);
		dob.setBounds(260, 522, 262, 45);
		contentPane.add(dob);
		
		fname = new JTextField();
		fname.setColumns(10);
		fname.setBounds(260, 211, 262, 38);
		contentPane.add(fname);
		
		mobile = new JTextField();
		mobile.setColumns(10);
		mobile.setBounds(823, 528, 289, 41);
		contentPane.add(mobile);
		
		mname = new JTextField();
		mname.setColumns(10);
		mname.setBounds(824, 211, 289, 38);
		contentPane.add(mname);
		
		JLabel lblNewLabel_1 = new JLabel("SEM");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(960, 292, 96, 42);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Programming");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(70, 292, 180, 42);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cluster-I");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(586, 370, 211, 42);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Cluster-II");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_4.setBounds(70, 444, 161, 42);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Cluster-III");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_5.setBounds(586, 444, 211, 42);
		contentPane.add(lblNewLabel_5);
		
		programming = new JTextField();
		programming.setColumns(10);
		programming.setBounds(260, 292, 262, 38);
		contentPane.add(programming);
		
		dept = new JTextField();
		dept.setColumns(10);
		dept.setBounds(260, 370, 262, 38);
		contentPane.add(dept);
		
		c2 = new JTextField();
		c2.setColumns(10);
		c2.setBounds(260, 444, 262, 38);
		contentPane.add(c2);
		
		branch = new JTextField();
		branch.setColumns(10);
		branch.setBounds(710, 292, 222, 38);
		contentPane.add(branch);
		
		c1 = new JTextField();
		c1.setColumns(10);
		c1.setBounds(823, 370, 262, 38);
		contentPane.add(c1);
		
		c3 = new JTextField();
		c3.setColumns(10);
		c3.setBounds(823, 444, 262, 38);
		contentPane.add(c3);
		
		sem = new JTextField();
		sem.setColumns(10);
		sem.setBounds(1046, 292, 75, 38);
		contentPane.add(sem);
		
		JLabel lblNewLabel_6 = new JLabel("Branch");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_6.setBounds(586, 292, 180, 42);
		contentPane.add(lblNewLabel_6);
	}
}

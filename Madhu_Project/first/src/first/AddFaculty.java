package first;

import java.lang.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AddFaculty extends JFrame {

	private JPanel contentPane;
	private JTextField fid;
	private JTextField fname;
	private JTextField cno;
	private JTextField email;
	private JTextField office;
	private JTextField course;
	private JTextField password;
	
	private Connection con;
	private Statement st,st1,st2;
	private ResultSet rs,rs1;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFaculty frame = new AddFaculty();
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
	public AddFaculty() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 1317, 778);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBackground(new Color(210, 105, 30));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPortal.main(null);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(10, 10, 118, 39);
		contentPane.add(btnNewButton);
		
		JButton btnLogout = new JButton("LogOut");
		btnLogout.setForeground(Color.RED);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login.main(null);
				dispose();
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLogout.setBounds(1184, 10, 109, 39);
		contentPane.add(btnLogout);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?autoReconnect=true&serverTimezone=UTC&useSSL=False&allowPublicKeyRetrieval=true","root","");
					st = con.createStatement();
					
					String s = "",sfname = fname.getText(), sfid = fid.getText(), spassword = password.getText(), scourse = course.getText(), scno = cno.getText(), sselect = comboBox.getSelectedItem().toString(), semail = email.getText(), soffice = office.getText();
		
					if(sfname.equals(s) || sfid.equals(s) || spassword.equals(s) || scourse.equals(s) || scno.equals(s) || sselect.equals(s) || semail.equals(s) || soffice.equals(s)) {
						JOptionPane.showMessageDialog(null, "not filled all details ......");
					
					}else {	
					st1 = con.createStatement();	
					String sql1 = "select * from faculty where facultyId = '"+fid.getText()+"'";
					rs = st1.executeQuery(sql1);
					
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "facultyId already exists.......");
					}else {
					st2 = con.createStatement();
					String sql2 = "select * from faculty where mobile = '"+cno.getText()+"'";
					rs1 = st2.executeQuery(sql2);
					
					if(rs1.next()) {
						JOptionPane.showMessageDialog(null, "mobile no. already exists.......");
					}else {
					
					String sql = "INSERT INTO faculty(facultyName, facultyId, Password, course, mobile, Department, email, office) VALUES (?,?,?,?,?,?,?,?)";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1, sfname);
					pst.setString(2, sfid);
					pst.setString(3, spassword);
					pst.setString(4, scourse);
					pst.setString(5, scno);
					pst.setString(6, sselect);				
					pst.setString(7, semail);
					pst.setString(8, soffice);
					pst.executeUpdate();			
					JOptionPane.showMessageDialog(null, "Registered successfully......");
					AdminPortal.main(null);
					dispose();
					}
					}}
				}catch (Exception ex) {
					System.out.println("Erro : "+ex);
				}
				
			}
			
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnAdd.setBounds(397, 654, 136, 39);
		contentPane.add(btnAdd);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnCancel.setBounds(612, 650, 136, 43);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel = new JLabel("Facilty Id          :");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblNewLabel.setBounds(310, 105, 220, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblFacultyName = new JLabel("Faculty Name   :");
		lblFacultyName.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblFacultyName.setBounds(310, 164, 220, 43);
		contentPane.add(lblFacultyName);
		
		JLabel lblDepartment = new JLabel("Department      :");
		lblDepartment.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblDepartment.setBounds(310, 221, 220, 38);
		contentPane.add(lblDepartment);
		
		JLabel lblContactNo = new JLabel("Contact No.     :");
		lblContactNo.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblContactNo.setBounds(310, 358, 220, 39);
		contentPane.add(lblContactNo);
		
		fid = new JTextField();
		fid.setBounds(615, 105, 248, 39);
		contentPane.add(fid);
		fid.setColumns(10);
		
		fname = new JTextField();
		fname.setColumns(10);
		fname.setBounds(615, 164, 248, 43);
		contentPane.add(fname);
		
		cno = new JTextField();
		cno.setColumns(10);
		cno.setBounds(615, 358, 248, 38);
		contentPane.add(cno);
	//	public Object comboSelect;
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//comboSelect = comboBox.getSelectedItem();
				
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"    --SELECT--", "CSE", "MECHANICAL", "EEE", "CIVIL", "ECE", "MATHEMATICS", "PHYSICS", "CHEMISTRY"}));
		comboBox.setBounds(615, 217, 248, 42);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("   E-mail          :");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(310, 429, 220, 39);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblOffice = new JLabel("  Office            :");
		lblOffice.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblOffice.setBounds(310, 494, 220, 39);
		contentPane.add(lblOffice);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(615, 429, 248, 38);
		contentPane.add(email);
		
		office = new JTextField();
		office.setColumns(10);
		office.setBounds(615, 495, 248, 38);
		contentPane.add(office);
		
		JLabel lblNewLabel_2 = new JLabel("Course             :");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(310, 283, 220, 39);
		contentPane.add(lblNewLabel_2);
		
		course = new JTextField();
		course.setBounds(615, 283, 248, 45);
		contentPane.add(course);
		course.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblNewLabel_3.setBounds(310, 561, 220, 39);
		contentPane.add(lblNewLabel_3);
		
		password = new JTextField();
		password.setBounds(615, 561, 248, 39);
		contentPane.add(password);
		password.setColumns(10);
	}
}

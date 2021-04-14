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
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class RemoveFaculty extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	private Connection con;
	private Statement st,st1,st2;
	int rs;
	private ResultSet rs1,rs2;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveFaculty frame = new RemoveFaculty();
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
	public RemoveFaculty() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 1317, 778);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 105, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminPortal.main(null);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 10, 108, 34);
		contentPane.add(btnNewButton);
		
		JButton btnLogout = new JButton("LogOut");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login.main(null);
				dispose();
			}
		});
		btnLogout.setForeground(new Color(255, 0, 0));
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogout.setBounds(1191, 10, 102, 34);
		contentPane.add(btnLogout);
		
		JLabel lblNewLabel = new JLabel("Faculty Id        :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(161, 294, 239, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Department     :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(161, 409, 239, 47);
		contentPane.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 22));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"    --SELECCT--", "CSE", "MECHANICAL", "EEE", "CIVIL", "ECE", "MATHEMATICS", "PHYSICS", "CHEMISTRY"}));
		comboBox.setBounds(410, 410, 249, 47);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(410, 294, 249, 47);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSubmit = new JButton("Remove");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?autoReconnect=true&serverTimezone=UTC&useSSL=False&allowPublicKeyRetrieval=true","root","");
					
					
					String s="", sfid = textField.getText(), select = comboBox.getSelectedItem().toString();
					if(sfid.equals(s) || select.equals(s)) {
						JOptionPane.showMessageDialog(null, "fill all details....");
					}else {
						st = con.createStatement();
						String sql = "delete from faculty where facultyId = '"+sfid+"' and Department = '"+select+"'";
						rs = st.executeUpdate(sql);
					
						if(rs!=0) {						
							JOptionPane.showMessageDialog(null, "Successfully removed faculty....");
						}else 
							JOptionPane.showMessageDialog(null, "Invalid entry....");
					
					}
				}catch (Exception ex) {
					System.out.println("Erro : "+ex);
				}
				
			}
		});
		btnSubmit.setBackground(new Color(30, 144, 255));
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnSubmit.setBounds(205, 533, 134, 47);
		contentPane.add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(new Color(128, 0, 0));
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnCancel.setBounds(420, 533, 134, 47);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel_3 = new JLabel("    Removing  Course");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBackground(new Color(218, 165, 32));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblNewLabel_3.setBounds(215, 183, 328, 34);
		contentPane.add(lblNewLabel_3);
		
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
			Object[][] data = new Object[length][5];
			st2 = con.createStatement();
			String sql1 = "select facultyId, facultyName, course, Department from faculty";
			rs2 = st2.executeQuery(sql1);
			while(rs2.next()) {
				data[i][0] = i+1;
				data[i][1] = rs2.getString(1);
				data[i][2] = rs2.getString(2);
				data[i][3] = rs2.getString(3);
				data[i][4] = rs2.getString(4);
				i++;
			}
			
			String[] columns = {"S.no", "Facluty Id", "Faculty Name", "Course", "Department"};
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(697, 76, 573, 637);
			contentPane.add(scrollPane);
		
			table = new JTable(data,columns);
			scrollPane.setViewportView(table);
			
		}catch(Exception ex) {
			System.out.println("Erro : "+ex);
		}
	}
}

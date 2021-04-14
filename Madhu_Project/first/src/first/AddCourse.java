package first;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class AddCourse extends JFrame {

	private JPanel contentPane;
	private JTextField cid;
	private JTextField cname;
	private JTextField credits;

	private Connection con;
	private Statement st;
	private ResultSet rs;
	private JComboBox comboBox;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCourse frame = new AddCourse();
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
	public AddCourse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 1317, 778);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(27, 19, 88, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(1162, 19, 131, 39);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Course Id");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(391, 309, 230, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Course Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(391, 396, 230, 50);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Credits");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(391, 490, 230, 50);
		contentPane.add(lblNewLabel_2);
		
		cid = new JTextField();
		cid.setBounds(574, 309, 339, 50);
		contentPane.add(cid);
		cid.setColumns(10);
		
		cname = new JTextField();
		cname.setColumns(10);
		cname.setBounds(574, 396, 339, 50);
		contentPane.add(cname);
		
		credits = new JTextField();
		credits.setColumns(10);
		credits.setBounds(574, 490, 339, 50);
		contentPane.add(credits);
		
		JButton btnNewButton_2 = new JButton("Add Course");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			/*	try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?autoReconnect=true&serverTimezone=UTC&useSSL=False&allowPublicKeyRetrieval=true","root","");
										
					String s="", scid = cid.getText(), scname = cname.getText(), select = comboBox.getSelectedItem().toString();
					if(scid.equals(s) || scname.equals(s) || select.equals(s)) {
						JOptionPane.showMessageDialog(null, "fill all details......");

					}else {
							st = con.createStatement();
							String check = "select * from courses where '"+select+"' = '"+s+"'";
							rs = st.executeQuery(check);
							
					String sql = "insert into courses (courseId,courseName,Credit) values (?,?,?)";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1, cid.getText());
					pst.setString(2, cname.getText());
					pst.setString(3, credits.getText());
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Successfully added......");
					AddCourse.main(null);
					dispose();
					
					
					
					
				}catch (Exception ex) {
					System.out.print("Erro : "+ex);
				}*/
				
				
				
			}
		});
		btnNewButton_2.setBackground(Color.GREEN);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton_2.setBounds(486, 616, 207, 50);
		contentPane.add(btnNewButton_2);
		
		comboBox = new JComboBox();
		comboBox.setForeground(Color.BLUE);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 29));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Choose elective", "ELECTIVE-I", "ELECTIVE-II", "ELECTIVE-III"}));
		comboBox.setBounds(465, 225, 339, 50);
		contentPane.add(comboBox);
	}
}

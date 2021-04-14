package first;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class UpdateProfile extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateProfile frame = new UpdateProfile();
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
	public UpdateProfile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 1317, 778);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogout = new JButton("LogOut");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login.main(null);;
				dispose();
			}
		});
		btnLogout.setForeground(new Color(255, 0, 0));
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnLogout.setBounds(1206, 0, 97, 42);
		contentPane.add(btnLogout);
		
		JButton btnUpdatePassword = new JButton("Update ");
		btnUpdatePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdatePassword.setForeground(new Color(255, 0, 255));
		btnUpdatePassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnUpdatePassword.setBounds(462, 402, 162, 51);
		contentPane.add(btnUpdatePassword);
		
		JLabel lblNewLabel = new JLabel("Enter Old Password      :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(404, 145, 215, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblEnterTheOld = new JLabel("Enter the Old Password :");
		lblEnterTheOld.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnterTheOld.setBounds(404, 221, 215, 32);
		contentPane.add(lblEnterTheOld);
		
		JLabel lblEnterConfirmPassword = new JLabel("Enter Confirm Password :");
		lblEnterConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnterConfirmPassword.setBounds(404, 288, 215, 42);
		contentPane.add(lblEnterConfirmPassword);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentPortal.main(null);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 5, 103, 37);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(650, 145, 228, 39);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(650, 221, 228, 39);
		contentPane.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(650, 293, 228, 39);
		contentPane.add(passwordField_2);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateProfile.main(null);
				dispose();
				
			}
		});
		btnReset.setForeground(Color.MAGENTA);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReset.setBounds(681, 406, 162, 42);
		contentPane.add(btnReset);
	}
}

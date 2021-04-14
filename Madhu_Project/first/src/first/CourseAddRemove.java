package first;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CourseAddRemove extends JFrame {

	private JPanel contentPane;
	private JTextField courseId;
	private JTextField courseName;
	private JTextField credits;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseAddRemove frame = new CourseAddRemove();
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
	public CourseAddRemove() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 1317, 778);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
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
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 10, 105, 39);
		contentPane.add(btnNewButton);
		
		JButton btnLogout = new JButton("LogOut");
		btnLogout.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Login.main(null);
				dispose();
			}
		});
		btnLogout.setForeground(Color.RED);
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogout.setBounds(1166, 10, 127, 39);
		contentPane.add(btnLogout);
		
		JLabel lblNewLabel = new JLabel("Course Id       :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(350, 185, 235, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblCourseNamel = new JLabel("Course Name   :");
		lblCourseNamel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCourseNamel.setBounds(350, 282, 235, 49);
		contentPane.add(lblCourseNamel);
		
		JLabel lblCredits = new JLabel("Credits          :");
		lblCredits.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCredits.setBounds(350, 377, 235, 49);
		contentPane.add(lblCredits);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.setBackground(new Color(50, 205, 50));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1.setBounds(395, 482, 147, 49);
		contentPane.add(btnNewButton_1);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBackground(new Color(255, 0, 0));
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnRemove.setBounds(644, 482, 147, 49);
		contentPane.add(btnRemove);
		
		courseId = new JTextField();
		courseId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		courseId.setBounds(595, 185, 262, 49);
		contentPane.add(courseId);
		courseId.setColumns(10);
		
		courseName = new JTextField();
		courseName.setColumns(10);
		courseName.setBounds(595, 282, 262, 49);
		contentPane.add(courseName);
		
		credits = new JTextField();
		credits.setColumns(10);
		credits.setBounds(595, 382, 262, 49);
		contentPane.add(credits);
		
		JLabel lblNewLabel_1 = new JLabel("Add  (or)   Remove Course");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBounds(386, 9, 408, 39);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("  (or)");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(563, 482, 53, 49);
		contentPane.add(lblNewLabel_2);
	}

}

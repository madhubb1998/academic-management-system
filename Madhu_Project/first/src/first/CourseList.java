package first;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CourseList extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	private Statement st,st2;
	private Connection con;
	private ResultSet rs,rs2;
	private JScrollPane scrollPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseList frame = new CourseList();
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
	public CourseList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 1317, 778);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?autoReconnect=true&serverTimezone=UTC&useSSl=False&allowPublicKeyRetrieval=true","root","");
			st = con.createStatement();
			String sql = "select * from courses";
			rs = st.executeQuery(sql);
			int length=0;
	
			while(rs.next()) {
				length++;
			}
			int i=0;
			Object[][] data = new Object[length][4];
			st2 = con.createStatement();
			String sql1 = "select courseId,courseName,Credit from courses";
			rs2 = st2.executeQuery(sql1);
			while(rs2.next()) {
				data[i][0] = i+1;
				data[i][1] = rs2.getString(1);
				data[i][2] = rs2.getString(2);
				data[i][3] = rs2.getString(3);
				i++;
			}
			String[] columns = {"SlNo","CourseId","CourseName","Credit"};
			
			scrollPane = new JScrollPane();
			scrollPane.setBounds(34, 117, 1242, 474);
			contentPane.add(scrollPane);
			
			table = new JTable(data,columns);
			scrollPane.setViewportView(table);
			
			
		}catch(Exception ex) {
			System.out.println("Error:"+ex);
		}
		
		

		
		JLabel lblNewLabel = new JLabel("COURSES  LIST");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(481, 51, 487, 53);
		contentPane.add(lblNewLabel);
	}
}

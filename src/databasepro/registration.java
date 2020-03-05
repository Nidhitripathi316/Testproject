package databasepro;
import java.awt.EventQueue;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
public class registration extends JFrame {

	private JPanel contentPane;
	private JTextField email;
	private JTextField user;
	private JTextField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registration frame = new registration();
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
	public registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		email = new JTextField();
		email.setBounds(26, 64, 148, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		user = new JTextField();
		user.setColumns(10);
		user.setBounds(26, 126, 148, 20);
		contentPane.add(user);
		
		pass = new JTextField();
		pass.setColumns(10);
		pass.setBounds(26, 180, 148, 20);
		contentPane.add(pass);
		
		JLabel emaillabel = new JLabel("Emailid");
		emaillabel.setBounds(26, 51, 88, 14);
		contentPane.add(emaillabel);
		
		JLabel userlabel = new JLabel("Username");
		userlabel.setBounds(26, 112, 88, 14);
		contentPane.add(userlabel);
		
		JLabel passlabel = new JLabel("Password");
		passlabel.setBounds(26, 166, 88, 14);
		contentPane.add(passlabel);
		
		JButton btnNewButton = new JButton("Registration");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","");
					PreparedStatement ps = conn.prepareStatement("insert into user(user_emailid,user_name,user_password) values (?,?,?);");
					ps.setString(1,email.getText());
					ps.setString(2,user.getText());
					ps.setString(3,pass.getText());
					int x = ps.executeUpdate();
					if(x > 0) {
						System.out.println("Registration done successfully");
					}else {
						System.out.println("Registration failed");
					}
				}catch(Exception e1) {
					System.out.print(e1);
				}
			}
		});
		btnNewButton.setBounds(25, 227, 149, 23);
		contentPane.add(btnNewButton);
	}
}

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Window;

import javax.swing.UIManager;

import net.proteanit.sql.DbUtils;
import oracle.jdbc.OraclePreparedStatement;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
public class Login extends JFrame {

	private JFrame frame;
	private JTextField textField1;
	private JTextField pasTF;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection=null;
	OraclePreparedStatement pat=null;
	ResultSet rs=null;
	private JLabel label;
	

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(204, 204, 204));
		frame.setBounds(100, 100, 543, 334);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(21, 11, 60, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(21, 100, 60, 14);
		frame.getContentPane().add(lblPassword);
		
		textField1 = new JTextField();
		textField1.setBounds(109, 11, 139, 36);
		frame.getContentPane().add(textField1);
		textField1.setColumns(10);
		
		pasTF = new JTextField();
		pasTF.setBounds(109, 97, 139, 36);
		frame.getContentPane().add(pasTF);
		pasTF.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
        connection = DatabaseConnection.ConnectionDB();
				
				
				try {
					String sql="select * from Admin where username = ? and password=?";
					System.out.println(sql);
					pat = (OraclePreparedStatement) connection.prepareStatement(sql);
					pat.setString(1,textField1.getText());
					pat.setString(2,pasTF.getText());
					rs=pat.executeQuery();
					
					if (rs.next()) {
						
						JOptionPane.showMessageDialog(null, "Username And Password  Matched!!!!!");
						
						//Main s=new Main();
						//s.setVisible(true);
						Management m=new Management();
						m.setVisible(true);
						
					}
					
					else {
						JOptionPane.showMessageDialog(null, "Username And Password Not Matched!!!!!");
					}
					
					
				}
				
				catch (Exception e) {
					
					
					System.out.println(e);
				}
				
				
				
			}
		});
		btnLogin.setBounds(194, 241, 89, 43);
		frame.getContentPane().add(btnLogin);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\HIMEL\\Documents\\l.jpg"));
		label.setBounds(284, 11, 233, 219);
		frame.getContentPane().add(label);
		
		
	}

}

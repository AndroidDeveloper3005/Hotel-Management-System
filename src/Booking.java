import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oracle.jdbc.OraclePreparedStatement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Booking extends JFrame {

	private JPanel contentPane;
	
	
	Connection connection=null;
	OraclePreparedStatement pat=null;
	ResultSet rs=null;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Booking frame = new Booking();
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
	public Booking() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 753, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBooking = new JButton("Booking");
		btnBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                connection = DatabaseConnection.ConnectionDB();
				
				
				try {
					String sql="select * from Admin where username = ? and password=?";
					System.out.println(sql);
					pat = (OraclePreparedStatement) connection.prepareStatement(sql);
					//pat.setString(1,textField1.getText());
					//pat.setString(2,pasTF.getText());
					rs=pat.executeQuery();
				
					
				}
				
				catch (Exception e1) {
					
					
					System.out.println(e1);
				}
				
				
			}
			
			
		});
		btnBooking.setBounds(323, 417, 89, 23);
		contentPane.add(btnBooking);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(24, 27, 46, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(108, 27, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("New label");
		label.setBounds(242, 27, 46, 14);
		contentPane.add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(326, 27, 86, 20);
		contentPane.add(textField_1);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(464, 27, 46, 14);
		contentPane.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(548, 27, 86, 20);
		contentPane.add(textField_2);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setBounds(24, 97, 46, 14);
		contentPane.add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(108, 97, 86, 20);
		contentPane.add(textField_3);
		
		JLabel label_3 = new JLabel("New label");
		label_3.setBounds(242, 91, 46, 14);
		contentPane.add(label_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(326, 91, 86, 20);
		contentPane.add(textField_4);
		
		JLabel label_4 = new JLabel("New label");
		label_4.setBounds(464, 91, 46, 14);
		contentPane.add(label_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(548, 91, 86, 20);
		contentPane.add(textField_5);
		
		JLabel label_5 = new JLabel("New label");
		label_5.setBounds(24, 161, 46, 14);
		contentPane.add(label_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(108, 161, 86, 20);
		contentPane.add(textField_6);
		
		JLabel label_6 = new JLabel("New label");
		label_6.setBounds(242, 161, 46, 14);
		contentPane.add(label_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(326, 161, 86, 20);
		contentPane.add(textField_7);
		
		JLabel label_7 = new JLabel("New label");
		label_7.setBounds(464, 155, 46, 14);
		contentPane.add(label_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(548, 155, 86, 20);
		contentPane.add(textField_8);
		
		JLabel label_8 = new JLabel("New label");
		label_8.setBounds(24, 225, 46, 14);
		contentPane.add(label_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(108, 225, 86, 20);
		contentPane.add(textField_9);
		
		JLabel label_9 = new JLabel("New label");
		label_9.setBounds(242, 225, 46, 14);
		contentPane.add(label_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(326, 225, 86, 20);
		contentPane.add(textField_10);
		
		JLabel label_10 = new JLabel("New label");
		label_10.setBounds(464, 219, 46, 14);
		contentPane.add(label_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(548, 219, 86, 20);
		contentPane.add(textField_11);
		
		JLabel label_11 = new JLabel("New label");
		label_11.setBounds(24, 292, 46, 14);
		contentPane.add(label_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(108, 292, 86, 20);
		contentPane.add(textField_12);
		
		JLabel label_12 = new JLabel("New label");
		label_12.setBounds(242, 286, 46, 14);
		contentPane.add(label_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(326, 286, 86, 20);
		contentPane.add(textField_13);
		
		JLabel label_13 = new JLabel("New label");
		label_13.setBounds(464, 286, 46, 14);
		contentPane.add(label_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(548, 286, 86, 20);
		contentPane.add(textField_14);
	}

}

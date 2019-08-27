import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import oracle.jdbc.OraclePreparedStatement;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class View extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;
	OraclePreparedStatement pat=null;
	ResultSet rs=null;
	private JTable table_1;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the frame.
	 */
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 881, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(10, 60, 845, 265);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
        connection = DatabaseConnection.ConnectionDB();
				
				
				try {
					String sql="SELECT * FROM GUEST WHERE LOC=?";
					System.out.println(sql);
					pat = (OraclePreparedStatement) connection.prepareStatement(sql);
					pat.setString(1,textField.getText());
					//pat.setString(2,textField_BN.getText());
					rs=pat.executeQuery();
					// table.getColumnModel().getColumn().setHeaderValue("newHeader");
			        // table.getTableHeader().repaint();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				
				catch (Exception e1) {
					
					
					System.out.println(e1);
				}
				
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		button.setBackground(SystemColor.inactiveCaption);
		button.setBounds(236, 336, 89, 23);
		contentPane.add(button);
		
		textField = new JTextField();
		textField.setBounds(236, 5, 130, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSearchByLocation = new JLabel("SEARCH BY LOCATION HOTEL_BD");
		lblSearchByLocation.setBounds(49, 11, 177, 26);
		contentPane.add(lblSearchByLocation);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(643, 11, 130, 38);
		contentPane.add(textField_1);
		
		JLabel lblSearchByLocation_1 = new JLabel("SEARCH BY LOCATION FOR HOTEL_UK");
		lblSearchByLocation_1.setBounds(436, 17, 197, 26);
		contentPane.add(lblSearchByLocation_1);
		
		JButton button_1 = new JButton("Search");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 connection = DatabaseConnection.ConnectionDB();
					
					
					try {
						String sql="SELECT * FROM GUEST@HMS_UK WHERE LOC=?";
						System.out.println(sql);
						pat = (OraclePreparedStatement) connection.prepareStatement(sql);
						pat.setString(1,textField_1.getText());
						//pat.setString(2,textField_BN.getText());
						rs=pat.executeQuery();
						// table.getColumnModel().getColumn().setHeaderValue("newHeader");
				        // table.getTableHeader().repaint();
						table_1.setModel(DbUtils.resultSetToTableModel(rs));
						
					}
					
					catch (Exception e1) {
						
						
						System.out.println(e1);
					}
					
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		button_1.setBackground(SystemColor.inactiveCaption);
		button_1.setBounds(618, 336, 89, 23);
		contentPane.add(button_1);
	}
}

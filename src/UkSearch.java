import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import oracle.jdbc.OraclePreparedStatement;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class UkSearch extends JFrame {

	private JPanel contentPane;
	
	//private JFrame frame;
	private JTextField textField_ID;
	private JTextField textField_BN;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BdSearch frame = new BdSearch();
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
	private JTextField textField;
	private JTable table_1;

	/**
	 * Create the frame.
	 */
	public UkSearch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGuestId = new JLabel("Guest ID");
		lblGuestId.setBackground(Color.BLACK);
		lblGuestId.setBounds(52, 22, 63, 14);
		contentPane.add(lblGuestId);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(125, 11, 86, 36);
		contentPane.add(textField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(10, 62, 595, 252);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
        connection = DatabaseConnection.ConnectionDB();
				
				
				try {
					String sql="select * from EMP@HMS_UK where E_ID = ?";
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
	}
}

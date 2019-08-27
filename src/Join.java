import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import oracle.jdbc.OraclePreparedStatement;

public class Join extends JFrame {

	private JPanel contentPane;
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
					Join frame = new Join();
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


	/**
	 * Create the frame.
	 */
	public Join() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(10, 11, 595, 265);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
        connection = DatabaseConnection.ConnectionDB();
				
				
				try {
					String sql="SELECT G_ID,G_NAME,R_NUM,TOTAL_COST FROM G_ORDER@HMS_UK   UNION  ALL SELECT G_ID,G_NAME,R_NUM,TOTAL_COST FROM G_ORDER ";
					System.out.println(sql);
					pat = (OraclePreparedStatement) connection.prepareStatement(sql);
					//pat.setString(1,textField.getText());
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

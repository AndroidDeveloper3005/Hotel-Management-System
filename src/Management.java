import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Management extends JFrame {

	private JPanel contentPane;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Management frame = new Management();
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
	public Management() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				//frame.setVisible(false);
				
			}
		});
		
		setResizable(false);
		setBounds(100, 100, 820, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Employee Information");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				BdSearch bSearch=new BdSearch();
				bSearch.setVisible(true);
				
				
			}
			
			
			
		});
		btnNewButton.setBounds(10, 11, 160, 41);
		contentPane.add(btnNewButton);
		
		JButton btnGuestInformation = new JButton("Guest Information");
		btnGuestInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				UkSearch s =new UkSearch();		
				s.setVisible(true);
				
			}
		});
		btnGuestInformation.setBounds(169, 11, 141, 41);
		contentPane.add(btnGuestInformation);
		
		JButton btnBooking = new JButton("Booking");
		btnBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Booking booking=new Booking();
				booking.setVisible(true);
				
			}
		});
		btnBooking.setBounds(309, 11, 118, 41);
		contentPane.add(btnBooking);
		
		JButton btnUpdateInformaion = new JButton("Update Informaion");
		btnUpdateInformaion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Ubdating u=new Ubdating();
				u.setVisible(true);
			}
		});
		btnUpdateInformaion.setBounds(428, 11, 154, 41);
		contentPane.add(btnUpdateInformaion);
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HIMEL\\Documents\\aa.jpg"));
		lblNewLabel.setBounds(10, 63, 673, 380);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login  login=new Login();
				login.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(693, 259, 75, 41);
		contentPane.add(btnNewButton_1);
		
		JButton btnJoinSite = new JButton("Guest HotelBD And HotelUK ");
		btnJoinSite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Join join=new Join();
				join.setVisible(true);
			}
		});
		btnJoinSite.setBounds(583, 11, 202, 41);
		contentPane.add(btnJoinSite);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				View view = new View();
				view.setVisible(true);
				
				
				
			}
		});
		btnView.setBounds(693, 82, 92, 41);
		contentPane.add(btnView);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Select select = new Select();
				select.setVisible(true);
				
			}
		});
		btnSelect.setBounds(693, 134, 92, 41);
		contentPane.add(btnSelect);
	}
}

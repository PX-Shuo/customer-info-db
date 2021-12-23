import java.awt.EventQueue;

import javax.swing.JFrame;
//import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
//import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {

	private JFrame frame;
	public static JTextField textField;
	public static JTextField textField_1;
	public static JTextField textField_2;
	public static JTextField textField_3;
	public static JTextField textField_4;
	public static JTextField textField_5;
	public static JTextField textField_6;
	public static JTextField textField_7;

	/**
	* Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	* Create the application.
	*/
	public GUI() {
		initialize();
	}

	/**
	* Initialize the contents of the frame.
	*/
	private void initialize() {
		Customer.createTable();
		frame = new JFrame();
		frame.setBounds(100, 100, 551, 501);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCustomer = new JLabel("Customer");
		lblCustomer.setFont(new Font("Castellar", Font.ITALIC, 28));
		lblCustomer.setBounds(10, 11, 192, 40);
		frame.getContentPane().add(lblCustomer);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(20, 69, 46, 14);
		frame.getContentPane().add(lblId);
		
		JLabel lblNewLabel = new JLabel("Firstname");
		lblNewLabel.setBounds(20, 94, 54, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Lastname");
		lblNewLabel_1.setBounds(20, 119, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Gender");
		lblNewLabel_2.setBounds(20, 144, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DOB");
		lblNewLabel_3.setBounds(20, 169, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Phone");
		lblNewLabel_4.setBounds(20, 194, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Address");
		lblNewLabel_5.setBounds(20, 219, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("E-mail");
		lblNewLabel_6.setBounds(20, 295, 46, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(76, 66, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(76, 91, 164, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(76, 116, 164, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(76, 141, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(76, 166, 86, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(76, 191, 86, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(76, 292, 126, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(76, 216, 197, 65);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblyyyymmdd = new JLabel("(YYYY-MM-DD)");
		lblyyyymmdd.setForeground(Color.RED);
		lblyyyymmdd.setBounds(172, 169, 101, 14);
		frame.getContentPane().add(lblyyyymmdd);
		
		JButton btnAddNewCustomer = new JButton("Add Customer");
		btnAddNewCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Customer.addCustomer();
				JOptionPane.showMessageDialog(null, "Customer record added.");
			}
		});
		btnAddNewCustomer.setBounds(20, 354, 101, 23);
		frame.getContentPane().add(btnAddNewCustomer);
		
		JButton btnUpdateCustomer = new JButton("Update Customer Details");
		btnUpdateCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Customer.updateRecord();
				JOptionPane.showMessageDialog(null, "Customer record updated.");
			}
		});
		btnUpdateCustomer.setBounds(131, 354, 151, 23);
		frame.getContentPane().add(btnUpdateCustomer);
		
		JButton btnDisplayAllCustomers = new JButton("Display All Customers");
		btnDisplayAllCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String records = Customer.displayRecords();
				JOptionPane.showMessageDialog(null, records);
			}
		});
		btnDisplayAllCustomers.setBounds(292, 354, 135, 23);
		frame.getContentPane().add(btnDisplayAllCustomers);
		
	}
}

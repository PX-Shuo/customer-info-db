import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.sql.SQLException;

public class Customer {
	public static final String URL = "jdbc:mysql://rerun.it.uts.edu.au/sd03";
	public static final String USER = "sd03";
	public static final String PASSWORD = "84NXHUxk";
	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	
	public static String customerRecords;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement statement = conn.createStatement();

			statement.executeUpdate("CREATE TABLE 13437052_Customer(CustomerId int, Firstname char(50), "
					+ "Lastname char(50), Gender char(10), DOB char(15), Phonenumber char(20), Address char(255), Email char(30))");
			System.out.println("Table created!");

			statement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public static void createTable() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.exit(1);
			}
			try {
				Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				Statement statement = conn.createStatement();

				statement.executeUpdate("CREATE TABLE IF NOT EXISTS 13437052_Customer(CustomerId int, Firstname char(50), "
						+ "Lastname char(50), Gender char(10), DOB char(15), Phonenumber char(20), Address char(255), Email char(30))");
				System.out.println("Table created!");

				statement.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public static void addCustomer() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement statement = conn.createStatement();

			int customerId = Integer.parseInt(GUI.textField.getText());
			String firstname = GUI.textField_1.getText();
			String lastname = GUI.textField_2.getText();
			String gender = GUI.textField_3.getText();
			String DOB = GUI.textField_4.getText();
			String phoneNumber = GUI.textField_5.getText();
			String address = GUI.textField_7.getText();
			String email = GUI.textField_6.getText();

			statement.executeUpdate(
					"INSERT INTO 13437052_Customer(CustomerId, Firstname, Lastname, Gender, DOB, Phonenumber, Address, Email) VALUES ('"
							+ customerId + "', '" + firstname + "', '" + lastname + "', '" + gender + "', '" + DOB
							+ "', '" + phoneNumber + "', '" + address + "', '" + email + "')");

			statement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateRecord() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement statement = conn.createStatement();
			
			int id = Integer.parseInt(GUI.textField.getText());
			
			if(GUI.textField_1.getText()!=null) {
				String firstname = GUI.textField_1.getText();
				statement.executeUpdate("Update 13437052_Customer Set Firstname='" + firstname + "' Where CustomerId=" + id);
			}
			if(GUI.textField_2.getText()!=null) {
				String lastname = GUI.textField_2.getText();
				statement.executeUpdate("Update 13437052_Customer Set Lastname='" + lastname + "' Where CustomerId=" + id);
			}
			if(GUI.textField_3.getText()!=null) {
				String gender = GUI.textField_3.getText();
				statement.executeUpdate("Update 13437052_Customer Set Gender='" + gender + "' Where CustomerId=" + id);
			}
			if(GUI.textField_4.getText()!=null) {
				String DOB = GUI.textField_4.getText();
				statement.executeUpdate("Update 13437052_Customer Set DOB='" + DOB + "' Where CustomerId=" + id);
			}
			if(GUI.textField_5.getText()!=null) {
				String phoneNumber = GUI.textField_5.getText();
				statement.executeUpdate("Update 13437052_Customer Set Phonenumber='" + phoneNumber + "' Where CustomerId=" + id);
			}
			if(GUI.textField_7.getText()!=null) {
				String address = GUI.textField_7.getText();
				statement.executeUpdate("Update 13437052_Customer Set Address='" + address + "' Where CustomerId=" + id);
			}
			if(GUI.textField_6.getText()!=null) {
				String email = GUI.textField_6.getText();
				statement.executeUpdate("Update 13437052_Customer Set Email='" + email + "' Where CustomerId=" + id);
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static String displayRecords() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement statement = conn.createStatement();
			
			ResultSet results = statement.executeQuery("SELECT * FROM 13437052_Customer");
			int customerId = 0;
			String firstname = "";
			String lastname = "";
			String gender;
			Date DOB;
			String phoneNumber = "";
			String address = "";
			String email = "";
			
			customerRecords = "Id\tFirstname\tLastname\tGender\tDOB\tPhone Number\tAddress\tEmail\n";
			
			while (results.next()) {
				customerId = results.getInt("CustomerId");
				firstname = results.getString("Firstname");
				lastname = results.getString("Lastname");
				gender = results.getString("Gender");
				DOB = results.getDate("DOB");
				phoneNumber = results.getString("Phonenumber");
				address = results.getString("Address");
				email = results.getString("Email");
				customerRecords += customerId + "\t" + firstname + "\t" + lastname + "\t" + gender + "\t" + DOB + "\t"
						+ phoneNumber + "\t" + address + "\t" + email + "\n";
			}
			results.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return customerRecords;
	}

}
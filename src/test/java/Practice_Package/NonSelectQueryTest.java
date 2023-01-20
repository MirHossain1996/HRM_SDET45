package Practice_Package;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQueryTest {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		int result=0;
		try {

		Driver driver=new Driver();

		//step1: Register the database
		DriverManager.registerDriver(driver);
		
		//step2: Get connection from database
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45", "root", "root");

		//step3: Issue insert statement
		Statement state = con.createStatement();
		String query = "insert into studentInfo values('Nitish','btm','APPIUM',1);";
		
		//step4: update Query
		 result = state.executeUpdate(query);	
	
		}
		 catch (Exception e) {
			
			}
		finally {
			if(result==1)
				System.out.println("Data insert successful");
			else
				System.out.println("Data not inserted ");
			//Step5: Close the database
			con.close();
			
		}
}
}
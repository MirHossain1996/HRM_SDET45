package Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Readprojects {

	public static void main(String[] args) throws SQLException {
	Connection con=null;
	try {
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
	Statement statement = con.createStatement();
	String query = "select * from project;";
	
	ResultSet result = statement.executeQuery(query);

	while(result.next()) {
		System.out.println(result.getString(1)+"  "+result.getString(2));
	}
	}
	catch (Exception e) {
		System.out.println("exception is present please check the try block");
	}
	finally {
		con.close();
	}
	}
	

}

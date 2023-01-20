package Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class UpdateProjects {
public static void main(String[] args) throws SQLException {
	Connection con=null;
	int result=0;
	try {
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
	Statement statement = con.createStatement();
	String query = "insert into project values('TY_Project_42','RobertWilliam','22-12-22','HRM','ongoing',3);";
	result=statement.executeUpdate(query);
	}
	catch (Exception e) {
		System.out.println("exception is present");
	}
	finally {
		if(result==1)
			System.out.println("Data is upadated");
		else
			System.out.println("Data is not upadated");
		
	}
	con.close();
}
}


package Practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Read {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45", "root", "root");
		Statement statement = con.createStatement();
		String query = "select * from studentInfo;";
		ResultSet result = statement.executeQuery(query);
		while(result.next()) {
			System.out.println(result.getString(1));
		}

	}
		catch (Exception e) {
		System.out.println("quesry is wrong");
	}
finally {
	con.close();
}
}
}
package com.hrm.genriUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
/**
 * It is used to connect to database
 * @author MIR
 *
 */
public class DatabaseUtility {
	Connection con=null;
	public void connectToDatabse() throws Throwable {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(iPathContent.url, iPathContent.HrAssistantEmail, iPathContent.HrAssistantPwd);
		
	}
	/**
	 * It is execute to sql query.
	 * @param query
	 * @param columnIndex
	 * @param expData
	 * @return
	 * @throws Throwable
	 */
	public String executeQueryAndgetData(String query, int columnIndex, String expData) throws Throwable {
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag=false;
		while(result.next()) {
			String data = result.getString(columnIndex);
			if(data.equalsIgnoreCase(expData)) {
				flag=true;
				break;
			}
		}
		if(flag) {
			System.out.println(expData+"  Project is created.");
			return expData;
		}
		else {
			System.out.println(expData+"  Project is not created.");
			return "";
		}
		
	}
}

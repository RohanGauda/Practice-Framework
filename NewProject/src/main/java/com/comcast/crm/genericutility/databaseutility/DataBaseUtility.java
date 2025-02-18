package com.comcast.crm.genericutility.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.comcast.crm.genericutility.fileutility.FileUtility;
import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	
	Connection conn = null;
	Statement stat = null;
	
	public void getDataBaseConnection() throws Throwable {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			FileUtility fu = new FileUtility();
			String DBURL = fu.getDataFromProperties("DBurl");
			String DBUSERNAME = fu.getDataFromProperties("DBusername");
			String DBPASSWORD = fu.getDataFromProperties("DBpassword");
			conn = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD);
			stat = conn.createStatement();
		}
		catch(Exception e) {
			
		}
	}
	
	public ResultSet getExecuteQuery(String query) throws SQLException {
		ResultSet executeQuery = null;
		try {
			executeQuery = stat.executeQuery(query);
		}
		catch (Exception e) {
		}
		
		return executeQuery;
	}
	
	public int getExecuteUpdate(String query) throws Throwable {
		int data = 0;
		try {
			data = stat.executeUpdate(query);
		}
		catch (Exception e) {
		}
		
		return data;
	}
	
	public void getCloseConnection() {
		try {
			conn.close();
		}
		catch (Exception e) {
		}
	}
}

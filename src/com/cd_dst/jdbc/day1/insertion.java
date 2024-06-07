/**
 * 
 */
package com.cd_dst.jdbc.day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 
 */
public class insertion {

	private static Connection connection;
	private static Statement statement;

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		try {
			//Step - 01
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is loaded");
			
			//Step - 02
			connection = DriverManager.getConnection(Credentials.url,Credentials.user,Credentials.pwd);
			if (connection == null){
				System.out.println("No connection Received");
			}
			else {
				System.out.println("Connection Established to db");
			}
			
			//Step - 03
			
			String query = "insert into test_table values(1,'Ram')";
			statement = connection.createStatement();
			
			//Step - 04
			int x = statement.executeUpdate(query);
			if(x>0) {
				System.out.println("insertion done");
			}
			else {
				System.out.println("insetion failed");
			} 
			
			
		}
		catch(ClassNotFoundException e) {
			System.out.println("The class is not found");
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Sql exception ");
		}
		finally {
			//Step - 05
			statement.close();
		}

	}

}

/**
 * 
 */
package com.cd_dst.jdbc.day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 
 */
public class DatabaseCreation {

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
			String query = "Create Database Sample_db4";
			statement = connection.createStatement();
			
			//Step - 04
			int x = statement.executeUpdate(query);
			if(x>0) {
				System.out.println("Database Creted");
			}
			else {
				System.out.println("Database Creation failed");
			} 
			
			
			
			
		}
		catch(ClassNotFoundException e) {
			System.out.println("The class is not found");
		}
		catch(SQLException e) {
			System.out.println("Sql exception ");
		}
		finally {
			//Step - 05
			statement.close();
		}

	}

}

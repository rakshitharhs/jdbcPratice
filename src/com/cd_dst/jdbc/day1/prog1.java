/**
 * 
 */
package com.cd_dst.jdbc.day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 */
public class prog1 {

	private static Connection connection;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is loaded");
			connection = DriverManager.getConnection(Credentials.url,Credentials.user,Credentials.pwd);
			if (connection == null){
				System.out.println("No connection Received");
			}
			else {
				System.out.println("Connection Established to db");
			}
		}
		catch(ClassNotFoundException e) {
			System.out.println("The class is not found");
		}
		catch(SQLException e) {
			System.out.println("Sql exception ");
		}

	}

}

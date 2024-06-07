/**
 * 
 */
package com.cd_dst.jdbc.day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


/**
 * 
 */
public class DynamicUpdation {

	private static Connection connection;
	private static Statement statement;
	private static PreparedStatement preparedStatement;

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
			
			String query = "update test_table set name=? where id=?";
			
			preparedStatement = connection.prepareStatement(query);
			
			Scanner sc= new Scanner(System.in);
			
			System.out.println("Enter new name");
			String name = sc.next();
			System.out.println("Enter id to be updated");
			int id = sc.nextInt();
			
			
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, id);
			statement = connection.createStatement();
			
			//Step - 04
			int x = preparedStatement.executeUpdate();
			if(x>0) {
				System.out.println("updation done");
			}
			else {
				System.out.println("updation failed");
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
			preparedStatement.close();
		}

	}

}

package com.duyhat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
Connecting to ClearDB and querying data all in one
*/
public class ClearTest {
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	public void readDatabase() throws Exception {
		try {
			// Load the driver for MySQL
			Class.forName("com.mysql.jdbc.Driver");
			/* Setup the connection
			jdbc:mysql://my-sql-server/mysql-database?"
					+ "user=mysql-username&password=mysql-password
			*/
			connect = DriverManager
					.getConnection("jdbc:mysql://us-cdbr-iron-east-03.cleardb.net/ad_f0f92308cad2c21?"
							+ "user=bfcc2dcd2a0158&password=3158d43b");
			statement = connect.createStatement();
			// Resultset to get the data from executing the statement. fautest is my table
			resultSet = statement
					.executeQuery("select * from ad_f0f92308cad2c21.fautest");
			displayData(resultSet);
// Dirty exeption catch
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}

				if (statement != null) {
					statement.close();
				}

				if (connect != null) {
					connect.close();
				}
			} catch (Exception e) {
				throw e;
			}
		}

	}
/*
Dummy data displaying
*/
	private void displayData(ResultSet rs) throws SQLException {
		while (rs.next()) {
			String name = rs.getString("name");
			String age = rs.getString("age");
			System.out.println("Name: " + name);
			System.out.println("Age: " + age);
		}
	}

}

/*
 * CREATE TABLE `ad_f0f92308cad2c21`.`fautest` (
  `name` VARCHAR(225) NOT NULL COMMENT '',
  `age` INT NOT NULL COMMENT '');

 * */

package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDataJDBC {

	public static void main(String[] args) throws SQLException {
		insert();

	}
	
	public static void insert() throws SQLException {
		
		try {
			//load a driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// create connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
					+ "testperson?useSSL=false","root","root");
			Statement stmt = conn.createStatement();
			conn.setAutoCommit(false);
			int i= stmt.executeUpdate("insert into part values (13,'plat123','grey',4)");
			
			System.out.println(i+ "Record updated");
			conn.commit();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

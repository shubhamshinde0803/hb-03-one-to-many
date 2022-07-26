package com.shubham.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String JdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSl=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pass = "hbstudent";
		try {
			System.out.println("Connecting to database: " + JdbcUrl);
			
			Connection myCon = DriverManager.getConnection(JdbcUrl, user, pass);
			
			System.out.println("connection successful...");
		}catch(Exception exp) {
			exp.printStackTrace();
		}
	}

}

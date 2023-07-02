package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test_Jdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String user = "root";
		String password = "qwertyuiop";
		try {
			
			System.out.println("Connectiong to database: " + jdbcUrl);
			Connection con = 
					DriverManager.getConnection(jdbcUrl,user,password);
			System.out.println("Connection Sucessful");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test_Jdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "c##Priyank";
		String password = "123";
		try {
			
			System.out.println("Connectiong to database: " + jdbcUrl);
			Connection con = 
					DriverManager.getConnection(jdbcUrl,user,password);
			System.out.println("Connection Sucessful");
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from loan");
			
			System.out.println(rs.toString());
			while (rs.next()) {
				System.out.println(rs.getInt("id") +" "+rs.getString("name")+" " + rs.getInt("amount"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

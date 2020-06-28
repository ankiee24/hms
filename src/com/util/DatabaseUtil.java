package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseUtil {
	private static final String url="jdbc:mysql://localhost:3306/customer?" + "autoReconnect=true&useSSL=false";
	private static final String username="root";
	private static final String pass="ankit";
	
	public static Connection getConnection() throws SQLException
	{
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,username,pass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
	public static void closeConnection(Connection con)
	{
		if(con!=null)
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static void closeStatement(PreparedStatement ps)
	{
		if(ps!=null)
		{
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	

}

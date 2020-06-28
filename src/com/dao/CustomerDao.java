package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.bean.Customer;

import com.util.DatabaseUtil;


public class CustomerDao {
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public boolean addCustomer(Customer customer) throws SQLException
	{
		boolean flag=false;
		try {
			con=DatabaseUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ps=con.prepareStatement("INSERT INTO user(FirstName,LastName,dob,Gender,City,Country,Email,Annual_salary) VALUES(?,?,?,?,?,?,?,?)");
		ps.setString(1, customer.getFirstName());
		ps.setString(2, customer.getLastName());
		ps.setDate(3, new java.sql.Date(customer.getDob().getTime()));
		ps.setString(4, customer.getGender());
		ps.setString(5,customer.getCity());
		ps.setString(6,customer.getCountry());
		ps.setString(7,customer.getEmail());
		ps.setDouble(8,customer.getAnnual_salary());
		
		int rowstatus=ps.executeUpdate();
		DatabaseUtil.closeConnection(con);
		DatabaseUtil.closeStatement(ps);
		if(rowstatus>0)
		{
			return true;
			
		}
		return flag;
		
		
		
		
	}
	public Customer searchCustomerbyId(int id) throws SQLException {
		// TODO Auto-generated method stub
		
		Customer cus=null;
		//boolean flag=false;
		con=DatabaseUtil.getConnection();
		ps=con.prepareStatement("SELECT * FROM user where CustomerId = ?");
		ps.setInt(1, id);
		rs=ps.executeQuery();
		while(rs.next())
		{
			cus=new Customer();
			cus.setId(rs.getInt(1));
			cus.setFirstName(rs.getString(2));
			cus.setLastName(rs.getString(3));
			cus.setDob(rs.getDate(4));
			cus.setGender(rs.getString(5));
			cus.setCity(rs.getString(6));
			cus.setCountry(rs.getString(7));
			cus.setEmail(rs.getString(8));
			cus.setAnnual_salary(rs.getDouble(9));
			
			
		}
		DatabaseUtil.closeConnection(con);
		DatabaseUtil.closeStatement(ps);
		return cus;
	}

}

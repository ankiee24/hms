package com.service;

import java.sql.SQLException;

import com.bean.Customer;

import com.dao.CustomerDao;

public class CustomerService {
	CustomerDao dao=new CustomerDao();
	public boolean addCustomer(Customer customer) throws SQLException
	{
		
			return dao.addCustomer(customer);
		
	}
	public Customer searchCustomerbyId(int id) throws SQLException
	{
		return  dao.searchCustomerbyId(id);
		
	}
	

}

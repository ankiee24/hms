package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Customer;

import com.service.CustomerService;
import com.util.DateUtil;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String source=request.getParameter("source");
		if(source.equals("add"))
		
		{
			 String page = "";
			    try {

			    } catch (Exception e) {
			      page = "error.jsp";
			    } finally {
			      page = "AddCustomer.html";
			    }
			    RequestDispatcher dd=request.getRequestDispatcher(page);
			    dd.forward(request, response);

			//response.sendRedirect("AddCustomer.html");
		}
		if(source.equals("search"))
			
			{
				response.sendRedirect("search.html");
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String source=request.getParameter("source");
		CustomerService service=new CustomerService();
		Customer customer=new Customer();
		if(source.equals("AddCustomer"))
		{
			
			customer.setFirstName(request.getParameter("firstName"));
			customer.setLastName(request.getParameter("lastName"));
			customer.setDob(DateUtil.convertStringtodate(request.getParameter("dob"),"dd/MM/yyyy"));
			customer.setGender(request.getParameter("gender"));
			customer.setCity(request.getParameter("city"));
			customer.setCountry(request.getParameter("country"));
			customer.setAnnual_salary(Double.parseDouble(request.getParameter("annual_salary")));
			customer.setEmail(request.getParameter("email"));
			System.out.println("Customer Details:"+customer);	
			
		
		boolean flag = false;
		try {
			flag = service.addCustomer(customer);
			System.out.println(flag);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag)
		{
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.print("<html>");
			out.print("<head>");
			out.print("<title>View Customer</title>");
			out.print("</head>");
			out.print("<body>");
			
			out.print("First Name : "+customer.getFirstName()+"<br>");
			out.print("Last Name : "+customer.getLastName()+"<br>");
			out.print("Date of Birth : "+customer.getDob()+"<br>");
			out.print("Gender : "+customer.getGender()+"<br>");
			out.print("City : "+customer.getCity()+"<br>");
			out.print("Country : "+customer.getCountry()+"<br>");
			out.print("Email : "+customer.getEmail()+"<br>");
			out.print("Annual Salary : "+customer.getAnnual_salary()+"<br>");
			
			
			out.print("</body>");
			out.print("</html>");
		}
		}
		
		if(source.equals("Search"))
		{
		Customer cus=null;
		ArrayList<Customer>customerList=null;
		  //String source1=request.getParameter("searchPram");
			String customerId=request.getParameter("searchParam");
			System.out.print(customerId);
			try {
				 cus=service.searchCustomerbyId(Integer.parseInt(customerId));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.print("<html>");
			out.print("<head>");
			out.print("<title>Customer Details</title>");
			out.print("</head>");
			out.print("<body>");
			
			if(cus!=null)
			{ 
				out.print(" <table border=\"1\" cellpadding=\"1\" cellspacing=\"1\"");
				out.print("<tr>");
				out.print("<td>CUSTOMER ID </td>");
				out.print("<td>FIRST NAME </td>");
				out.print("<td>LAST NAME</td>");
				out.print("<td>DOB</td>");
				out.print("<td>GENDER</td>");
				out.print("<td>CITY</td>");
				out.print("<td>COUNTRY </td>");
				out.print("<td>EMAIL</td>");
				out.print("<td>ANNUAL INCOME </td>");
				out.print("</tr>");
				
				out.print("<tr>");
				out.print("<td>"+cus.getId()+"</td>");
				out.print("<td>"+cus.getFirstName()+"</td>");
				out.print("<td>"+cus.getLastName()+"</td>");
				out.print("<td>"+cus.getDob()+"</td>");
				out.print("<td>"+cus.getGender()+"</td>");
				out.print("<td>"+cus.getCity()+"</td>");
				out.print("<td>"+cus.getCountry()+"</td>");
				out.print("<td>"+cus.getEmail()+"</td>");
				out.print("<td>"+cus.getAnnual_salary()+"</td>");
				out.print("</tr>");
				out.print("</table>");
				}
			else
			{
				out.print("Customer not exits with id: "+customerId);
			}
			out.print("</body>");
			out.print("</html>");		
		}
		
		
	}

}

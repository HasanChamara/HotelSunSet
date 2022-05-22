package CustomerManagement.controller;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import CustomerManagement.bean.Customer;
import CustomerManagement.dao.CustomerDAO;



@WebServlet("/")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDAO customerDAO;
	
	public void init() {
		customerDAO = new CustomerDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertCustomer(request, response);
				break;
			case "/delete":
				deleteCustomer(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateCustomer(request, response);
				break;
			case "/report":
				showreport(request, response);
				break;
			default:
				listCustomer(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	
	//list customer method
		private void listCustomer(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
			List<Customer> listCustomer = customerDAO.selectAllCustomers();
			request.setAttribute("listCustomer", listCustomer);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Customer-list.jsp");
			dispatcher.forward(request, response);
		}
		
		
	//report generation
		private void showreport(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
			List<Customer> listCustomer = customerDAO.selectAllCustomers();
			request.setAttribute("listCustomer", listCustomer);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ReportGeneration.jsp");
			dispatcher.forward(request, response);
		}
		
		
		private void showNewForm(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Customer-insert.jsp");
			dispatcher.forward(request, response);
		}
		
		
	//Edit customer
		private void showEditForm(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			Customer existingCustomer = customerDAO.selectCustomer(id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("editCustomer-form.jsp");
			request.setAttribute("customer", existingCustomer);
			dispatcher.forward(request, response);

		}	
		
		
	//insert customer method
		private void insertCustomer(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException {
			String title = request.getParameter("title");
			String fname = request.getParameter("fname");	
			String lname = request.getParameter("lname");
			String email = request.getParameter("email");
			int phoneNo = Integer.parseInt(request.getParameter("phoneNo"));
			String nationality = request.getParameter("nationality");
			Customer newCustomer = new Customer(title,fname,lname,email,phoneNo,nationality);
			customerDAO.insertCustomer(newCustomer);
			response.sendRedirect("list");
		}
		
		
	//update customer method
		private void updateCustomer(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			String title = request.getParameter("title");
			String fname = request.getParameter("fname");	
			String lname = request.getParameter("lname");
			String email = request.getParameter("email");
			int phoneNo = Integer.parseInt(request.getParameter("phoneNo"));
			String nationality = request.getParameter("nationality");

			Customer customer = new Customer(id,title,fname,lname,email,phoneNo,nationality);
			customerDAO.updateCustomer(customer);
			response.sendRedirect("list");
		}	
		
		
		//delete customer method
		private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			customerDAO.deleteCustomer(id);
			response.sendRedirect("list");

		}			
		
}
	
	
	
	
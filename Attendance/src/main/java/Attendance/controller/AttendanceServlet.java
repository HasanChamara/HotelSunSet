package Attendance.controller;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Attendance.bean.Attendance;
import Attendance.dao.AttendanceDAO;



@WebServlet("/")
public class AttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AttendanceDAO attendanceDAO;
	
	public void init() {
		attendanceDAO = new AttendanceDAO();
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
				insertAttendance(request, response);
				break;
			case "/delete":
				deleteAttendance(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateAttendance(request, response);
				break;
			case "/report":
				showreport(request, response);
				break;
			default:
				listAttendance(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	//list Attendance method
	private void listAttendance(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Attendance> listAttendance= attendanceDAO.selectAllAttendance();
		request.setAttribute("listAttendance", listAttendance);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Attendance-list.jsp");
		dispatcher.forward(request, response);
	}
	
	
	//report generation
		private void showreport(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
			List<Attendance> listAttendance = attendanceDAO.selectAllAttendance();
			request.setAttribute("listAttendance", listAttendance);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ReportGeneration.jsp");
			dispatcher.forward(request, response);
		}
	

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Attendance-insert.jsp");
		dispatcher.forward(request, response);
	}

	//Edit Attendance
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Attendance existingAttendance = attendanceDAO.selectAttendance(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Attendance-Update.jsp");
		request.setAttribute("attendance", existingAttendance);
		dispatcher.forward(request, response);

	}

	//insert Attendance method
	private void insertAttendance(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String typeOfWork = request.getParameter("typeOfWork");
		String date = request.getParameter("date");		
		String inTime = request.getParameter("inTime");	
		String outTime = request.getParameter("outTime");
		
		Attendance newAttendance = new Attendance(name,typeOfWork,date,inTime,outTime);
		attendanceDAO.insertAttendance(newAttendance);
		response.sendRedirect("list");
	}

	//update Attendance method
	private void updateAttendance(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String typeOfWork = request.getParameter("typeOfWork");
		String date = request.getParameter("date");		
		String inTime = request.getParameter("inTime");	
		String outTime = request.getParameter("outTime");
		
		Attendance attendance = new Attendance(id,name,typeOfWork,date,inTime,outTime);
		attendanceDAO.updateAttendance(attendance);
		response.sendRedirect("list");
	}

	//delete Attendance method
	private void deleteAttendance(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		attendanceDAO.deleteAttendance(id);
		response.sendRedirect("list");

	}

}

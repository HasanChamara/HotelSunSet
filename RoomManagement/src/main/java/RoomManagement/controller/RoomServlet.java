package RoomManagement.controller;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import RoomManagement.bean.Room;
import RoomManagement.dao.RoomDAO;



@WebServlet("/")
public class RoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RoomDAO roomDAO;
	
	public void init() {
		roomDAO = new RoomDAO();
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
				insertRoom(request, response);
				break;
			case "/delete":
				deleteRoom(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateRoom(request, response);
				break;
			case "/report":
				showreport(request, response);
				break;
			default:
				listRoom(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	//list room method
	private void listRoom(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Room> listRoom = roomDAO.selectAllRooms();
		request.setAttribute("listRoom", listRoom);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Room-list.jsp");
		dispatcher.forward(request, response);
	}
	
	
	//report generation
		private void showreport(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
			List<Room> listRoom = roomDAO.selectAllRooms();
			request.setAttribute("listRoom", listRoom);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ReportGeneration.jsp");
			dispatcher.forward(request, response);
		}
	

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Room-insert.jsp");
		dispatcher.forward(request, response);
	}

	//Edit room
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Room existingRoom = roomDAO.selectRoom(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Room-Update.jsp");
		request.setAttribute("room", existingRoom);
		dispatcher.forward(request, response);

	}

	//insert room method
	private void insertRoom(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String number = request.getParameter("number");
		String type = request.getParameter("type");		
		int noOfBeds = Integer.parseInt(request.getParameter("noOfBeds"));
		String wifi = request.getParameter("wifi");
		String phoneService = request.getParameter("phoneService");
		
		
		Room newRoom = new Room(number,type, noOfBeds,wifi,phoneService);
		roomDAO.insertRoom(newRoom);
		response.sendRedirect("list");
	}

	//update room method
	private void updateRoom(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String number = request.getParameter("number");
		String type = request.getParameter("type");		
		int noOfBeds = Integer.parseInt(request.getParameter("noOfBeds"));
		String wifi = request.getParameter("wifi");
		String phoneService = request.getParameter("phoneService");

		Room room = new Room(id,number,type, noOfBeds,wifi,phoneService);
		roomDAO.updateRoom(room);
		response.sendRedirect("list");
	}

	//delete room method
	private void deleteRoom(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		roomDAO.deleteRoom(id);
		response.sendRedirect("list");

	}

}

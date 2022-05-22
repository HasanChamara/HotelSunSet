package Reservation.controller;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Reservation.bean.Reservation;
import Reservation.dao.ReservationDAO;
import Reservation.bean.Room;


@WebServlet("/")
public class ReservationServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private ReservationDAO reservationDAO;
	
	
	public void init() {
		reservationDAO = new ReservationDAO();
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
				showNewReservationForm(request, response);
				break;
			case "/Rinsert":
				insertReservation(request, response);
				break;
			case "/RReport":
				listReservationAndRoom(request, response);
				break;
			default:
				listAvailableRooms(request, response);
				break;
			}
			
		} catch (SQLException ex) {
			System.out.print(ex);
			throw new ServletException(ex);
		}
	}
	
	
	//list Available room method
	private void listAvailableRooms(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Room> listAvailableRooms = reservationDAO.selectAvailableRooms();
		request.setAttribute("listARoom", listAvailableRooms);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Available-Rooms.jsp");
		dispatcher.forward(request, response);
	}
	
	
	//insert reservation method
			private void insertReservation(HttpServletRequest request, HttpServletResponse response) 
					throws SQLException, IOException, ServletException {
				int customerid = Integer.parseInt(request.getParameter("customerid"));
				String checkindate = request.getParameter("checkindate");		
				String checkoutdate = request.getParameter("checkoutdate");
				String paymentMethod = request.getParameter("paymentMethod");
				
//				System.out.println(" url "+request.getContextPath().toString());
				Reservation newRoomreservation = new Reservation(customerid, checkindate, checkoutdate, paymentMethod);
				reservationDAO.insertReservaton(newRoomreservation);
				response.sendRedirect("RR.jsp");
				
				
				
//				List<Room> listARoom = roomDAO.selectAvailableRooms();
//				request.setAttribute("listARoom", listARoom);
//				RequestDispatcher dispatcher = request.getRequestDispatcher("http://localhost:8096/RoomManagement/ava"); //request.getContextPath() + "/ava"
//				dispatcher.forward(request, response);
				
//				response.sendRedirect(request.getContextPath() + "/ava");
				
//				response.sendRedirect("Available-Rooms.jsp");
				
			}
	
			private void showNewReservationForm(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				RequestDispatcher dispatcher = request.getRequestDispatcher("Reservation-Insert.jsp");
				dispatcher.forward(request, response);
			}
	
	
			//list reservation And Rooms method
			private void listReservationAndRoom(HttpServletRequest request, HttpServletResponse response)
					throws SQLException, IOException, ServletException {
				List<Reservation> listReservation = reservationDAO.selectAllReservations();
				request.setAttribute("listReservation", listReservation);
				//List<Room> listRoom = roomDAO.selectAllRooms();
				//request.setAttribute("listRoom", listRoom);
				
				int id = Integer.parseInt(request.getParameter("id"));
				List<Room> listRoom = reservationDAO.selectIndividualRoom(id);
				request.setAttribute("listRoom", listRoom);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("Rr2html.jsp");
				dispatcher.forward(request, response);
			}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

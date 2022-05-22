package MemberManagement.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MemberManagement.bean.Member;
import MemberManagement.dao.MemberDAO;


@WebServlet("/")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberDAO memberDAO;
	
	public void init() {
		memberDAO = new MemberDAO();
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
				insertMember(request, response);
				break;
			case "/delete":
				deleteMember(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateMember(request, response);
				break;
			case "/report":
				showreport(request, response);
				break;
			default:
				listMember(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	
	//list member method
		private void listMember(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
			List<Member> listMember = memberDAO.selectAllMembers();
			request.setAttribute("listMember", listMember);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Member-list.jsp");
			dispatcher.forward(request, response);
		}
		
		
	//report generation
		private void showreport(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
			List<Member> listMember = memberDAO.selectAllMembers();
			request.setAttribute("listMember", listMember);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ReportGeneration.jsp");
			dispatcher.forward(request, response);
		}
		
		
		private void showNewForm(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Member-insert.jsp");
			dispatcher.forward(request, response);
		}
		
		
	//Edit member
		private void showEditForm(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, ServletException, IOException {
			int no = Integer.parseInt(request.getParameter("no"));
			Member existingMember = memberDAO.selectMember(no);
			RequestDispatcher dispatcher = request.getRequestDispatcher("editMember-form.jsp");
			request.setAttribute("member", existingMember);
			dispatcher.forward(request, response);

		}	
		
		
	//insert member method
		private void insertMember(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException {
			String name = request.getParameter("name");
			int cid = Integer.parseInt(request.getParameter("cid"));	
			String type = request.getParameter("type");
			String sdate = request.getParameter("sdate");
			String edate = request.getParameter("edate");
			Member newMember = new Member(name,cid,type,sdate,edate);
			memberDAO.insertMember(newMember);
			response.sendRedirect("list");
		}
		
		
	//update member method
		private void updateMember(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException {
			int no = Integer.parseInt(request.getParameter("no"));
			String name = request.getParameter("name");
			int cid = Integer.parseInt(request.getParameter("cid"));	
			String type = request.getParameter("type");
			String sdate = request.getParameter("sdate");
			String edate = request.getParameter("edate");

			Member member = new Member(no,name,cid,type,sdate,edate);
			memberDAO.updateMember(member);
			response.sendRedirect("list");
		}	
		
		
		//delete customer method
		private void deleteMember(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException {
			int no = Integer.parseInt(request.getParameter("no"));
			memberDAO.deleteMember(no);
			response.sendRedirect("list");

		}
	

}

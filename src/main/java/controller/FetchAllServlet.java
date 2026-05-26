package controller;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserDao;

@WebServlet("/fetchAll")
public class FetchAllServlet extends HttpServlet {
	
	@Override
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) {
		
		UserDao dao = new UserDao();
		
		try {
			
			List list = dao.fetchAll();
			req.setAttribute("list", list);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("FetchAll.jsp");
			dispatcher.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

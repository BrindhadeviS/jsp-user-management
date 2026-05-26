package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserDao;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		UserDao dao = new UserDao();
		
		try {
			dao.deleteUser(id);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("fetchAll");
			dispatcher.forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

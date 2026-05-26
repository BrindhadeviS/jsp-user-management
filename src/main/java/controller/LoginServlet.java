package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		PrintWriter out = res.getWriter();
		
		UserDao dao = new UserDao();
		
		try {
			
			User u = dao.fetchUSerByEmail(email);
			
			if(u != null ) {
				
				if(u.getPassword().equals(password)) {
					RequestDispatcher dispatcher = req.getRequestDispatcher("fetchAll");
					dispatcher.forward(req, res);
				}
				else {
					out.print("<h1 id='edit'> Incorrect Password! </h1>");

					RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
					dispatcher.include(req, res);
				}
			}
			else {
				out.print("<h1 id ='edit'> Email not found! </h1>");
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
				dispatcher.include(req, res);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

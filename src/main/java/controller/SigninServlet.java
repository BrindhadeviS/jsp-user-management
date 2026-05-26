package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserDao;

@WebServlet("/signin")
public class SigninServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		String password= req.getParameter("password");
		long phone = Long.parseLong(req.getParameter("phone"));
		
		User u = new User();
		u.setId(id);
		u.setFname(fname);
		u.setLname(lname);
		u.setEmail(email);
		u.setPassword(password);
		u.setPhone(phone);
		
		UserDao dao = new UserDao();
		
		PrintWriter out = resp.getWriter();
		
		try {
			dao.saveUser(u);
			resp.sendRedirect("login.jsp");
		} catch (Exception e) {
			out.print(e);
			e.printStackTrace();
		}

	}
}

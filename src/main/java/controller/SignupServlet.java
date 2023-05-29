package controller;

import java.io.IOException;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import dto.Student;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//to get all the data u have entered in browser using getparameter
	//to store the data in database
	
		Student student=new Student();
		student.setName(req.getParameter("name"));
		student.setEmail(req.getParameter("email"));
		student.setNumber(Long.parseLong(req.getParameter("number")));
		student.setPassword(req.getParameter("password"));
		student.setGender(req.getParameter("gender"));	
		
		StudentDao std=new StudentDao();
		std.save(student);
		 
		resp.getWriter().print("<h1>data saved successfully</h1>");
	    req.getRequestDispatcher("Home.html").include(req, resp);

	}
	
}

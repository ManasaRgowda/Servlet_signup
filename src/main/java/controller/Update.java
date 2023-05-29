package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import dto.Student;

@WebServlet("/update")
public class Update extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student student=new Student();
		
		student.setId(Integer.parseInt(req.getParameter("id")));
		student.setName(req.getParameter("name"));
		student.setEmail(req.getParameter("email"));
		student.setNumber(Long.parseLong(req.getParameter("number")));
		student.setPassword(req.getParameter("password"));
		student.setGender(req.getParameter("gender"));	
		
		StudentDao std=new StudentDao();
		std.update(student);
		 
		resp.getWriter().print("<h1>data updates successfully</h1>");
	    req.getRequestDispatcher("Home.html").include(req, resp);

}
}
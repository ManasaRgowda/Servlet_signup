package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import dto.Student;

@WebServlet("/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
             String email=req.getParameter("email");   //names present in login.html
             String password=req.getParameter("password");
           
             StudentDao st1=new StudentDao();
             Student student;
             
             try{
            	 long number=Long.parseLong(email);  //fetch by email or number
	             student=st1.fetch(number);
             }
             catch(NumberFormatException e){
            	 student=st1.fetch(email);
             }
             
	     if(student==null){
	    	 resp.getWriter().print("<h1>INVALID Email</h1>");
    		 req.getRequestDispatcher("Login.html").include(req, resp);

	     }
	     else{
	    	 if(student.getPassword().equals(password))
	    	 {
	    		 resp.getWriter().print("<h1>login success</h1>");
	    		 req.setAttribute("student", student);
	    		 req.setAttribute("list", st1.fetch());
	    		 req.getRequestDispatcher("Success.jsp").include(req, resp);
	    	 }
	    	 else{
	    		 resp.getWriter().print("<h1>invalid password</h1>");
	    		 req.getRequestDispatcher("Login.html").include(req, resp);
	    	 }
	     }
	}
}

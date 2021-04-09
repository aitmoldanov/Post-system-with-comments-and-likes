package kz.iitu.Servlets;


import kz.iitu.DAO;
import kz.iitu.Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/UserSignUpServlet")
public class UserSignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		if(username != null && password != null && email != null){
			try{
				User newUser = new User();
				newUser.setName(username);
				newUser.setPassword(password);
				newUser.setEmail(email);

				boolean isSignedUp = DAO.addNewUser(newUser);

				response.setContentType("text/html");
				if(isSignedUp){
					out.print("<h3>You are Signed Up Successfully!</h3>");
					out.print("<a href='Login.jsp'>Go To Login Page</a>");
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				out.close();
			}
		}else{
			response.sendRedirect("signUp.jsp");
		}
	}
}

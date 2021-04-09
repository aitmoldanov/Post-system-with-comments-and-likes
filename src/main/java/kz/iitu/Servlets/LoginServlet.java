package kz.iitu.Servlets;

import kz.iitu.DAO;
import kz.iitu.Model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String formUsername = request.getParameter("email");
		String formPassword = request.getParameter("password");

		HttpSession userSession = request.getSession(false);
		RequestDispatcher forwardUser = null;

		if (formUsername != null && formPassword != null ) {
			try {
				if (DAO.getUserAuthenticate(formUsername, formPassword)) {
					User user = new DAO().fetchUser(formUsername);
					userSession = request.getSession(true);
					userSession.setAttribute("userSession", formUsername);
					userSession.setAttribute("userStatus", "true");
					userSession.setAttribute("user", "user");
					request.getSession().setAttribute("logged_user", user);
					forwardUser = getServletContext().getRequestDispatcher("/ListOfPosts.jsp");
					forwardUser.include(request, response);
				} else {
					userSession.setAttribute("status", "false");
					forwardUser = getServletContext().getRequestDispatcher("/Login.jsp");
					PrintWriter out = response.getWriter();
					forwardUser.include(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			response.sendRedirect("Login.jsp");
		}
	}
}

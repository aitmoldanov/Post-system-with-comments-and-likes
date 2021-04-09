package kz.iitu.Servlets;


import kz.iitu.DAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/GetListOfPost")
public class GetListOfPostServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO postDao = new DAO();
		List<?> posts = null;
		try {
			posts = postDao.fetch();
		} catch (Exception e) {
			request.getSession().setAttribute("exception",e.getMessage());
		}
		request.getSession().setAttribute("posts",posts);
		response.sendRedirect("index.jsp");
	}

}

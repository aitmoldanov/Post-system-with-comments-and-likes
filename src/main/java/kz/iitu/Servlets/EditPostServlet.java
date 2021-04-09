package kz.iitu.Servlets;



import kz.iitu.DAO;
import kz.iitu.Model.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/EditPostServlet")
public class EditPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String postId = request.getParameter("postId");
		Post post = new Post();

		if(postId != null && !(postId.equals(""))){
			try {
				post = new DAO().fetchSingle(Integer.parseInt(postId));
			} catch (Exception e) {
				request.getSession().setAttribute("exception",e.getMessage());
			}
			request.getSession().setAttribute("post", post);
			request.getSession().setAttribute("postId", post.getId());
			response.sendRedirect("EditPost.jsp");
		}else{
			response.sendRedirect("ListOfPosts.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int postId = (int) request.getSession().getAttribute("postId");
		String theme= request.getParameter("topic");
		String body = request.getParameter("body");
		Post post = new Post();
		HttpSession adminSession = request.getSession(false);

		boolean status = false;
		PrintWriter out = response.getWriter();
		if(!theme.equals("") && !body.equals("") && postId != 0){
			post.setId(postId);
			post.setTopic(theme);
			post.setBody(body);
			try {
				status = new DAO().updateEditedPost(post);
			} catch (Exception e) {
				adminSession.setAttribute("exception",e);
				e.printStackTrace();
			}
			if(status){
				response.sendRedirect("ListOfPosts.jsp");
			}else{
				response.sendRedirect("ListOfPosts.jsp");
			}
		}else{
			out.println("<script>alert('Try again')</script>");
			response.sendRedirect("PostList.jsp");
		}
	}

}

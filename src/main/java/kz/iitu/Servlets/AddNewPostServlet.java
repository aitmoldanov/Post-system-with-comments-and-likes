package kz.iitu.Servlets;

import kz.iitu.DAO;
import kz.iitu.Model.Post;
import kz.iitu.Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddNewPostServlet")
public class AddNewPostServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Post post = new Post();
        boolean status = false;
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        String topic = request.getParameter("topic");
        String body = request.getParameter("body");
        HttpSession adminSession = request.getSession(false);
        User user = (User) request.getSession().getAttribute("loggedUser");

        if(!topic.equals("") && !body.equals("")){
            post.setTopic(topic);
            post.setBody(body);
            post.setLike(0);
            post.setDislike(0);
            post.setUserId(user.getId());
                status = new DAO().createPost(post);
            if(status){
                out.println("<script>alert('Post successfully added!')</script>");
                adminSession.setAttribute("message","Post successfully added!" );
                response.sendRedirect("ListOfPosts.jsp");
            }else{
                out.println("<script>alert('Error ! This kind of post already exists in the base')</script>");
                adminSession.setAttribute("message","Error ! Try again!" );
                response.sendRedirect("ListOfPosts.jsp");
            }
        }else{
            out.println("<script>alert('Try again !')</script>");
            response.sendRedirect("ListOfPosts.jsp");
        }


    }
}

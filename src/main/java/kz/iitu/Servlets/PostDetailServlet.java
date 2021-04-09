package kz.iitu.Servlets;

import kz.iitu.DAO;
import kz.iitu.Model.Comment;
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
import java.util.List;


@WebServlet("/PostDetailServlet")
public class PostDetailServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String postId = request.getParameter("postId");
        List<?> comments = null;
        Post post = new Post();

        if(postId != null && !(postId.equals(""))){
            try {
                post = new DAO().fetchSingle(Integer.parseInt(postId));
                comments = new DAO().fetchComments(post.getId());
            } catch (Exception e) {
                request.getSession().setAttribute("exception",e.getMessage());
            }
            request.getSession().setAttribute("post", post);
            request.getSession().setAttribute("comments",comments);
            response.sendRedirect("AuthUserPostDetail.jsp");
        }else{
            response.sendRedirect("index.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Comment newComment = new Comment();


        boolean status = false;
        DAO dao = new DAO();
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String comment = request.getParameter("comment");
        Post post = (Post) request.getSession().getAttribute("post");
        HttpSession userSession = request.getSession(false);
        User user = (User) request.getSession().getAttribute("logged_user");
        dao.updatePost(post);
        if(!comment.equals("")){
            newComment.setPostId(post.getId());
            newComment.setComment(comment);
            newComment.setUserName(user.getName());
            try {
                status = dao.insert(newComment);
            } catch (Exception e) {
                userSession.setAttribute("exception",e);
                e.printStackTrace();
            }
            if(status){
                response.sendRedirect("AuthUserPostDetail.jsp");
            }else{
                response.sendRedirect("ListOfPosts.jsp");
            }
        }
        else{
            out.println("<script>alert('Try again!')</script>");
            response.sendRedirect("AuthUserPostDetail.jsp");
        }
    }
}

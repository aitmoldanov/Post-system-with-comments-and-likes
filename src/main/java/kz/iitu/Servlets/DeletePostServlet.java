package kz.iitu.Servlets;

import kz.iitu.DAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeletePostServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String postId = request.getParameter("postId");
        if(postId != null && !(postId.equals(""))){
            boolean status = false;
            try {
                status = new DAO().deletePost(Integer.parseInt(postId));
            } catch (Exception e) {
                request.getSession().setAttribute("exception",e.getMessage());
            }
            if(status){
                request.getSession().setAttribute("message", "Selected Movie has been deleted Successfully.");
                response.sendRedirect("PostList.jsp");
            }else{
                request.getSession().setAttribute("message", "Error !!!! Selected Movie has not been deleted !!!");
            }
        }else{
            request.getSession().setAttribute("message", "Error !!!! Please select one Category!!!!!!");
            response.sendRedirect("PostList.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

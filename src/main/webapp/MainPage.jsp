<%@page import="java.util.List"%>
<%@ page import="kz.iitu.Model.Post" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Admin Login Page</title>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <!-- Google Fonts -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
    <!-- Bootstrap core CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/css/mdb.min.css" rel="stylesheet">

    <!-- JQuery -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/js/mdb.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>List Of Posts</title>
    <% List<?> posts = (List<?>) request.getSession().getAttribute("posts");%>
    <%! Post post; %>
</head>
<h2><a href="Login.jsp">Login</a></h2>
<div align="center" id="edit">
    <ul>
    <li>Post topic</li>
    <li>Post body</li>
    <li>Like</li>
    <li>Dislike</li>
    <li>Comments</li>
    </ul>
        <%
            for (Object obj : posts) {
                post = (Post) obj;
        %>
        <ul>
            <li><%=post.getTopic()%></li>
            <li><%=post.getBody()%></li>
            <li><%=post.getLike()%></li>
            <li><%=post.getDislike()%></li>
            <a href="PostDetailServlet?postId=<%=post.getId()%>">
                <button type="button" class="btn btn-primary">Comment</button>
            </a>
        </ul>
        <%
            }
        %>
</div>


<%@page import="java.util.List"%>
<%@ page import="java.io.*" %>
<%@ page import="kz.iitu.Model.User" %>
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
	<%
		List<?> posts = (List<?>) request.getSession().getAttribute("posts");
		User user = (User) request.getSession().getAttribute("logged_user");
	%>
	<%! Post post; %>
</head>
<a href="UserLogoutServlet">
	<button type="button">Logout</button>
</a>
<div align="center" id="edit">
	<h3 align="center">Posts</h3>
	<ul class="list-group">
		<li class="list-group-item">Post topic</li>
		<li class="list-group-item">Post body</li>
		<li class="list-group-item">Like</li>
		<li class="list-group-item">Dislike</li>
		<li class="list-group-item">Comments</li>
		<li class="list-group-item">Edit</li>
		<li class="list-group-item">Delete</li>
	</ul>
		<%
			for (Object object : posts) {
				post = (Post) object;
		%>
		<tr>
			<li class="list-group-item"><%=post.getTopic()%></li>
			<li class="list-group-item"><%=post.getBody()%></li>
			<li class="list-group-item"><%=post.getLike()%></li>
			<li class="list-group-item"><%=post.getDislike()%></li>
			<li class="list-group-item"><a href="AuthPostDetailServlet?postId=<%=post.getId()%>"></a></li>
				<button type="button" class="btn btn-primary">Comment</button>
			<li class="list-group-item">
				<%
					if (post.getUserId() == user.getId()){
				%>
				<a
					href="EditPostServlet?postId=<%=post.getId()%>">
				<button type="button" class="btn btn-primary">Edit</button>
			</a></li>
			<li class="list-group-item"><a
					href="DeletePostServlet?postId=<%=post.getId()%>">
				<button type="button" class="btn btn-primary">Delete</button>
			</a></li>
				<%
					}
				%>
		</tr>
		<%
			}
		%>
	</table>
</div>
<div align="center">
	<a
			href="AddPost.jsp">
		<button type="button" class="btn btn-primary">New Post</button>
	</a>
</div>


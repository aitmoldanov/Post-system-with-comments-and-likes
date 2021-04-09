package kz.iitu;

import kz.iitu.Model.Comment;
import kz.iitu.Model.Post;
import kz.iitu.Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DAO {
    private static final String url = "jdbc:postgresql://localhost:5433/javaEELabo7";
    private static final String user = "admin";
    private static final String password = "admin";
    public static boolean addNewUser(User newUser) {
    try{
        Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
        try (Connection conn = DriverManager.getConnection(url, user, password)){

            String sql = "INSERT INTO users (username, userPassword) Values (?, ?)";
            try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                preparedStatement.setString(1, newUser.getName());
                preparedStatement.setString(2, newUser.getPassword());
                preparedStatement.executeUpdate();

                return true;
            }
        }
    }
    catch(Exception ex){
        System.out.println(ex);
    }
    return false;
}
    public boolean createPost(Post post) {
        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, user, password)){

                String sql = "INSERT INTO post (theme, body, likes, dislikes, userId) Values (?, ?, ?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, post.getTopic());
                    preparedStatement.setString(2, post.getBody());
                    preparedStatement.setInt(3, post.getLike());
                    preparedStatement.setInt(4, post.getDislike());
                    preparedStatement.setInt(5, post.getUserId());
                    preparedStatement.executeUpdate();
                    return true;
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return false;
    }
    public static boolean getUserAuthenticate(String username, String userPassword) {
        ArrayList<User> users = new ArrayList<>();
        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, user, password)){

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
                while(resultSet.next()){

                    int id = resultSet.getInt(1);
                    String username1 = resultSet.getString(2);
                    String password = resultSet.getString(3);
                    String userEmail = resultSet.getString(4);
                    User user = new User();
                    users.add(user);
                    user.setId(id);
                    user.setEmail(userEmail);
                    user.setPassword(password);
                    user.setName(username1);
                }
            }
            for (User user: users){
                if (user.getEmail().equals(username)
                        && user.getPassword().equals(userPassword)){
                    return true;
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return false;
    }


    public User fetchUser(String userEmail) {
        User user1 = null;
        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, user, password)){

                String sql = "SELECT * FROM users WHERE email=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, userEmail);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
                        int userId = resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        String userPassword = resultSet.getString(3);
                        String userEmail1 = resultSet.getString(4);
                        user1 = new User();
                        user1.setId(userId);
                        user1.setEmail(userEmail1);
                        user1.setPassword(userPassword);
                        user1.setName(name);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return user1;
    }
    public Post fetchSingle(int id) {

        Post post = null;
        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, user, password)){

                String sql = "SELECT * FROM post WHERE postId=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){

                        int postId = resultSet.getInt(1);
                        String topic = resultSet.getString(2);
                        String body = resultSet.getString(3);
                        int like = resultSet.getInt(4);
                        int dislike = resultSet.getInt(5);
                        int userId = resultSet.getInt(6);
                        post = new Post();
                        post.setId(postId);
                        post.setUserId(userId);
                        post.setTopic(topic);
                        post.setBody(body);
                        post.setLike(like);
                        post.setDislike(dislike);

                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return post;
    }

    public ArrayList<Post> fetch() {

        ArrayList<Post> posts = new ArrayList<>();
        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, user, password)){

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM post");
                while(resultSet.next()){
                    int postId = resultSet.getInt(1);
                    String theme = resultSet.getString(2);
                    String body = resultSet.getString(3);
                    int like = resultSet.getInt(4);
                    int dislike = resultSet.getInt(5);
                    int userId = resultSet.getInt(6);
                    Post post = new Post();
                    post.setId(postId);
                    post.setUserId(userId);
                    post.setTopic(theme);
                    post.setBody(body);
                    post.setLike(like);
                    post.setDislike(dislike);
                    posts.add(post);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return posts;
    }
    public List<?> fetchComments(int id) {
        ArrayList<Comment> comments = new ArrayList<>();
        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, user, password)){
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM comment WHERE postId=" + id);
                while(resultSet.next()){
                    int commentId = resultSet.getInt(1);
                    String commentBody = resultSet.getString(2);
                    int postId = resultSet.getInt(3);
                    String userName = resultSet.getString(4);
                    Comment comment = new Comment();
                    comment.setId(commentId);
                    comment.setComment(commentBody);
                    comment.setPostId(postId);
                    comment.setUserName(userName);
                    comments.add(comment);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return comments;
    }
    public boolean insert(Comment newComment) {
        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, user, password)){

                String sql = "INSERT INTO comment (comment, postId, userName) Values (?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, newComment.getComment());
                    preparedStatement.setInt(2, newComment.getPostId());
                    preparedStatement.setString(3, newComment.getUserName());
                    preparedStatement.executeUpdate();

                    return true;
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return false;
    }
    public void updatePost(Post post) {
        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, user, password)){

                String sql = "UPDATE post SET likes = ?, dislikes = ? WHERE postId = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, post.getId());
                    preparedStatement.setInt(2, post.getLike());
                    preparedStatement.setInt(3, post.getDislike());
                    preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
    public boolean deletePost(int id) {

        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, user, password)){

                String sql = "DELETE FROM post WHERE postId = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    preparedStatement.executeUpdate();
                    return true;
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return false;
    }
    public boolean updateEditedPost(Post post) {
        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, user, password)){

                String sql = "UPDATE post SET topic = ?, body = ? WHERE postId = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, post.getId());
                    preparedStatement.setString(2, post.getTopic());
                    preparedStatement.setString(3, post.getBody());
                    preparedStatement.executeUpdate();
                    return true;
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return false;
    }


}

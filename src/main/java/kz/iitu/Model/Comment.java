package kz.iitu.Model;

import java.io.Serializable;

public class Comment implements Serializable {
    private int id;
    private int postId;
    private String userName;
    private String comment;
    public Comment(){ }

    public int getId() {
        return id;
    }

    public int getPostId() {
        return postId;
    }

    public String getUserName() {
        return userName;
    }

    public String getComment() {
        return comment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

package kz.iitu.Model;

import java.io.Serializable;

public class Post implements Serializable {
    private int id;
    private String topic;
    private String body;
    private int like;
    private int dislike;
    private int userId;
    public Post(){}

    public void setId(int id) {
        this.id = id;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public String getBody() {
        return body;
    }

    public int getLike() {
        return like;
    }

    public int getDislike() {
        return dislike;
    }

    public int getUserId() {
        return userId;
    }
}

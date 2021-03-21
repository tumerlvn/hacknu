package com.example.hacknu2021;

public class Post {
    private String postKey;
    private String title;
    private String description;
    private String tags;
    private String userId;
    private String userName;

    public Post(String title, String description, String tags, String userId, String userName) {
        this.title = title;
        this.description = description;
        this.tags = tags;
        this.userId = userId;
        this.userName = userName;
    }

    public Post() {

    }

    public String getPostKey() {
        return postKey;
    }

    public void setPostKey(String postKey) {
        this.postKey = postKey;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTags() {
        return tags;
    }

    public String getUserId() {
        return userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) { this.userName = userName; }

    public String getUserName() { return userName; }

}

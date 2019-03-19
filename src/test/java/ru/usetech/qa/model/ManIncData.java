package ru.usetech.qa.model;

public class ManIncData {

    private String postUrlField;
    private String postText;
    private String postBlog;


    public String getPostUrlField() {
        return postUrlField;
    }

    public String getPostText() { return postText; }

    public String getPostBlog() { return postBlog; }


    public ManIncData postUrlField(String postUrl) {
        this.postUrlField = postUrl;
        return this;
    }

    public ManIncData postText(String postText) {
        this.postText = postText;
        return this;
    }

    public ManIncData postBlog(String postBlog) {
        this.postBlog = postBlog;
        return this;
    }


}

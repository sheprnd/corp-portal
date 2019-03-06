package ru.usetech.qa.model;

public class ManIncData {

    private String blog;
    private String text;
    private String url;

    public String gettText() {
        return text;
    }
    public String getBlogField() { return blog; }
    public String getUrlField() { return url; }


    public ManIncData blog(String blog) {
        this.blog = blog;
        return this;
    }
    public ManIncData text(String text) {
        this.text = text;
        return this;
    }
    public ManIncData url(String url) {
        this.url = url;
        return this;
    }


}

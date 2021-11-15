package fr.hookwood.httponline.model;

public class WebsiteModel {

    private String url;
    private String name;
    private int statusCode;

    public String getUrl() {
        return url;
    }

    public WebsiteModel setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getName() {
        return name;
    }

    public WebsiteModel setName(String name) {
        this.name = name;
        return this;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public WebsiteModel setStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }
}

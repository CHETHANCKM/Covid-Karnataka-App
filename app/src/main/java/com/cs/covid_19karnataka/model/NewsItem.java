package com.cs.covid_19karnataka.model;

public class NewsItem {
    private  String title, description, url, image, publishedAt ,name;

    public NewsItem(String title, String description, String url, String image, String publishedAt, String name) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.image = image;
        this.publishedAt = publishedAt;
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

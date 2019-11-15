package com.umniah.app1;

public class Movie {

    Integer imageId;
    String title;

    public Movie( String title,Integer imageId) {
        this.imageId = imageId;
        this.title = title;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }


}

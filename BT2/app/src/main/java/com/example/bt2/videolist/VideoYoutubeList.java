package com.example.bt2.videolist;

public class VideoYoutubeList {
    private String title;
    private String thumbnails;
    private String videoId;

    public VideoYoutubeList(String title, String thumbnails, String videoId) {
        this.title = title;
        this.thumbnails = thumbnails;
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(String thumbnails) {
        this.thumbnails = thumbnails;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }
}

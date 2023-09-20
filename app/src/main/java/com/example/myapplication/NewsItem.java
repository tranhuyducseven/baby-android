package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsItem {

    class Fuser {
        @SerializedName("user_id")
        private String user_id;

        @SerializedName("avatar")
        private String avatar;

        @SerializedName("email")
        private String email;

        @SerializedName("username")
        private String username;

        public String getUserId() {
            return user_id;
        }

        public String getAvatar() {
            return avatar;
        }

        public String getEmail() {
            return email;
        }

        public String getUsername() {
            return username;
        }
    }

    class ImageMap {
        @SerializedName("image_url")
        private String image_url;

        @SerializedName("image_path")
        private String image_path;

        @SerializedName("image_url_full")
        private String image_url_full;

        public String getImageUrl(){
            return image_url;
        }

        public String getImagePath(){
            return image_path;
        }

        public String getImageUrlFull(){
            return image_url_full;
        }

    }
    @SerializedName("date")
    private String date;

    @SerializedName("corp")
    private boolean corp;

    @SerializedName("fuser")
    private Fuser fuser;

    @SerializedName("created")
    private String created;

    @SerializedName("approved_visible")
    private boolean approved_visible;

    @SerializedName("cpostID")
    private String cpostID;

    @SerializedName("description")
    private String description;

    @SerializedName("title")
    private String title;

    @SerializedName("uuid")
    private String uuid;

    @SerializedName("url")
    private String url;

    @SerializedName("content")
    private String content;

    @SerializedName("approved")
    private boolean approved;

    @SerializedName("image_map")
    private List<ImageMap> image_map;

    @SerializedName("domain")
    private String domain;

    @SerializedName("image_host")
    private String image_host;

    @SerializedName("categories")
    private List<String> categories;

    @SerializedName("updated")
    private String updated;

    @SerializedName("discourse_id")
    private int discourse_id;

    @SerializedName("postID")
    private String postID;

    public String getDate() {
        return date;
    }

    public boolean isCorp() {
        return corp;
    }

    public Fuser getFuser() {
        return fuser;
    }

    public String getCreated() {
        return created;
    }

    public boolean isApproved_visible() {
        return approved_visible;
    }

    public String getCpostID() {
        return cpostID;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getUuid() {
        return uuid;
    }

    public String getUrl() {
        return url;
    }

    public String getContent() {
        return content;
    }

    public boolean isApproved() {
        return approved;
    }

    public List<ImageMap> getImageMap() {
        return image_map;
    }

    public String getDomain() {
        return domain;
    }

    public String getImage_host() {
        return image_host;
    }

    public List<String> getCategories() {
        return categories;
    }

    public String getUpdated() {
        return updated;
    }

    public int getDiscourse_id() {
        return discourse_id;
    }

    public String getPostID() {
        return postID;
    }

}
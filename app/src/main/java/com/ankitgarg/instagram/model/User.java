package com.ankitgarg.instagram.model;

public class User {

    private String username;
    private String profile_picture;
    private String id;
    private String full_name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFull_name() {
        if(full_name.equals("") || full_name == null){
            return username;
        }else{
            return full_name;
        }
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getUsername() {
        return username;
    }

    public String getProfilePicture() {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

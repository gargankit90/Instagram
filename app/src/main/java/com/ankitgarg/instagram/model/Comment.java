package com.ankitgarg.instagram.model;

public class Comment {
    private String text;
    private User from;

    public void setText(String text) {
        this.text = text;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public String getText() {
        return text;
    }

    public User getFrom() {
        return from;
    }

}

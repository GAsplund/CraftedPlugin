package com.crafted.customname.models;

public class UserPrefix {

    private String title;
    private String color;

    public UserPrefix(String title, String color) {
        this.title = title;
        this.color = color;
    }

    public UserPrefix() {
        this("", "&r");
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return title + (title.isEmpty() ? "" : " ") + color;
    }
}

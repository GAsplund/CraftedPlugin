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

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return title + (title.isEmpty() ? "" : " ") + color;
    }

    public String serialize() {
        return title + "\n" + color;
    }

    public static UserPrefix deserialize(String serialized) {
        String[] split = serialized.split("\n");
        return new UserPrefix(split[0], split[1]);
    }
}

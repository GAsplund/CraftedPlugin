package com.crafted.customname.models;

public record UserPrefix(String title, String color) {
    public UserPrefix() {
        this("", "&r");
    }

    @Override
    public String toString() {
        return title + (title.isEmpty() ? "" : " ") + color;
    }
}

package com.sim.observerpattern.subject.impl;

import com.sim.observerpattern.subject.Status;

public class PostStatus implements Status {
    private final String title;
    private final String content;

    public PostStatus(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "PostStatus{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

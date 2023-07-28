package com.sim.observerpattern.observer.impl;

import com.sim.observerpattern.observer.Observer;
import com.sim.observerpattern.subject.impl.PostStatus;

public class PostObserver implements Observer<PostStatus> {

    @Override
    public void attemptUpdate(PostStatus status) {
        System.out.println("PostObserver: " + status);
    }
}

package com.sim.observerpattern.observer.impl;


import com.sim.observerpattern.observer.Observer;
import com.sim.observerpattern.subject.impl.UserStatus;

public class UserObserver implements Observer<UserStatus> {

    @Override
    public void attemptUpdate(UserStatus status) {
        System.out.println("UserObserver: " + status);
    }
}

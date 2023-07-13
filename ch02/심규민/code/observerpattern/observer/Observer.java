package com.sim.observerpattern.observer;

import com.sim.observerpattern.subject.Status;

import java.util.Objects;

public interface Observer<s extends Status> {
    default void update(s status){
        System.out.println("Observer: " + this.getClass());
        if(status instanceof  s){
            updateStatus(status);
        }
    }

    void updateStatus(s status);
}

package com.sim.observerpattern.observer;

import com.sim.observerpattern.subject.Status;

import java.lang.reflect.ParameterizedType;
import java.util.Objects;

public interface Observer<S extends Status> {

    default void update(Object status){
        try {
            attemptUpdate((S) status);
        }catch (ClassCastException ignore){}
    }

    void attemptUpdate(S status);

}

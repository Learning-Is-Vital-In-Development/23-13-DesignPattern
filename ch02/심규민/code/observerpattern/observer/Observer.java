package com.sim.observerpattern.observer;

import com.sim.observerpattern.subject.Status;

import java.util.Objects;

public interface Observer<S extends Status> {
    void update(S status);

}

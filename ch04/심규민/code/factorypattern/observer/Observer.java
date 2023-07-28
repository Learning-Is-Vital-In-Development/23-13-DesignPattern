package com.sim.factorypattern.observer;

import com.sim.factorypattern.subject.Status;

public interface Observer<T extends Status, R> {
    R accept(T status);
}

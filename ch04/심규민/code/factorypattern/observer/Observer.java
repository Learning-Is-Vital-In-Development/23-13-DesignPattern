package com.sim.factorypattern.observer;

import com.sim.factorypattern.subject.Status;

public interface Observer<S extends Status> {
    Object accept(S status);
}

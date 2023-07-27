package com.sim.factorypattern.subject;

import com.sim.factorypattern.observer.Observer;

public interface Subject {
    void registerObserver(Observer<? extends Status> o);
    void removeObserver(Observer<? extends Status> o);
    Object notifyObservers(Object object);
}
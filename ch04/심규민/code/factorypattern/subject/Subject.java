package com.sim.factorypattern.subject;

import com.sim.factorypattern.observer.Observer;

public interface Subject<T,R> {
    void registerObserver(Observer<? extends Status, R> o);
    void removeObserver(Observer<? extends Status, R> o);
    R notifyObservers(T object);
}
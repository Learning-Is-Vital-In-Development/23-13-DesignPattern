package com.sim.observerpattern.subject;


import com.sim.observerpattern.observer.Observer;

public interface Subject {
    public void registerObserver(Observer<? extends Status> o);

    public void removeObserver(Observer<? extends Status> o);
    public void notifyObservers();
}

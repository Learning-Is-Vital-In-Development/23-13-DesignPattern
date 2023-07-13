package com.sim.observerpattern.subject;


import com.sim.observerpattern.observer.Observer;

public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}

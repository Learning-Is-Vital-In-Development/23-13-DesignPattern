package com.sim.observerpattern.subject.impl;

import com.sim.observerpattern.observer.Observer;
import com.sim.observerpattern.subject.Status;
import com.sim.observerpattern.subject.Subject;

import java.util.ArrayList;
import java.util.List;

public class AbstractSubject implements Subject {
    private Status status;
    private Class<Status> clazz;
    private final List<Observer<? extends Status>> observerList = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        System.out.println("registerObserver: " + o);
        observerList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        System.out.println("removeObserver: " + o);
        observerList.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerList) {
            System.out.println("notifyObservers: " + observer);
            try {
                observer.update(status);
            }catch (ClassCastException ignore){}
        }
    }

    public void setStatus(Status status) {
        this.status = status;
        notifyObservers();
    }
}

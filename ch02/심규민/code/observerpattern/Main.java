package com.sim.observerpattern;

import com.sim.observerpattern.observer.Observer;
import com.sim.observerpattern.observer.impl.UserObserver;
import com.sim.observerpattern.subject.impl.AbstractSubject;
import com.sim.observerpattern.subject.impl.UserStatus;

public class Main {
    public static void main(String[] args) {
        AbstractSubject subject = new AbstractSubject();

        Observer observer1 = new UserObserver();
        Observer observer2 = new UserObserver();

        subject.registerObserver(observer1);
        subject.registerObserver(observer2);

        subject.setStatus(new UserStatus("user", "password"));

        subject.removeObserver(observer1);

        subject.setStatus(new UserStatus("user", "password"));
    }
}

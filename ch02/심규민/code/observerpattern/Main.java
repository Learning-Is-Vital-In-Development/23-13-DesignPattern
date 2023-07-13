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

        /**
         * registerObserver: com.sim.observerpattern.observer.impl.UserObserver@4517d9a3
         * registerObserver: com.sim.observerpattern.observer.impl.UserObserver@372f7a8d
         *
         * notifyObservers: com.sim.observerpattern.observer.impl.UserObserver@4517d9a3
         * Observer: class com.sim.observerpattern.observer.impl.UserObserver
         * UserObserver: UserStatus{name='user', password='password'}
         *
         * notifyObservers: com.sim.observerpattern.observer.impl.UserObserver@372f7a8d
         * Observer: class com.sim.observerpattern.observer.impl.UserObserver
         * UserObserver: UserStatus{name='user', password='password'}
         *
         * removeObserver: com.sim.observerpattern.observer.impl.UserObserver@4517d9a3
         *
         * notifyObservers: com.sim.observerpattern.observer.impl.UserObserver@372f7a8d
         * Observer: class com.sim.observerpattern.observer.impl.UserObserver
         * UserObserver: UserStatus{name='user', password='password'}
         */
    }
}

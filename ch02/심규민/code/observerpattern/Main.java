package com.sim.observerpattern;

import com.sim.observerpattern.observer.Observer;
import com.sim.observerpattern.observer.impl.PostObserver;
import com.sim.observerpattern.observer.impl.UserObserver;
import com.sim.observerpattern.subject.impl.AbstractSubject;
import com.sim.observerpattern.subject.impl.PostStatus;
import com.sim.observerpattern.subject.impl.UserStatus;

public class Main {
    public static void main(String[] args) {
        AbstractSubject subject = new AbstractSubject();

        Observer userObserver1 = new UserObserver();
        Observer userObserver2 = new UserObserver();

        subject.registerObserver(userObserver1);
        subject.registerObserver(userObserver2);

        subject.setStatus(new UserStatus("user", "password"));

        subject.removeObserver(userObserver1);

        Observer postObserver = new PostObserver();

        subject.registerObserver(postObserver);

        subject.setStatus(new UserStatus("user", "password"));

        subject.setStatus(new PostStatus("title", "content"));


        /**
         * registerObserver: com.sim.observerpattern.observer.impl.UserObserver@4517d9a3
         * registerObserver: com.sim.observerpattern.observer.impl.UserObserver@372f7a8d
         *
         * notifyObservers: com.sim.observerpattern.observer.impl.UserObserver@4517d9a3
         * UserObserver: UserStatus{name='user', password='password'}
         *
         * notifyObservers: com.sim.observerpattern.observer.impl.UserObserver@372f7a8d
         * UserObserver: UserStatus{name='user', password='password'}
         *
         * removeObserver: com.sim.observerpattern.observer.impl.UserObserver@4517d9a3
         *
         * registerObserver: com.sim.observerpattern.observer.impl.PostObserver@452b3a41
         *
         * notifyObservers: com.sim.observerpattern.observer.impl.UserObserver@372f7a8d
         * UserObserver: UserStatus{name='user', password='password'}
         *
         * notifyObservers: com.sim.observerpattern.observer.impl.PostObserver@452b3a41
         *
         * notifyObservers: com.sim.observerpattern.observer.impl.UserObserver@372f7a8d
         *
         * notifyObservers: com.sim.observerpattern.observer.impl.PostObserver@452b3a41
         * PostObserver: PostStatus{title='title', content='content'}
         */
    }
}

package com.sim.observerpattern.subject.impl;

import com.sim.observerpattern.subject.Status;

public class UserStatus implements Status {
    private final String name;
    private final String password;

    public UserStatus(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserStatus{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

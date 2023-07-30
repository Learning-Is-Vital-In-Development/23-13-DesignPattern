package com.jungmini.factory.domain.pizza.model;

public interface Pizza {

    void prepare();

    void bake();

    void cut();

    void box();

    String getName();
}

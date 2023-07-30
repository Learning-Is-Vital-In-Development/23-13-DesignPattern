package com.jungmini.factory.domain.pizza.model;

import com.jungmini.factory.domain.pizza.model.Pizza;

public interface PizzaStore {

    boolean supports(String pizzaType, String storeName);

    Pizza orderPizza(String pizzaType);
}

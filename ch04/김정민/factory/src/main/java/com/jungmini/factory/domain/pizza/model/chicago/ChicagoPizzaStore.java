package com.jungmini.factory.domain.pizza.model.chicago;

import com.jungmini.factory.domain.pizza.model.Pizza;
import com.jungmini.factory.domain.pizza.model.PizzaStore;
import com.jungmini.factory.domain.pizza.model.chicago.ChicagoPizza;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;

@Component
public class ChicagoPizzaStore implements PizzaStore {

    private final String STORE_NAME = "ChicagoPizzaStore";
    private final Set<ChicagoPizza> pizzas;

    public ChicagoPizzaStore(final Set<ChicagoPizza> pizzas) {
        this.pizzas = pizzas;
    }

    @Override
    public boolean supports(final String pizzaName, final String storeName) {
        if (!Objects.equals(storeName, STORE_NAME)) return false;
        return pizzas.stream()
                .anyMatch(pizza -> Objects.equals(pizza.getName(), pizzaName));
    }

    @Override
    public Pizza orderPizza(final String pizzaType) {
        return pizzas.stream()
                .filter(pizza -> Objects.equals(pizza.getName(), pizzaType))
                .findAny()
                .orElseThrow(() -> new RuntimeException("ChicagoPizza에 존재하지 않는 피자 입니다."));
    }
}

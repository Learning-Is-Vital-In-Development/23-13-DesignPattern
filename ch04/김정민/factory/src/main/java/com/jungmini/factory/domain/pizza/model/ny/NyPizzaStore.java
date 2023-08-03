package com.jungmini.factory.domain.pizza.model.ny;

import com.jungmini.factory.domain.pizza.model.Pizza;
import com.jungmini.factory.domain.pizza.model.PizzaStore;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;

@Component
public class NyPizzaStore implements PizzaStore {

    private final String STORE_NAME = "NyPizzaStore";
    private final Set<NyPizza> pizzas;

    public NyPizzaStore(final Set<NyPizza> pizzas) {
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
                .orElseThrow(() -> new RuntimeException("NyPizza에 존재하지 않는 피자 입니다."));
    }
}

package com.jungmini.factory.domain.pizza.service;

import com.jungmini.factory.domain.pizza.model.Pizza;
import com.jungmini.factory.domain.pizza.model.PizzaStore;
import com.jungmini.factory.domain.pizza.usecase.OrderPizzaUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderPizza implements OrderPizzaUseCase {

    private final List<PizzaStore> pizzaStores;

    public OrderPizza(final List<PizzaStore> pizzaStores) {
        this.pizzaStores = pizzaStores;
    }

    @Override
    public Pizza command(final Command command) {
        final String pizzaType = command.pizzaType();
        final String pizzaStore = command.pizzaStore();
        final PizzaStore supportedPizzaStore = pizzaStores.stream()
                .filter(ps -> ps.supports(pizzaType, pizzaStore))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("지원하지 않는 피자 타입, 가게 조합입니다."));

        return supportedPizzaStore.orderPizza(pizzaType);
    }

}

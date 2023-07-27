package com.jungmini.factory.domain.pizza.usecase;

import com.jungmini.factory.domain.pizza.model.Pizza;

public interface OrderPizzaUseCase {

    Pizza command(Command command);

    record Command(
            String pizzaType,
            String pizzaStore
    ) {
    }
}

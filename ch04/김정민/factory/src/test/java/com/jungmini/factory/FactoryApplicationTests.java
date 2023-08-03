package com.jungmini.factory;

import com.jungmini.factory.domain.pizza.model.Pizza;
import com.jungmini.factory.domain.pizza.usecase.OrderPizzaUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FactoryApplicationTests {

    @Autowired
    private OrderPizzaUseCase orderPizzaUseCase;

    @Test
    void NyPizza에서_치즈_피자를_주문한다() {
        String pizzaStoreName = "NyPizzaStore";
        String pizzaType = "NyCheesePizza";

        Pizza pizza = orderPizzaUseCase.command(new OrderPizzaUseCase.Command(pizzaType, pizzaStoreName));
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
    }

    @Test
    void NyPizza에서_페퍼로니_피자를_주문한다() {
        String pizzaStoreName = "NyPizzaStore";
        String pizzaType = "NyPepperoniPizza";

        Pizza pizza = orderPizzaUseCase.command(new OrderPizzaUseCase.Command(pizzaType, pizzaStoreName));
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
    }

    @Test
    void NyPizza에서_Clam_피자를_주문한다() {
        String pizzaStoreName = "NyPizzaStore";
        String pizzaType = "NyClamPizza";

        Pizza pizza = orderPizzaUseCase.command(new OrderPizzaUseCase.Command(pizzaType, pizzaStoreName));
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
    }

    @Test
    void ChicagoPizza에서_치즈_피자를_주문한다() {
        String pizzaStoreName = "ChicagoPizzaStore";
        String pizzaType = "ChicagoCheesePizza";

        Pizza pizza = orderPizzaUseCase.command(new OrderPizzaUseCase.Command(pizzaType, pizzaStoreName));
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
    }

    @Test
    void ChicagoPizza에서_페퍼로니_피자를_주문한다() {
        String pizzaStoreName = "ChicagoPizzaStore";
        String pizzaType = "ChicagoPepperoniPizza";

        Pizza pizza = orderPizzaUseCase.command(new OrderPizzaUseCase.Command(pizzaType, pizzaStoreName));
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
    }

    @Test
    void ChicagoPizza에서_Clam_피자를_주문한다() {
        String pizzaStoreName = "ChicagoPizzaStore";
        String pizzaType = "ChicagoClamPizza";

        Pizza pizza = orderPizzaUseCase.command(new OrderPizzaUseCase.Command(pizzaType, pizzaStoreName));
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
    }

}

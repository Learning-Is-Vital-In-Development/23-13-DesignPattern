package com.jungmini.factory.domain.pizza.model.ny;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class NyPepperoniPizza implements NyPizza {

    private final String name;
    private final Set<String> toppings;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public NyPepperoniPizza() {
        this.name = "NyPepperoniPizza";
        this.toppings = Set.of("페퍼로니", "맥주");
    }

    @Override
    public void prepare() {
        logger.info("NyPepperoniPizza 준비중");
        logger.info("NyPepperoniPizza Toppings: {}", toppings);
    }

    @Override
    public void bake() {
        logger.info("NyPepperoniPizza 굽는중");
    }

    @Override
    public void cut() {
        logger.info("NyPepperoniPizza 자르는중");
    }

    @Override
    public void box() {
        logger.info("NyPepperoniPizza 담는중");
    }

    @Override
    public String getName() {
        return name;
    }
}

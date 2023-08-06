package com.jungmini.factory.domain.pizza.model.chicago;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ChicagoPepperoniPizza implements ChicagoPizza {

    private final String name;
    private final Set<String> toppings;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public ChicagoPepperoniPizza() {
        this.name = "ChicagoPepperoniPizza";
        this.toppings = Set.of("Clam", "막걸리");
    }

    @Override
    public void prepare() {
        logger.info("ChicagoPepperoniPizza 준비중");
        logger.info("ChicagoPepperoniPizza Toppings: {}", toppings);
    }

    @Override
    public void bake() {
        logger.info("ChicagoPepperoniPizza 굽는중");
    }

    @Override
    public void cut() {
        logger.info("ChicagoPepperoniPizza 자르는중");
    }

    @Override
    public void box() {
        logger.info("ChicagoPepperoniPizza 담는중");
    }

    @Override
    public String getName() {
        return name;
    }
}

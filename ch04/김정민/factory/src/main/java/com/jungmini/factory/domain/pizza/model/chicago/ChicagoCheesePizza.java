package com.jungmini.factory.domain.pizza.model.chicago;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ChicagoCheesePizza implements ChicagoPizza {

    private final String name;
    private final Set<String> toppings;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public ChicagoCheesePizza() {
        this.name = "ChicagoCheesePizza";
        this.toppings = Set.of("치즈", "막걸리");
    }

    @Override
    public void prepare() {
        logger.info("ChicagoCheesePizza 준비중");
        logger.info("ChicagoCheesePizza Toppings: {}", toppings);
    }

    @Override
    public void bake() {
        logger.info("ChicagoCheesePizza 굽는중");
    }

    @Override
    public void cut() {
        logger.info("ChicagoCheesePizza 자르는중");
    }

    @Override
    public void box() {
        logger.info("ChicagoCheesePizza 담는중");
    }

    @Override
    public String getName() {
        return name;
    }
}

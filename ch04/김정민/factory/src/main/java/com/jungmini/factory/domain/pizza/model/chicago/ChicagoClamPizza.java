package com.jungmini.factory.domain.pizza.model.chicago;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ChicagoClamPizza implements ChicagoPizza {

    private final String name;
    private final Set<String> toppings;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public ChicagoClamPizza() {
        this.name = "ChicagoClamPizza";
        this.toppings = Set.of("Clam", "막걸리");
    }

    @Override
    public void prepare() {
        logger.info("ChicagoClamPizza 준비중");
        logger.info("ChicagoClamPizza Toppings: {}", toppings);
    }

    @Override
    public void bake() {
        logger.info("ChicagoClamPizza 굽는중");
    }

    @Override
    public void cut() {
        logger.info("ChicagoClamPizza 자르는중");
    }

    @Override
    public void box() {
        logger.info("ChicagoClamPizza 담는중");
    }

    @Override
    public String getName() {
        return name;
    }
}

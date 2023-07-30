package com.jungmini.factory.domain.pizza.model.ny;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class NyClamPizza implements NyPizza {

    private final String name;
    private final Set<String> toppings;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public NyClamPizza() {
        this.name = "NyClamPizza";
        this.toppings = Set.of("Clam", "소주");
    }

    @Override
    public void prepare() {
        logger.info("NyClamPizza 준비중");
        logger.info("NyClamPizza Toppings: {}", toppings);
    }

    @Override
    public void bake() {
        logger.info("NyClamPizza 굽는중");
    }

    @Override
    public void cut() {
        logger.info("NyClamPizza 자르는중");
    }

    @Override
    public void box() {
        logger.info("NyClamPizza 담는중");
    }

    @Override
    public String getName() {
        return name;
    }
}

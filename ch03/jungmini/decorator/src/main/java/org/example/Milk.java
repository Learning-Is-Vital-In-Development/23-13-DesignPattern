package org.example;

public class Milk extends CondimentDecorator{

    private static final int MOCHA_FEE = 3000;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public int cost() {
        return this.beverage.cost() + MOCHA_FEE;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }
}

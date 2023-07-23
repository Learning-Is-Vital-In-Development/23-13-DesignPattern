package org.example;

public class HouseBlend extends Beverage{
    private static final int FEE = 2000;

    public HouseBlend() {
        this.description = "HouseBlend";
    }

    @Override
    public int cost() {
        return FEE;
    }
}

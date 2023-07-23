package org.example;

public class Espresso extends Beverage{
    private static final int FEE = 2000;

    public Espresso() {
        this.description = "Espresso";
    }

    @Override
    public int cost() {
        return FEE;
    }
}

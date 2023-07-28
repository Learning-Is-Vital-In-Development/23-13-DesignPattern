package org.example;

public class DarkRoast extends Beverage{

    private static final int FEE = 1000;

    public DarkRoast() {
        this.description = "DarkRoast";
    }

    @Override
    public int cost() {
        return FEE;
    }
}

package org.example;

public class Decaf extends Beverage{
    private static final int FEE = 2000;

    public Decaf() {
        this.description = "Decaf";
    }

    @Override
    public int cost() {
        return FEE;
    }
}

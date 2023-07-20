package livid_design_pattern.decorator;

public class Espresso extends Beverage{

    public Espresso() {
        description = "espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}

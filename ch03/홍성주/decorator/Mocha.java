package livid_design_pattern.decorator;

public class Mocha extends CondimentDecorator{
    public Mocha(Beverage beverage, int count) {
        this.beverage = beverage;
        this.count = count;
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.20 * count;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " , "+count+" mocha";
    }
}

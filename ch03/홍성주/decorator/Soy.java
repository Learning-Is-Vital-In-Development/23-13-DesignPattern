package livid_design_pattern.decorator;

public class Soy extends CondimentDecorator{

    public Soy(Beverage beverage, int count) {
        this.beverage = beverage;
        this.count = count;
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.5 * count;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " , 두유";
    }
}

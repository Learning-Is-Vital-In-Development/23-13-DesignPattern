package livid_design_pattern.decorator;

public class Shot extends CondimentDecorator{

    public Shot(Beverage beverage, int count) {
        this.beverage = beverage;
        this.count = count;
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.3 * count;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", add "+ count +" shot";
    }
}

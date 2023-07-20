package livid_design_pattern.decorator;

public class HouseBlend extends Beverage{
    public HouseBlend() {
        description = "houseBlend";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}

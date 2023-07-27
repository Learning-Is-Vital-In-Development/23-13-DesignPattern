package livid_design_pattern.decorator;

public abstract class CondimentDecorator extends Beverage{
    Beverage beverage;
    int count;

    public abstract String getDescription();
}

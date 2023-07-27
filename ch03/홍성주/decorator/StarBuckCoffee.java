package livid_design_pattern.decorator;

public class StarBuckCoffee {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + ", $"+beverage.cost());

        Beverage beverage1 = new HouseBlend();
        beverage1 = new Mocha(beverage1, 1);
        beverage1 = new Shot(beverage1, 2);

        System.out.println(beverage1.getDescription() + ", $" + beverage1.cost());
    }
}

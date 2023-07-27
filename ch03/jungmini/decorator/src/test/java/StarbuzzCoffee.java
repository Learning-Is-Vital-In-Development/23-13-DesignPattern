import org.example.Beverage;
import org.example.Espresso;
import org.example.Mocha;
import org.example.Soy;
import org.junit.jupiter.api.Test;

public class StarbuzzCoffee {

    @Test
    void espresso() {
        Beverage beverage = new Espresso();
        System.out.printf("%s $%d%n",beverage.getDescription(), beverage.cost());
    }

    @Test
    void espresso_with_mocha() {
        Beverage beverage = new Mocha(new Espresso());
        System.out.printf("%s $%d%n",beverage.getDescription(), beverage.cost());
    }

    @Test
    void espresso_with_mocha_and_soy() {
        Beverage beverage = new Soy(new Mocha(new Espresso()));
        System.out.printf("%s $%d%n",beverage.getDescription(), beverage.cost());
    }
}

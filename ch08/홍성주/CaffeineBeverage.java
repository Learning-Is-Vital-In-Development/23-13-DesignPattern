package livid_design_pattern.templateMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class CaffeineBeverage {
    String additive;
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if(customerWantCondiments()) {
            addCondiments();
        }
    }

    abstract void brew();
    abstract void addCondiments();

    void boilWater() {
        System.out.println("boil water");
    }
    void pourInCup() {
        System.out.println("pour in cup");
    }
    /* hook method */
    boolean customerWantCondiments() {
        return true;
    }
    String getUserInput() {
        String answer = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("add " + additive+"? : ");
            answer = br.readLine();
        } catch (IOException e) {
            System.out.println("error");
        }

        if(answer.equals("y")) return "y";
        else return "n";
    }
}

class Coffee extends CaffeineBeverage {
    public Coffee() {
        super.additive = "sugar";
    }

    @Override
    void brew() {
        System.out.println("필터로 커피 우려내는 중...");
    }

    @Override
    void addCondiments() {
        System.out.println("설탕과 커피를 추가하는 중...");
    }

    @Override
    boolean customerWantCondiments() { //hook method 활용
        String ans = getUserInput();

        if(ans.equals("y")) return true;
        else return false;
    }
}

class Tea extends CaffeineBeverage {
    public Tea() {
        super.additive = "lemon";
    }

    @Override
    void brew() {
        System.out.println("차를 우려내는 중...");
    }

    @Override
    void addCondiments() {
        System.out.println("레몬을 추가하는 중...");
    }

}

class CaffeineTest {
    public static void main(String[] args) {
        Tea tea = new Tea();
        Coffee coffee = new Coffee();

        tea.prepareRecipe();
        System.out.println("==========");
        coffee.prepareRecipe();
    }
}


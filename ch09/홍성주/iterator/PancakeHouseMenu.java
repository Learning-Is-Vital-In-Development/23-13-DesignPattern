package livid_design_pattern.iterator;

import java.util.ArrayList;
import java.util.List;

public class PancakeHouseMenu {
    List<MenuItem> menuItems;

    public PancakeHouseMenu() {
        this.menuItems = new ArrayList<>();

        addItem("팬케이크 세트", "맛있겠다",true,2.99);
        addItem("블루베리 팬케이크 세트", "더 맛있겠다",true,3.99);
        addItem("딸기 팬케이크 세트", "완전 맛있겠다",true,4.99);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
}

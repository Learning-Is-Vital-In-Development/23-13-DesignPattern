package livid_design_pattern.iterator;

public class DinerMenu {
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;

    public DinerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];

        addItem("채식주의자용 BLT", "맛있겠다", true, 2.99);
        addItem("오늘의 스프", "양송이가 들어있다", false, 2.99);
        addItem("핫도그", "케찹이 뿌려져있다.", false, 1.99);
        addItem("BLT", "맛있겠다", false, 2.99);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        if(numberOfItems >= MAX_ITEMS) {
            System.out.println("메뉴가 꽉 찼습니다.");
        }
        else {
            menuItems[numberOfItems] = menuItem;
            numberOfItems += 1;
        }
    }

    public Iterator createIterator() {
        return new DinerMenuIterator(menuItems);
    }
}

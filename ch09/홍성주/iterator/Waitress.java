package livid_design_pattern.iterator;

public class Waitress {
    PancakeHouseMenu pancakeHouseMenu;
    DinerMenu dinerMenu;

    public Waitress(PancakeHouseMenu pancakeHouseMenu, DinerMenu dinerMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
    }

    public void printMenu() {
        Iterator dinerIterator = dinerMenu.createIterator();

        System.out.println(dinerIterator);
        printMenu(dinerIterator);
    }

    private void printMenu(Iterator iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = iterator.next();
            System.out.println(menuItem.getName() + " ");
            System.out.println(menuItem.getPrice() + ", ");
            System.out.println(menuItem.getDescription());
        }
    }

    public static void main(String[] args) {
        DinerMenu dinerMenu1 = new DinerMenu();

        Waitress waitress = new Waitress(null, dinerMenu1);
        waitress.printMenu();
    }
}

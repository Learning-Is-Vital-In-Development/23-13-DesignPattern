# 반복자 패턴과 컴포지트 패턴
> 반복자 패턴과 컴포지트 패턴은 컬렉션을 캡슐화하여 객체 저장방식을 공개하지 않고, 클라이언트에게 공통된 방법으로 원소에 접근하게 해주는 패턴이다.

## 1. 반복자 패턴 예제로 살펴보기
팬케이크 하우스와 객체마을 식당의 메뉴를 하나의 가게에서 맛볼 수 있게 되었다.  
그런데, 객체지향 마을은 메뉴를 배열로 저장하고 팬케이크 하우스는 메뉴를 ArrayList 컬렉션으로 저장하였다.   
두 식당은 이미 오래전부터 음식을 판매했기 때문에 기존 자료구조를 변경하기 난감할 것이다. 이 문제를 어떻게 해결할 수 있는지 알아보자

### 1.1 메뉴 살펴보기

```java
class MenuItem {
    String name;
    String description;
    String vegetarian;
    double price;

    public MenuItem(String name,
                    String description,
                    boolean vegetarian,
                    double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }
    
    public String getName() {
        this.name;
    }

    public String getDescription() {
        this.description;
    }

    public boolean getVegetarian() {
        return this.vegetarian;
    }

    public double getPrice() {
        return this.price; 
    }
}

```

### 1.2 팬케이크와 객체지향 마을 하우스의 메뉴 구현방법

**[팬케이크 하우스]**
```java
class PancakeHouseMenu {
    List<MenuItem> menuItems;

    public PancakeHouseMenu() {
        addItem(
                "K&B 팬케이크 세트",
                "스크램블 에그와 토스트가 곁들여진 케이크",
                true,
                2, 99
        );
    }

    public void addItem(String name, String description,
                        boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }
    
    public List<MenuItem> getMenuItems() {
        return this.menuItems;
    }
}
```

**[객체지향 마을]**

```java

class DinerMenu {
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;

    public DinerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];

        addItem(
                "채식주의자용 세트",
                "통밀 등등 맛 없는 거",
                true,
                2, 99
        );
    }


    public void addItem(String name, String description,
                        boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        if (numberOfItems >= MAX_ITEMS) {
            System.out.println("메뉴가 꽉 찼습니다");
        } else {
            menuItems[numberOfItems] = menuItem;
            this.numberOfItems = numberOfItems + 1;
        }
        menuItems.add(menuItem);
    }

    public MenuItem[] getMenuItems() {
        return this.menuItems;
    }
}
```

### 1.3 문제점
팬케이크 마을과 객체지향 마을의 메뉴는 서로 다른 타입으로 관리되고 있다.  
서로 다른 클라이언트를 보유하고 있으면 괜찮지만, 동일한 클라이언트에서 팬케이크와 객체지향 마을의 메뉴를 사용하면  
클라이언트는 타입이 다른다는 이유로 비슷한 중복코드를 생산하게 된다. 클라이언트가 한번에 두 메뉴에 접근할 수 있도록 변경해보자

### 1.4 반복을 캡슐화 하기 (반복자 패턴)

```java
// 반복자 인터페이스 추가
public interface Iterator {
    boolean hasNext();

    MenuItem next();
}

// 객체지향 식당 메뉴에 반복자 추가하기
public class DinerMenuIterator implements Iterator {
    MenuItem[] items;
    int position = 0;
    
    public DinerMenuIterator(MenuItem[] menuItems) {
        this.items = menuItems;
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = items[position];
        position = position + 1;
        return menuItem;
    }

    @Override
    public boolean hasNext() {
        if (position >= items.length || items[position] == null) {
            return false;
        } else {
            return true;
        }
    }
}

//객체지향 식당 메뉴에 반복자 사용하기
public class DinerMenu {
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;
    
    public DinerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];

        addItem(
                "채식주의자용 세트",
                "통밀 등등 맛 없는 거",
                true,
                2, 99
        );
    }


    public void addItem(String name, String description,
                        boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        if (numberOfItems >= MAX_ITEMS) {
            System.out.println("메뉴가 꽉 찼습니다");
        } else {
            menuItems[numberOfItems] = menuItem;
            this.numberOfItems = numberOfItems + 1;
        }
        menuItems.add(menuItem);
    }
    
    public Iterator createIterator() {
        return new DinerMenuIterator(this.menuItems);
    }
}
```

### 1.5 종업원 코드(클라이언트)에 반복자 적용하기

```java 

public class Waitress {
    팬케이크메뉴 팬케이크;
    DinerMenu dinerMenu;

    public Waitress(팬케이크메뉴 팬케이크, DinerMenu dinerMenu) {
        this.팬케이크메뉴 = 팬케이크;
        this.dinerMenu = dinerMenu;
    }

    public void 메뉴_츌력() {
        Iterator 팬케이크_반복자 = 팬케이크.createIterator();
        Iterator dinerMenuIterator = dinerMenu.createIterator();

        System.out.println("메뉴------------\n아침메뉴");
        System.out.println("메뉴------------\n아침메뉴");
    }

    public void printMenu(Iterator iterator) {
        while (iterator.hasNext()) {
            MenuItem 메뉴 = iterator.next();
            System.out.println("메뉴 이름" + 메뉴.getName());
            System.out.println("메뉴 가격" + 메뉴.price());
            System.out.println("메뉴 설명" + 메뉴.description());
        }
    }
}
```
클라이언트 코드를 `Iterator` 인터페이스를 활용하여 반복을 캡슐화 하였다.   
반복을 수행해야할 클래스가 Iterator를 보유해야 하지만, 기존에 산재되어 있는 코드를 모두 수정하는 것보다 효율적이다.  
추가로 반복자가 추가되어 순회하는 방식이 통일되었기 때문에 불필요한 중복코드를 작성하지 않아도 된다. 


### 컴포지트 패턴 살펴보기 
- 컴포지트 패턴은 객체를 트리구조로 궝해서 부분-전체 계층구조를 구현한다.
- 컴포지트 패턴을 사용하면 객체의 구성과 개별 객체를 노드로 가지는 트리형태의 객체 구조를 만들 수 있다.

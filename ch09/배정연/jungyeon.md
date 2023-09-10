# Java Iterator Pattern

Java Iterator Pattern(반복자 패턴)은 객체 지향 디자인 패턴 중 하나로, 컬렉션 객체의 요소를 순서대로 접근하는 방법을 제공하는 패턴입니다. 이 패턴은 컬렉션의 내부 구조에 독립적으로 요소를 반복하고 접근할 수 있도록 해줍니다.

## 구성 요소

- **Iterator(반복자)**: 요소를 순서대로 접근하고 반복하는 인터페이스를 정의합니다. 이 인터페이스에는 다음 요소로 이동하고 현재 요소를 반환하는 메서드가 포함됩니다.
- **ConcreteIterator(구체적인 반복자)**: Iterator 인터페이스를 구현하는 클래스로, 실제로 컬렉션을 반복하는 로직을 구현합니다.
- **Aggregate(집합체)**: 요소의 집합을 나타내는 인터페이스를 정의합니다. 이 인터페이스에는 Iterator를 생성하는 메서드가 포함됩니다.
- **ConcreteAggregate(구체적인 집합체)**: Aggregate 인터페이스를 구현하는 클래스로, 실제로 요소의 집합을 관리하고 Iterator를 생성합니다.

## 작동 방식


1. Aggregate 인터페이스를 정의하고, 이 인터페이스를 구현하는 ConcreteAggregate 클래스를 작성합니다. ConcreteAggregate 클래스는 Iterator를 생성하는 메서드를 구현합니다.
2. Iterator 인터페이스를 정의하고, 이 인터페이스를 구현하는 ConcreteIterator 클래스를 작성합니다. ConcreteIterator 클래스는 실제로 요소를 반복하고 접근하는 로직을 구현합니다.
3. 클라이언트 코드에서 ConcreteAggregate 객체를 생성하고, 이 객체의 createIterator() 메서드를 호출하여 Iterator를 얻습니다.
4. 클라이언트 코드에서 Iterator를 사용하여 요소를 순서대로 반복하고 접근합니다.

## 장점

- 컬렉션 객체의 내부 구조에 독립적으로 요소를 반복하고 접근할 수 있습니다.
- 클라이언트 코드와 반복 로직을 분리하여 유지보수성과 확장성을 향상시킵니다.
- 다양한 종류의 컬렉션을 동일한 인터페이스를 통해 반복할 수 있습니다.

## 예제 사용 사례

- 여러 종류의 컬렉션 객체를 사용하는 코드에서 반복 로직을 일반화하고 싶을 때.
- 컬렉션 객체의 내부 구조를 숨기고 요소에 접근할 때.

## 코드 예제

```java
// Iterator 인터페이스
public interface Iterator<T> {
    boolean hasNext();
    T next();
}

// Aggregate 인터페이스
public interface Aggregate<T> {
    Iterator<T> createIterator();
}

// ConcreteAggregate 클래스
public class ConcreteAggregate<T> implements Aggregate<T> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public T getItem(int index) {
        return items.get(index);
    }

    public int size() {
        return items.size();
    }

    @Override
    public Iterator<T> createIterator() {
        return new ConcreteIterator<>(this);
    }
}

// ConcreteIterator 클래스
public class ConcreteIterator<T> implements Iterator<T> {
    private ConcreteAggregate<T> aggregate;
    private int index = 0;

    public ConcreteIterator(ConcreteAggregate<T> aggregate) {
        this.aggregate = aggregate;
    }

    @Override
    public boolean hasNext() {
        return index < aggregate.size();
    }

    @Override
    public T next() {
        if (hasNext()) {
            return aggregate.getItem(index++);
        }
        return null;
    }
}

// 클라이언트 코드
public class Main {
    public static void main(String[] args) {
        ConcreteAggregate<String> aggregate = new ConcreteAggregate<>();
        aggregate.addItem("Item 1");
        aggregate.addItem("Item 2");
        aggregate.addItem("Item 3");

        Iterator<String> iterator = aggregate.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
```

# Java Composite Pattern (복합 패턴)

Java Composite Pattern은 객체들을 트리 구조로 구성하여 부분-전체 계층을 나타내는 패턴입니다. 이 패턴을 사용하면 개별 객체와 복합 객체(개별 객체들을 포함하는 객체)를 동일한 인터페이스를 통해 처리할 수 있습니다.

## 구성 요소

- **Component(구성 요소)**: 개별 객체와 복합 객체를 나타내는 인터페이스를 정의합니다. 이 인터페이스에는 개별 객체와 복합 객체에 대한 공통 메서드가 정의됩니다.
- **Leaf(리프)**: 개별 객체를 나타내는 클래스로, Component 인터페이스를 구현합니다.
- **Composite(복합체)**: 복합 객체를 나타내는 클래스로, Component 인터페이스를 구현합니다. 또한 다른 Leaf나 Composite 객체를 자식으로 가질 수 있습니다.

## 작동 방식

1. Component 인터페이스를 정의하고, 이 인터페이스를 구현하는 Leaf와 Composite 클래스를 작성합니다.
2. Leaf 클래스는 개별 객체를 나타내고, Composite 클래스는 복합 객체를 나타냅니다. Composite 클래스는 자식 요소를 관리하기 위한 자료 구조(예: 리스트)를 가집니다.
3. 클라이언트 코드

에서 Leaf와 Composite 객체를 생성하고, 이들을 동일한 Component 인터페이스를 통해 처리합니다. 클라이언트는 복합 객체의 자식 요소에 접근할 수 있습니다.

## 장점

- 개별 객체와 복합 객체를 일관된 방식으로 처리할 수 있습니다.
- 복합 객체는 자식 요소를 재귀적으로 처리할 수 있어, 계층 구조를 효과적으로 다룰 수 있습니다.
- 객체 구조를 확장하고 새로운 복합 객체와 리프 객체를 추가하기 쉽습니다.

## 예제 사용 사례

- 그래픽 객체의 계층 구조를 나타내는 데 사용될 수 있습니다(예: 그림, 도형, 선 등).
- 파일 시스템 구조를 모델링할 때 사용될 수 있습니다(예: 디렉터리, 파일, 링크 등).

## 코드 예제

```java
// Component 인터페이스
public interface Component {
    void operation();
}

// Leaf 클래스
public class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("Leaf: " + name);
    }
}

// Composite 클래스
public class Composite implements Component {
    private List<Component> children = new ArrayList<>();

    public void add(Component component) {
        children.add(component);
    }

    @Override
    public void operation() {
        System.out.println("Composite:");
        for (Component component : children) {
            component.operation();
        }
    }
}

// 클라이언트 코드
public class Main {
    public static void main(String[] args) {
        Component leaf1 = new Leaf("Leaf 1");
        Component leaf2 = new Leaf("Leaf 2");
        
        Composite composite = new Composite();
        composite.add(leaf1);
        composite.add(leaf2);

        Component leaf3 = new Leaf("Leaf 3");

        Composite composite2 = new Composite();
        composite2.add(composite);
        composite2.add(leaf3);

        composite2.operation();
    }
}
```

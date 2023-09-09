# Java 상태 패턴

Java 상태 패턴은 객체 지향 디자인 패턴 중 하나로, 객체의 상태에 따라 객체의 동작이 변하도록 하는 패턴입니다. 이 패턴을 사용하면 객체의 상태를 클래스로 표현하고, 각 상태에 따라 다른 동작을 수행할 수 있습니다.

## 구성 요소

- **Context(컨텍스트)**: 상태를 가지고 있는 객체로, 상태를 변경하고 상태에 따라 동작을 수행합니다.
- **State(상태)**: 상태를 나타내는 인터페이스 또는 추상 클래스로, 다양한 상태에 대한 메서드를 선언합니다.
- **ConcreteState(구체적인 상태)**: State 인터페이스를 구현한 클래스로, 각 상태에 대한 동작을 구체적으로 정의합니다.

## 작동 방식


1. State 인터페이스를 정의하고, 다양한 상태를 나타내는 ConcreteState 클래스를 구현합니다. 각 ConcreteState 클래스는 해당 상태에서 수행할 동작을 구체적으로 정의합니다.
2. Context 클래스를 작성하고, 이 클래스는 상태를 가지고 있으며 상태에 따라 동작을 수행할 때 State 인터페이스를 사용합니다.
3. 클라이언트 코드에서 Context 객체를 생성하고 초기 상태를 설정합니다.
4. 클라이언트 코드에서 Context 객체의 동작을 호출하면, 현재 상태에 따라 해당 동작이 수행됩니다.
5. Context 객체의 상태를 변경하려면, 해당 상태의 ConcreteState 객체로 전환하면 됩니다.

## 장점

- 객체의 상태를 명확하게 정의하고 상태에 따라 동작을 캡슐화할 수 있습니다.
- 상태 전환 로직을 Context 클래스 내부로 캡슐화하여, 코드의 가독성과 유지보수성을 향상시킵니다.
- 새로운 상태를 추가하거나 상태 동작을 변경하기 쉽습니다.

## 예제 사용 사례


- 객체가 여러 상태를 가지며 각 상태에 따라 다른 동작을 수행해야 할 때.
- 객체의 행동이 상태에 따라 동적으로 변할 때.

## 코드 예제

```java
// State 인터페이스
public interface State {
    void handle();
}

// ConcreteState 클래스
public class ConcreteStateA implements State {
    @Override
    public void handle() {
        System.out.println("상태 A에서 동작 수행");
    }
}

public class ConcreteStateB implements State {
    @Override
    public void handle() {
        System.out.println("상태 B에서 동작 수행");
    }
}

// Context 클래스
public class Context {
    private State currentState;

    public void setState(State state) {
        this.currentState = state;
    }

    public void performOperation() {
        currentState.handle();
    }
}

// 클라이언트 코드
public class Main {
    public static void main(String[] args) {
        Context context = new Context();

        State stateA = new ConcreteStateA();
        State stateB = new ConcreteStateB();

        context.setState(stateA);
        context.performOperation();

        context.setState(stateB);
        context.performOperation();
    }
}
```
상태 패턴을 사용하면 객체의 상태 변화에 따라 동작을 쉽게 관리하고 확장할 수 있습니다.

# Java Proxy 패턴

Java Proxy 패턴은 객체 지향 디자인 패턴 중 하나로, 다른 객체에 대한 대리자 또는 대변자 역할을 하는 객체를 제공하여 해당 객체에 대한 접근을 제어하고 추가 기능을 제공하는 패턴입니다.

## 구성 요소

- **Subject(주체)**: 실제 서비스 객체와 Proxy 객체가 공통적으로 구현하는 인터페이스를 정의합니다. 이 인터페이스에는 실제 서비스 객체와 Proxy 객체가 공유하는 메서드가 선언됩니다.
- **RealSubject(실제 주체)**: 주체 인터페이스를 구현한 실제 서비스 객체입니다. 이 객체가 수행해야 할 실제 작업을 처리합니다.
- **Proxy(대리자)**: 주체 인터페이스를 구현하며 실제 서비스 객체를 감싸는 역할을 하는 객체입니다. Proxy 객체는 실제 서비스 객체를 참조하고, 요청을 전달하면서 추가 기능을 수행할 수 있습니다.

## 작동 방식

1. Subject 인터페이스를 정의하고, 실제 서비스 객체인 RealSubject와 Proxy 객체가 이 인터페이스를 구현하도록 합니다.
2. 클라이언트 코드는 Proxy 객체를 생성하고 이를 통해 서비스를 요청합니다.
3. Proxy 객체는 실제 서비스 객체를 생성하거나 참조하고, 요청을 전달합니다.
4. Proxy 객체는 실제 서비스 객체에 대한 접근을 제어하고 추가 기능을 수행할 수 있습니다. 이러한 추가 기능은 실제 서비스 객체를 감싸는 형태로 구현됩니다.

## 장점

- 접근 제어: Proxy 객체를 사용하여 실제 서비스 객체에 대한 접근을 제어할 수 있습니다. 특정 조건을 검사하거나 로깅, 캐싱 등의 추가 작업을 수행할 수 있습니다.
- 지연 로딩: 필요한 시점에만 실제 객체를 생성하거나 초기화할 수 있으므로 자원을 효율적으로 관리할 수 있습니다.
- 보안: Proxy를 사용하여 권한 검사 등의 보안 기능을 추가할 수 있습니다.

## 예제 사용 사례

- 원격 서비스에 대한 로컬 프록시를 사용하여 네트워크 비용을 줄이고 성능을 향상시킬 때.
- 대용량 데이터베이스에 대한 쿼리 결과를 캐싱하여 반복적인 요청의 처리 속도를 높일 때.
- 객체의 생성과 초기화에 비용이 많이 드는 경우, 필요할 때까지 객체를 생성하지 않고 지연 로딩을 적용할 때.

## 코드 예제

```java
// Subject 인터페이스
public interface Image {
    void display();
}

// RealSubject 클래스
public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading image: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

// Proxy 클래스
public class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

// 클라이언트 코드
public class Main {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        // 이미지 로딩 및 표시
        image1.display();
        image2.display();
    }
}
```
Proxy 패턴을 사용하여 실제 객체에 대한 접근을 제어하고 추가 기능을 쉽게 추가할 수 있습니다.

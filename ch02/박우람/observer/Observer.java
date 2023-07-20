package test.observer;

public interface Observer {
    void update(int temperature, int humidity, int airPressure);
    void display();
}
package uram.observer;

public class WeatherStatisticsDisplayObserver implements Observer {
    public void update(int temperature, int humidity, int airPressure) {
        display();
    }

    public void display() {
        System.out.println("평균 기온이 어떻게 될까요?? 하하");
    }
}
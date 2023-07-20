package uram.observer;

public class WeatherForecastsDisplayObserver implements Observer {
    public void update(int temperature, int humidity, int airPressure) {
        display();
    }

    public void display() {
        System.out.println("날씨가 아주 안 좋습니다....");
    }
}
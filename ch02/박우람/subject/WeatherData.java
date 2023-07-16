package uram.subject;

import test.observer.Observer;
import java.util.*;

public class WeatherData implements Subject {
    private List<Observer> observerList = new ArrayList<>();
    private int temperature;
    private int humidity;
    private int airPressure;

    public WeatherData() {
    }

    public WeatherData(List<Observer> observerList,
                       int temperature,
                       int humidity,
                       int airPressure) {
        this.observerList = observerList;
        this.temperature = temperature;
        this.humidity = humidity;
        this.airPressure = airPressure;
    }

    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    public void changeTemperature(int temperature) {
        changeAll(temperature, this.humidity, this.airPressure);
    }

    public void changeHumidity(int humidity) {
        changeAll(this.temperature, humidity, this.airPressure);
    }

    public void changeAirPressure(int airPressure) {
        changeAll(this.temperature, this.humidity, airPressure);
    }

    public void changeAll(int temperature, int humidity, int airPressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.airPressure = airPressure;
        notifyObserver();
    }

    private void notifyObserver() {
        for (Observer observer : observerList) {
            observer.update(this.temperature, this.humidity, this.airPressure);
        }
    }

}
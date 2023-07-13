package livid_design_pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject{
    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        for(Observer o : observers) {
            o.update();
        }
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void measurementsChanged() {
        notifyObserver();
    }

    public void setMeasurements() {
        this.temperature = (float) ((Math.random() * 99) + 1);
        this.humidity = (float) ((Math.random() * 99) + 1);
        this.pressure = (float) ((Math.random() * 99) + 1);
        measurementsChanged();
    }
}

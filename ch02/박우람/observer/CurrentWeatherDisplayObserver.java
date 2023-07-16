package uram.observer;

import java.util.HashMap;
import java.util.Map;

public class CurrentWeatherDisplayObserver implements Observer {

    private static final String TEMPERATURE_KEY = "temperature";
    private static final String HUMIDITY_KEY = "humidity";
    private static final String AIR_PRESSURE_KEY = "airPressure";
    private final Map<String, Integer> weatherMeta;

    private boolean isChange;

    public CurrentWeatherDisplayObserver() {
        this.weatherMeta = new HashMap<>();
    }

    public void update(int temperature, int humidity, int airPressure) {
        executeUpdate(temperature, humidity, airPressure);
        if (isChange) {
            display();
        }
    }

    public void display() {
        System.out.printf("온도 %d :: 습도 %d :: 기압 %d",
                weatherMeta.get(TEMPERATURE_KEY),
                weatherMeta.get(HUMIDITY_KEY),
                weatherMeta.get(AIR_PRESSURE_KEY));
        System.out.println();
    }

    private void executeUpdate(int temperature, int humidity, int airPressure) {
        if (weatherMeta.isEmpty()
                || isExistingValueChange(temperature, humidity, airPressure)) {
            this.isChange = true;
            weatherMeta.put(TEMPERATURE_KEY, temperature);
            weatherMeta.put(HUMIDITY_KEY, humidity);
            weatherMeta.put(AIR_PRESSURE_KEY, airPressure);
        } else {
            this.isChange = false;
        }
    }

    private boolean isExistingValueChange(int temperature, int humidity, int airPressure) {
        return !weatherMeta.get(TEMPERATURE_KEY).equals(temperature)
                || !weatherMeta.get(HUMIDITY_KEY).equals(humidity)
                || !weatherMeta.get(AIR_PRESSURE_KEY).equals(airPressure);
    }
}

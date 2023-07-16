package uram.app;

import uram.observer.CurrentWeatherDisplayObserver;
import uram.observer.WeatherForecastsDisplayObserver;
import uram.observer.WeatherStatisticsDisplayObserver;
import uram.subject.WeatherData;

public class Main {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        weatherData.addObserver(new CurrentWeatherDisplayObserver());
        weatherData.addObserver(new WeatherForecastsDisplayObserver());
        weatherData.addObserver(new WeatherStatisticsDisplayObserver());

        weatherData.changeAll(14, 50, 40);
        weatherData.changeAll(14, 50, 40);
        weatherData.changeAll(45, 50, 40);
    }
}

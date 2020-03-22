package external.lab.ua.observer;

public interface Observer {
    void update(float temperature, float modelWeatherHumidity, float modelWeatherPressure, String city, String sunRise, String sunSet, float temp, float humidity, float pressure);
}

package external.lab.ua.weatherStation;

import external.lab.ua.observer.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ModelWeather implements Subject {
    private String city;
    private String sunRise;
    private String sunSet;
    private float temperature;
    private float MinTemperature;
    private float MaxTemperature;
    private float temperatureFeelLikes;
    private float pressure;
    private float humidity;
    private ArrayList observers;
    private  boolean changed;

    public ModelWeather () {
        observers = new ArrayList();
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if(i>=0){
            observers.remove(i);
        }
    }

    public void notifyObserver() {
        if(changed) {
            for (int i = 0; i < observers.size(); i++) {
                Observer observer = (Observer) observers.get(i);
                observer.update(getTemperature(), getHumidity(), getPressure(),getCity(),getSunRise(),
                        getSunSet(),getTemperatureFeelLikes(),getMaxTemperature(),getMinTemperature());
            }
            changed = false;
        }
    }

    @Override
    public void SetChanged() {
        changed = true;
    }

    public void measurementsChanged(){
        SetChanged();
        notifyObserver();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSunRise() {
        return sunRise;
    }

    public void setSunRise(String sunRise) {
        this.sunRise = sunRise;
    }

    public String getSunSet() {
        return sunSet;
    }

    public void setSunSet(String sunSet) {
        this.sunSet = sunSet;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getMinTemperature() {
        return MinTemperature;
    }

    public void setMinTemperature(float minTemperature) {
        MinTemperature = minTemperature;
    }

    public float getMaxTemperature() {
        return MaxTemperature;
    }

    public void setMaxTemperature(float maxTemperature) {
        MaxTemperature = maxTemperature;
    }

    public float getTemperatureFeelLikes() {
        return temperatureFeelLikes;
    }

    public void setTemperatureFeelLikes(float temperatureFeelLikes) {
        this.temperatureFeelLikes = temperatureFeelLikes;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

}
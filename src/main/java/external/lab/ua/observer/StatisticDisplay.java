package external.lab.ua.observer;

public class StatisticDisplay implements Observer,DisplayElement {
    private float temperature;
    private float minTemperature;
    private float maxTemperature;

    private Subject weatherData;

    public StatisticDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void display() {
        System.out.println("Statistic " + ":\n" + "Current temperature "+ temperature + " °C \n "
                + "Min temperature" + minTemperature + " °C\n "+
                 "Max temperature" + maxTemperature + " °C\n ");
    }

    public void update(float temperature,float humidity, float pressure, String city, String sunRise, String sunSet, float tempFellLikes, float max, float min ) {
        this.temperature= temperature;
        this.minTemperature = min;
        this.maxTemperature = max;
        display();
    }
    public void remove(){
        weatherData.removeObserver(this);
    }
}

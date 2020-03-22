package external.lab.ua.observer;

public class ForecastDisplay implements Observer,DisplayElement {
    private float temperature;
    private float lastTemperature = 4;
    private Subject weatherData;

    public ForecastDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.print("Forecast: ");
        if (temperature> lastTemperature) {
            System.out.println("Tomorrow will be warmer then today");
        } else if (temperature == lastTemperature) {
            System.out.println("Nothing will change");
        } else if (temperature < lastTemperature) {
            System.out.println("Tomorrow will be colder then today");
        }
    }

    @Override
    public void update(float temperature,float humidity, float pressure, String city, String sunRise, String sunSet, float tempFellLikes, float max, float min) {
        this.temperature = temperature;
        display();
    }

    public void remove(){
        weatherData.removeObserver(this);
    }

}

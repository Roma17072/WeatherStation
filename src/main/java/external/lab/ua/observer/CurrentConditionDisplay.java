package external.lab.ua.observer;

public class CurrentConditionDisplay implements Observer, DisplayElement {
    private float temperature;
    private float fellLikes;
    private float humidity;
    private float pressure;
    String city;
    String sunRise;
    String sunSet;
    private Subject weatherData;

    public CurrentConditionDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void display() {
        System.out.println("Current weather in " + city + ":\n" + "Temperature "+ temperature + " °C but fell likes "
                + fellLikes + " °C\n " + humidity + " % humidity\n" +"pressure " + pressure + " hpa\n"
                + "Sun Rise " + sunRise + "\n" + "Sun Set " + sunSet + "\n");
    }

    public void update(float temperature,float humidity, float pressure, String city, String sunRise, String sunSet, float tempFellLikes, float max, float min ) {
        this.temperature= temperature;
        this.humidity=humidity;
        this.fellLikes=tempFellLikes;
        this.pressure= pressure;
        this.city=city;
        this.sunRise = sunRise;
        this.sunSet = sunSet;
        display();
    }

    public void remove(){
        weatherData.removeObserver(this);
    }
}

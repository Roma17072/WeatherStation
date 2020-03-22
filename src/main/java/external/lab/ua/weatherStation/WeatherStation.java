package external.lab.ua.weatherStation;

import external.lab.ua.observer.*;

public class WeatherStation {
    public static void main(String[] args) throws Exception {
        ModelWeather modelWeather = new ModelWeather();
        View view = new View();
        ModelObserver modelObserver =new ModelObserver(modelWeather);
        ViewObserver viewObserver = new ViewObserver();
        ControllerObserver controllerObserver = new ControllerObserver(modelObserver,viewObserver);
        ControllerWeather controllerWeather = new ControllerWeather(modelWeather, view, controllerObserver);
        controllerWeather.process();
    }
}

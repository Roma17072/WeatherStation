package external.lab.ua.weatherStation;

import external.lab.ua.observer.ControllerObserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ControllerWeather {
    ModelWeather modelWeather;
    View view;
    ControllerObserver controllerObserver;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String url = "http://api.openweathermap.org/data/2.5/weather?q=Kyiv&lang=uk_ua&mode=xml&appid=c921fd7258f28aeef7515c9349544a7d&units=metric";
    String url1 = "http://api.openweathermap.org/data/2.5/weather?q=Kyiv&lang=uk_ua&appid=c921fd7258f28aeef7515c9349544a7d&units=metric";

    public ControllerWeather(ModelWeather modelWeather, View view, ControllerObserver controllerObserver) {
        this.modelWeather = modelWeather;
        this.view = view;
        this.controllerObserver =controllerObserver;
    }

    public void process () throws Exception {
        view.printMessage(View.CHOSE_FORMAT);
        if(checkInput(br)==1){
            XMLParser.XMLParse(modelWeather, url);
        }else{
            ParseJSON.JSONParse(modelWeather, ParseJSON.getTextFromUrl(url1));
        }
        while(!controllerObserver.observerProcess()) {
            modelWeather.measurementsChanged();
            controllerObserver.observerProcess();
        }
    }

    private int checkInput (BufferedReader br) {
        int input = 0;
        do {
            try {
                input = Integer.parseInt(br.readLine());
                if (input >2 || input < 0){
                    input = 0;
                    view.printMessage(View.WRONG);
                }
            } catch (NumberFormatException | IOException e) {
                view.printMessage(View.WRONG);
            }
        }while (input == 0);
        return input;
    }

}

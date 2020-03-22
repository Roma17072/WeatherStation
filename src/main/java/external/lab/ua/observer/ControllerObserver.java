package external.lab.ua.observer;

import external.lab.ua.weatherStation.ParseJSON;
import external.lab.ua.weatherStation.View;
import external.lab.ua.weatherStation.XMLParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ControllerObserver {
    ModelObserver modelObserver;
    ViewObserver viewObserver;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public ControllerObserver(ModelObserver modelObserver, ViewObserver viewObserver) {
        this.modelObserver = modelObserver;
        this.viewObserver = viewObserver;
    }

    public boolean observerProcess(){
        viewObserver.printMessage(ViewObserver.CHOSE_DISPLAY_ACTION);
        if(checkInput(br,0,2)==1){
            viewObserver.printMessage(ViewObserver.ADD_DISPLAY);
            modelObserver.addDisplay(checkInput(br,0,3));
        }else {
            viewObserver.printMessage(ViewObserver.REMOVE_DISPLAY);
            modelObserver.removeDisplay(checkInput(br,0,3));
        }
        return false;
    }

    private int checkInput (BufferedReader br, int min, int max) {
        int input = 0;
        do {
            try {
                input = Integer.parseInt(br.readLine());
                if (input >max || input < min){
                    input = 0;
                    viewObserver.printMessage(ViewObserver.WRONG);
                }
            } catch (NumberFormatException | IOException e) {
                viewObserver.printMessage(ViewObserver.WRONG);
            }
        }while (input == 0);
        return input;
    }

}

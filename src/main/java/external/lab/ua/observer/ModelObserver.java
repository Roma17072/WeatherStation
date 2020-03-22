package external.lab.ua.observer;

public class ModelObserver {
    Subject modelWeather;
    CurrentConditionDisplay currentDisplay;
    StatisticDisplay statisticDisplay;
    ForecastDisplay forecastDisplay;

    public ModelObserver(Subject modelWeather ) {
        this.modelWeather = modelWeather;
    }

    public void addDisplay(int i){
        switch (i) {
            case 1:
                currentDisplay = new CurrentConditionDisplay(modelWeather);
                break;
            case 2:
                statisticDisplay = new StatisticDisplay(modelWeather);
                break;
            case 3:
                forecastDisplay = new ForecastDisplay(modelWeather);
                break;
        }
    }
    public void removeDisplay(int i){
        switch (i) {
            case 1:
                if(currentDisplay != null){
                    currentDisplay.remove();
                }
                break;
            case 2:
                if(statisticDisplay != null) {
                    statisticDisplay.remove();
                }
                break;
            case 3:
                if(forecastDisplay != null){
                    forecastDisplay.remove();
                }
                break;
        }
    }
}

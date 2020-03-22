package external.lab.ua.weatherStation;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class XMLParser {
    public static void XMLParse (ModelWeather modelWeather, String url){
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element city = doc.select("city").first();
        modelWeather.setCity(city.attr("name"));
        Element sun = doc.select("sun").first();
        modelWeather.setSunRise(sun.attr("rise"));
        modelWeather.setSunSet(sun.attr("set"));
        Element temperature = doc.select("temperature").first();
        modelWeather.setTemperature(Float.parseFloat(temperature.attr("value")));
        modelWeather.setMinTemperature(Float.parseFloat(temperature.attr("min")));
        modelWeather.setMaxTemperature(Float.parseFloat(temperature.attr("max")));
        Element feelsLike = doc.select("feels_like").first();
        modelWeather.setTemperatureFeelLikes(Float.parseFloat(feelsLike .attr("value")));
        Element humidity = doc.select("humidity").first();
        modelWeather.setHumidity(Float.parseFloat(humidity .attr("value")));
        Element pressure = doc.select("pressure").first();
        modelWeather.setPressure(Float.parseFloat(pressure.attr("value")));
    }
}

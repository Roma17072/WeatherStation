package external.lab.ua.weatherStation;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ParseJSON {

    public static void JSONParse(ModelWeather modelWeather, String data){
        JSONObject obj = null;
        try {
            obj = (JSONObject) new JSONParser().parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        modelWeather.setCity((String)obj.get("name"));
        JSONObject main = (JSONObject) obj.get("main");
        modelWeather.setTemperature(Float.parseFloat(main.get("temp").toString()));
        modelWeather.setMaxTemperature(Float.parseFloat(main.get("temp_max").toString()));
        modelWeather.setMinTemperature(Float.parseFloat(main.get("temp_min").toString()));
        modelWeather.setTemperatureFeelLikes(Float.parseFloat(main.get("feels_like").toString()));
        modelWeather.setPressure(Float.parseFloat(main.get("pressure").toString()));
        modelWeather.setHumidity(Float.parseFloat(main.get("humidity").toString()));
        JSONObject sys = (JSONObject) obj.get("sys");
        long sunset = Long.parseLong(sys.get("sunset").toString());
        String timesunset= new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date (sunset*1000));
        long sunrise = Long.parseLong(sys.get("sunrise").toString());
        String timesunrise = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date (sunrise*1000));
        modelWeather.setSunSet(timesunset);
        modelWeather.setSunRise(timesunrise);
    }

    public static String getTextFromUrl(String url) throws Exception {
        URL website = new URL(url);
        URLConnection connection = website.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        connection.getInputStream(),"windows-1251"));

        StringBuilder response = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null){
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

}

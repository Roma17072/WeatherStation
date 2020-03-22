package external.lab.ua.weatherStation;

public class View {

    public final static String CHOSE_FORMAT="Which format do you want to use:\n1 XML\n2 JSON";
    public static final String WRONG = "Wrong input! Repeat please!";

    public void printMessage(String message){
        System.out.println(message);
    }
}

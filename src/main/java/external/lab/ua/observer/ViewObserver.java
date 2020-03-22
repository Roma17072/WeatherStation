package external.lab.ua.observer;

public class ViewObserver {
    public final static String CHOSE_DISPLAY_ACTION="What do you want to do?\n1 add display\n2 remove display";
    public final static String ADD_DISPLAY="Witch display do you want to add?\n1 Current condition\n2 Statistic\n3 Forecast";
    public final static String REMOVE_DISPLAY="Witch display do you want to remove?\n1 Current condition\n2 Statistic\n3 Forecast";
    public static final String WRONG = "Wrong input! Repeat please!";

    public void printMessage(String message){
        System.out.println(message);
    }
}

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class SystemTimeFetcher {

    protected String fetchTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime now = LocalTime.now();
        String timeFetched = formatter.format(now).toString();
        return timeFetched;
    }

    protected void displayTime() {
        System.out.println(fetchTime());
    }

}

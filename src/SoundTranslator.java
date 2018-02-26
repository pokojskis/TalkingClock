import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SoundTranslator {

    private final String HOURS[] =
            { "alarm.wav", "2.wav", "3.wav", "4.wav", "5.wav", "6.wav", "7.wav", "8.wav", "9.wav", "10.wav", "11.wav", "12.wav" };
    private final String TEENS[] =
            { "10.wav", "11.wav", "12.wav", "13.wav", "14.wav", "15.wav", "16.wav", "17.wav", "18.wav", "19.wav" };
    private final String MINUTES_FIRST[] =
            { "0.wav",  "20.wav", "30.wav", "40.wav", "50.wav" };
    private final String MINUTES_SECOND[] =
            { "1.wav", "2.wav", "3.wav", "4.wav", "5.wav", "6.wav", "7.wav", "8.wav", "9.wav" };
    private final String url = "/home/pokojskis/IdeaProjects/TalkingClock/hitachi/";
    private String[] hoursAndMinutes;
    private char[] digits;
    private List<String> clockPlaylist;
    private Scanner scanner;

    public SoundTranslator() {
        scanner = new Scanner(System.in);
        clockPlaylist = new ArrayList<>();
    }

    public void start() {
        parseTime();
        addToPlaylist();
        playClock();
    }

    private String enterHour() {
        System.out.print("Enter hour to translate in format HH:MM: ");
        String hourToTranslate = scanner.nextLine();
        return hourToTranslate;
    }

    private List<String> addToPlaylist() {
        int clockConverted = Integer.parseInt(hoursAndMinutes[0]);
        clockPlaylist.add("announcement.wav");
        clockPlaylist.add(parseHour());
        if (digits[0] == '1') {
            clockPlaylist.add(parseTeens());
        } else {
            clockPlaylist.add(parseFirstMinuteDigit());
            clockPlaylist.add(parseSecondMinuteDigit());
        }
        if (clockConverted < 12) {
            clockPlaylist.add("am.wav");
        } else {
            clockPlaylist.add("pm.wav");
        }
        return clockPlaylist;
    }

    private void parseTime() {
        hoursAndMinutes = enterHour().split(":");
        digits = hoursAndMinutes[1].toCharArray();
    }

    private String parseHour() {
        String hour = "";

        switch (hoursAndMinutes[0]) {
            case "01": hour = HOURS[0];
                break;
            case "02": hour = HOURS[1];
                break;
            case "03": hour = HOURS[2];
                break;
            case "04": hour = HOURS[3];
                break;
            case "05": hour = HOURS[4];
                break;
            case "06": hour = HOURS[5];
                break;
            case "07": hour = HOURS[6];
                break;
            case "08": hour = HOURS[7];
                break;
            case "09": hour = HOURS[8];
                break;
            case "10": hour = HOURS[9];
                break;
            case "11": hour = HOURS[10];
                break;
            case "12": hour = HOURS[11];
                break;
            case "13": hour = HOURS[0];
                break;
            case "14": hour = HOURS[1];
                break;
            case "15": hour = HOURS[2];
                break;
            case "16": hour = HOURS[3];
                break;
            case "17": hour = HOURS[4];
                break;
            case "18": hour = HOURS[5];
                break;
            case "19": hour = HOURS[6];
                break;
            case "20": hour = HOURS[7];
                break;
            case "21": hour = HOURS[8];
                break;
            case "22": hour = HOURS[9];
                break;
            case "23": hour = HOURS[10];
                break;
            case "00": hour = HOURS[11];
                break;
            default:
                break;
        }
        return hour;
    }

    private String parseFirstMinuteDigit() {
        String firstMinuteDigit = "";

        if (digits[0] == '0' && digits[1] == '0') {
            return "";
        } else {
            switch (digits[0]) {
                case '0': firstMinuteDigit = MINUTES_FIRST[0];
                    break;
                case '2': firstMinuteDigit = MINUTES_FIRST[1];
                    break;
                case '3': firstMinuteDigit = MINUTES_FIRST[2];
                    break;
                case '4': firstMinuteDigit = MINUTES_FIRST[3];
                    break;
                case '5': firstMinuteDigit = MINUTES_FIRST[4];
                    break;
            }
        }
        return firstMinuteDigit;
    }

    private String parseSecondMinuteDigit() {
        String secondMinuteDigit = "";

        switch (digits[1]) {
            case '1': secondMinuteDigit = MINUTES_SECOND[0];
                break;
            case '2': secondMinuteDigit = MINUTES_SECOND[1];
                break;
            case '3': secondMinuteDigit = MINUTES_SECOND[2];
                break;
            case '4': secondMinuteDigit = MINUTES_SECOND[3];
                break;
            case '5': secondMinuteDigit = MINUTES_SECOND[4];
                break;
            case '6': secondMinuteDigit = MINUTES_SECOND[5];
                break;
            case '7': secondMinuteDigit = MINUTES_SECOND[6];
                break;
            case '8': secondMinuteDigit = MINUTES_SECOND[7];
                break;
            case '9': secondMinuteDigit = MINUTES_SECOND[8];
                break;
            default:
                break;
        }
        return secondMinuteDigit;
    }

    private String parseTeens() {
        String teens = "";

        if (digits[0] == '1') {
            switch (digits[1]) {
                case '0': teens = TEENS[0];
                    break;
                case '1': teens = TEENS[1];
                    break;
                case '2': teens = TEENS[2];
                    break;
                case '3': teens = TEENS[3];
                    break;
                case '4': teens = TEENS[4];
                    break;
                case '5': teens = TEENS[5];
                    break;
                case '6': teens = TEENS[6];
                    break;
                case '7': teens = TEENS[7];
                    break;
                case '8': teens = TEENS[8];
                    break;
                case '9': teens = TEENS[9];
                    break;
                default:
                    break;
            }
        } else {
            return "";
        }
        return teens;
    }

    private void playClock() {
        try {
            for (String s : clockPlaylist) {
                AudioInputStream ais = AudioSystem.getAudioInputStream(new File(url + s));
                Clip clip = AudioSystem.getClip();

                clip.open(ais);
                clip.start();

                while (!clip.isRunning()) {
                    Thread.sleep(10);
                }
                while (clip.isRunning()) {
                    Thread.sleep(10);
                }

                clip.close();
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}

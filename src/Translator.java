import java.util.Scanner;

public class Translator {

    public final String HOURS[] =
            { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve" };
    public final String TEENS[] =
            { "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
    public final String MINUTES_FIRST[] =
            { "oh",  "twenty", "thirty", "fourty", "fifty" };
    public final String MINUTES_SECOND[] =
            { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
    public final String dayZone[] = { "am", "pm" };

    Scanner scanner = new Scanner(System.in);

    public void start() {
        parseTime();
    }

    private String enterHour() {
        System.out.print("Enter hour to translate in format HH:MM: ");
        String hourToTranslate = scanner.nextLine();
        return hourToTranslate;
    }

    private void parseTime() {
        String[] hoursAndMinutes = enterHour().split(":");
        char[] digits = hoursAndMinutes[1].toCharArray();

        int clock12Format = Integer.parseInt(hoursAndMinutes[0]);

        if (clock12Format < 12) {
            if (digits[0] == '1') {
                displayTeensAm(digits, hoursAndMinutes);
            } else {
                displayAm(digits, hoursAndMinutes);
            }
        } else {
            if (digits[0] == '1') {
                displayTeensPm(digits, hoursAndMinutes);
            } else {
                displayPm(digits, hoursAndMinutes);
            }
        }
    }

    private String parseHour(String[] hoursAndMinutes) {
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

    private String parseFirstMinuteDigit(char[] digits) {
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

    private String parseSecondMinuteDigit(char[] digits) {
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

    private String parseTeens(char[] digits) {
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

    private void displayAm(char[] digits, String[] hoursAndMinutes) {
        System.out.println("It's " + parseHour(hoursAndMinutes) + " "
                + parseFirstMinuteDigit(digits) + " "
                + parseSecondMinuteDigit(digits) + " "
                + dayZone[0]
        );
    }

    private void displayPm(char[] digits, String[] hoursAndMinutes) {
        System.out.println("It's " + parseHour(hoursAndMinutes) + " "
                + parseFirstMinuteDigit(digits) + " "
                + parseSecondMinuteDigit(digits) + " "
                + dayZone[1]
        );
    }

    private void displayTeensAm(char[] digits, String[] hoursAndMinutes) {
            System.out.println("It's " + parseHour(hoursAndMinutes) + " "
                    + parseTeens(digits) + " "
                    + dayZone[0]
            );
    }

    private void displayTeensPm(char[] digits, String[] hoursAndMinutes) {
            System.out.println("It's " + parseHour(hoursAndMinutes) + " "
                    + parseTeens(digits) + " "
                    + dayZone[1]
            );
    }
}

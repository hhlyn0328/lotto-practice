package calulator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String SPLIT_TEXT = ",|:";

    private static final String CUSTOM_SEPARATOR ="//(.)\n(.*)";
    private static final Pattern PATTERN = Pattern.compile(CUSTOM_SEPARATOR);

    public static int splitAndSum(String text) {
        if(text == null || text.isEmpty()) {
            return 0;
        }
        if(text.length() == 1) {
            return parseInt(text);
        }

        String[] numbers = splitText(text);

        return sum(numbers);
    }

    private static String[] splitText(String text) {
        Matcher matcher = PATTERN.matcher(text);

        if(matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return text.split(SPLIT_TEXT);
    }

    private static int sum(String[] numbers) {

        int sum=0;
        for(int i=0; i< numbers.length; i++) {
            sum += parseInt(numbers[i]);
        }
        return sum;
    }

    private static int parseInt(String number) {
        checkNativeNumber(number);
        return Integer.parseInt(number);
    }

    private static void checkNativeNumber(String number) {
        if(Integer.parseInt(number) < 0) {
            throw new RuntimeException();
        }
    }
}

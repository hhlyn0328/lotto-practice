package calulator;

public class StringAddCalculator {
    private static final  String SPLIT_TEXT = ",|:";
    private static final String CUSTOM_SEPARATOR = "//";

    public static int splitAndSum(String text) {
        if(text == null || text.isEmpty()) {
            return 0;
        }
        if(text.length() == 1) {
            return Integer.parseInt(text);
        }

        String[] numbers = splitText(text);

        return sum(numbers);
    }

    private static String[] splitText(String text) {

        if(text.contains(CUSTOM_SEPARATOR)) {
            String split = text.substring(2,3);
            return text.substring(4).split(split);
        }
        return text.split(SPLIT_TEXT);
    }

    private static int sum(String[] numbers) {

        int sum=0;
        for(int i=0; i< numbers.length; i++) {
            int number = Integer.parseInt(numbers[i]);
            isNativeNumber(number);
            sum += number;
        }
        return sum;
    }

    private static void isNativeNumber(int number) {
        if(number < 0) {
            throw new RuntimeException();
        }
    }
}

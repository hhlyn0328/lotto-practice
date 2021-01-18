package calculator;

public class StringAddCalculator {

    public static int splitAndSum(String text) {

        if (isNull(text)) {
            return 0;
        }

        SplitNumbers splitNumbers = new SplitNumbers(text);
        return splitNumbers.getSum();
    }

    private static boolean isNull(String text) {
        return text == null || text.isEmpty();
    }
}

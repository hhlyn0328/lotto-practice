package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitNumbers {

    private static final String SLASH_BETWEEN_BACKSLASH_N_REGEX = "//(.)\n(.*)";
    private static final Pattern SLASH_BETWEEN_BACKSLASH_N_REGEX_PATTERN = Pattern.compile(SLASH_BETWEEN_BACKSLASH_N_REGEX);
    private static final String COMMA_OR_COLON_REGEX = ",|:";
    private static final int NUMBERS_INDEX = 2;
    private static final int DELIMITER_INDEX = 1;

    private List<Integer> numbers;

    public SplitNumbers(String inputText) {
        initNumbers(inputText);
    }

    private void initNumbers(String inputText) {
        Matcher matcher = SLASH_BETWEEN_BACKSLASH_N_REGEX_PATTERN.matcher(inputText);

        if (matcher.find()) {
            this.numbers = parseValidInt(Arrays.asList(matcher.group(NUMBERS_INDEX).split(matcher.group(DELIMITER_INDEX))));
            return;
        }

        this.numbers = parseValidInt(Arrays.asList(inputText.split(COMMA_OR_COLON_REGEX)));
    }

    private List<Integer> parseValidInt(List<String> splitStrings) {
        List<Integer> splitIntegers = new ArrayList<>();

        for (String splitString : splitStrings) {
            splitIntegers.add(isNegative(Integer.parseInt(splitString)));
        }

        return splitIntegers;
    }

    private int isNegative(Integer i) {
        if (i < 0) {
            throw new RuntimeException();
        }

        return i;
    }

    public int getSum() {
        return this.numbers.stream().
                mapToInt(Integer::intValue).
                sum();
    }
}

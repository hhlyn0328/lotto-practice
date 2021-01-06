import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SplitNumbers {

  private static final String SLASH_BETWEEN_BACKSLASH_N_REGEX = "//(.)\n(.*)";
  private static final String COMMA_OR_COLON_REGEX = ",|:";

  private List<Integer> numbers;

  public SplitNumbers(String inputText) {
    Matcher matcher = Pattern.compile(SLASH_BETWEEN_BACKSLASH_N_REGEX).matcher(inputText);

    if (matcher.find()) {
      this.numbers = splitIntegers(Arrays.asList(matcher.group(2).split(matcher.group(1))));
      return;
    }

    this.numbers = splitIntegers(Arrays.asList(inputText.split(COMMA_OR_COLON_REGEX)));
  }

  private static List<Integer> splitIntegers(List<String> splitStrings) {

    List<Integer> splitIntegers = splitStrings.stream().
            map(Integer::parseInt).
            collect(Collectors.toList());

    isAnyMatchNegative(splitIntegers);

    return splitIntegers;
  }

  private static void isAnyMatchNegative(List<Integer> collect) {
    if (collect.stream().anyMatch(i -> isNegative(i))) {
      throw new RuntimeException();
    }
  }

  private static boolean isNegative(Integer i) {
    return i < 0;
  }

  public int getSum() {
    return this.numbers.stream().
            mapToInt(Integer::intValue).
            sum();
  }
}

public class StringAddCalculator {

  public static int splitAndSum(String text) {

    if (isNull(text)) {
      return 0;
    }

    if (isNumberLengthOne(text)) {
      return Integer.parseInt(text);
    }

    SplitNumbers splitNumbers = new SplitNumbers(text);
    return splitNumbers.getSum();
  }

  private static boolean isNumberLengthOne(String numbers) {
    return numbers.length() == 1;
  }

  private static boolean isNull(String text) {
    return text == null || text.isEmpty();
  }
}

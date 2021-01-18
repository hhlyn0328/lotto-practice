package lotto;

import java.util.List;

public class LottoNumber {

    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private List<Integer> lottoNumber;

    protected LottoNumber(List<Integer> lottoNumber) {
        this.lottoNumber = isValidation(lottoNumber);
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }

    public boolean isContains(Integer lottoWinnerNumberEach) {
        return this.lottoNumber.contains(lottoWinnerNumberEach);
    }

    public static List<Integer> isValidation(List<Integer> lottoNumber) {
        isDuplicationValidation(lottoNumber);
        isLengthValidation(lottoNumber);

        for (Integer lottoNumberEach : lottoNumber) {
            isRangeValidation(lottoNumberEach);
        }

        return lottoNumber;
    }

    public static void isDuplicationValidation(List<Integer> lottoNumber) {

        boolean duplicated = lottoNumber.stream()
                .distinct()
                .count() < lottoNumber.size();

        if (duplicated) {
            throw new IllegalArgumentException();
        }
    }

    public static void isRangeValidation(Integer lottoWinnerNumberEach) {

        if (lottoWinnerNumberEach < LOTTO_START_NUMBER || lottoWinnerNumberEach > LOTTO_LAST_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public static void isLengthValidation(List<Integer> lottoNumber) {

        if (lottoNumber.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return String.valueOf(this.lottoNumber);
    }
}

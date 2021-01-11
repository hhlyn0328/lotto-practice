package lotto;

import java.util.List;

public class LottoNumberValidation {

    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;

    public static List<Integer> isValidation(List<Integer> lottoNumber) {
        isDuplicationValidation(lottoNumber);

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
}

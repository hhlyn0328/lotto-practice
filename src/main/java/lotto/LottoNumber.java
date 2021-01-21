package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int ZERO = 0;
    private static final List<Integer> LOTTO_NUMBERS = new ArrayList<>();

    static {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            LOTTO_NUMBERS.add(i);
        }
    }

    public static List<Integer> autoGenerateNumber() {
        List<Integer> lotto = new ArrayList<>();
        Collections.shuffle(LOTTO_NUMBERS);

        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            lotto.add(LOTTO_NUMBERS.get(i));
        }
        Collections.sort(lotto);
        return lotto;
    }

    public static void isValidRangeNumber(List<Integer> lotto) {
        long minusNumCount = lotto.stream()
                .filter(number -> number < MIN_NUMBER || number > MAX_NUMBER)
                .count();

        if(minusNumCount > ZERO) {
            throw new IllegalArgumentException();
        }
    }

    public static void isDupulicationNumber(List<Integer> lotto) {
        boolean isDupulication = lotto.stream()
                .distinct()
                .count() < LOTTO_NUMBER_COUNT;

        if(isDupulication) {
            throw new IllegalArgumentException();
        }
    }
}

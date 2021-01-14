package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
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

    public static int getMinNumber() {
        return MIN_NUMBER;
    }

    public static int getMaxNumber() {
        return MAX_NUMBER;
    }

    public static int getLottoNumberCount() {
        return LOTTO_NUMBER_COUNT;
    }

    protected List<Integer> getLottoNumbers() {
        return LOTTO_NUMBERS;
    }
}

package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final List<LottoNo> LOTTO_NUMBERS = new ArrayList<>();

    static {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            LOTTO_NUMBERS.add(new LottoNo(i));
        }
    }

    public static List<LottoNo> autoGenerateNumber() {
        List<LottoNo> lotto = new ArrayList<>();
        Collections.shuffle(LOTTO_NUMBERS);

        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            lotto.add(LOTTO_NUMBERS.get(i));
        }

        return lotto.stream()
                .sorted(Comparator.comparingInt(LottoNo::getLottoNo))
                .collect(Collectors.toList());
    }

    public static void isDupulicationNumber(List<LottoNo> lotto) {
        boolean isDupulication = lotto.stream()
                .distinct()
                .count() < LOTTO_NUMBER_COUNT;

        if(isDupulication) {
            throw new IllegalArgumentException();
        }
    }
}

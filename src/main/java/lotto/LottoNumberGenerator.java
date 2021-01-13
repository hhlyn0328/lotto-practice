package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {

    private static final List<Integer> LOTTO_BASE_NUMBER = new ArrayList<>();
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    static {
        for (int i = LOTTO_START_NUMBER; i <= LOTTO_LAST_NUMBER; i++) {
            LOTTO_BASE_NUMBER.add(i);
        }
    }

    public static LottoNumber createLottoNumber() {
        List<Integer> lottoNumber = new ArrayList<>();
        Collections.shuffle(LOTTO_BASE_NUMBER);

        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            lottoNumber.add(LOTTO_BASE_NUMBER.get(i));
        }

        Collections.sort(lottoNumber);

        return new LottoNumber(lottoNumber);
    }
}

package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {

    private static final List<Integer> LOTTO_BASE_NUMBER = new ArrayList<>();
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;

    static {
        for (int i = LOTTO_START_NUMBER; i <= LOTTO_LAST_NUMBER; i++) {
            LOTTO_BASE_NUMBER.add(i);
        }
    }

    public static List<Integer> createLottoNumber() {
        List<Integer> lottoNumber = new ArrayList<>();
        Collections.shuffle(LOTTO_BASE_NUMBER);

        for (int i = 0; i < 6; i++) {
            lottoNumber.add(LOTTO_BASE_NUMBER.get(i));
        }

        Collections.sort(lottoNumber);

        return lottoNumber;
    }
}

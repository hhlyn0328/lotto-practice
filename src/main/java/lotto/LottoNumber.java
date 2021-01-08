package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumber {
    private static final int LOTTO_NUMBER = 45;
    private List<Integer> lottoNumbers = new ArrayList<>();

    public LottoNumber() {
        for(int i = 1; i<= LOTTO_NUMBER; i++ ) {
            lottoNumbers.add(i);
        }
    }

    protected void shuffle() {
        Collections.shuffle(lottoNumbers);
    }

    protected List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}

package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoNumber {
    private static final int LOTTO_NUMBER = 45;
    private List<Integer> lottoNumbers = Stream.iterate(1, n->n+1).limit(LOTTO_NUMBER).collect(Collectors.toList());

    protected void shuffle() {
        Collections.shuffle(lottoNumbers);
    }

    protected List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}

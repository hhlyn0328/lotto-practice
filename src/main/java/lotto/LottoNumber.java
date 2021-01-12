package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoNumber {
    private static final int LOTTO_NUMBER = 45;
    private static final List<Integer> lottoNumbers = Stream.iterate(1, n->n+1).limit(LOTTO_NUMBER).collect(Collectors.toList());
    private List<Integer> lotto = new ArrayList<>();

    static {
        Collections.shuffle(lottoNumbers);
    }

    public List<Integer> pickLottoNumber() {
        lotto = lottoNumbers.subList(0,6);
        Collections.sort(lotto);
        return lotto;
    }


    protected List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}

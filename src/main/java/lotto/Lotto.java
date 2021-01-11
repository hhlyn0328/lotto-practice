package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private LottoNumber lottoNumber = new LottoNumber();

    private List<Integer> lotto = new ArrayList<>();

    public Lotto() {
    }

    public Lotto(List<Integer> l) {
        this.lotto = l;
    }

    public void createLotto() {
        lottoNumber.shuffle();

        lotto = lottoNumber.getLottoNumbers().subList(0,6);
        Collections.sort(lotto);
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    public long matching(List<String> winnerNumber) {
        return lotto.stream()
                .filter(number -> winnerNumber.contains(number.toString()))
                .mapToInt(Integer::intValue).count();
    }

}

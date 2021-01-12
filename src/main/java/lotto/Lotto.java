package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private List<Integer> lotto = new ArrayList<>();

    public Lotto() {
        lotto = new LottoNumber().pickLottoNumber();
        duplicationNumber();
    }

    public Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    public long matching(Lotto winnerNumber) {
        return lotto.stream()
                .filter(number -> winnerNumber.getLotto().contains(number))
                .mapToInt(Integer::intValue).count();
    }

    public void duplicationNumber() {
        List<Integer> dupList = lotto.stream().distinct().collect(Collectors.toList());

        if(dupList.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
}

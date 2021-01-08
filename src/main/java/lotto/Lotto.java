package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private LottoNumber lottoNumber = new LottoNumber();

    private List<Integer> lottoGame = new ArrayList<>();

    public void startGame() {
        lottoNumber.shuffle();

        lottoGame = lottoNumber.getLottoNumbers().subList(0,6);
        Collections.sort(lottoGame);
    }

    public List<Integer> getLottoGame() {
        return lottoGame;
    }
}

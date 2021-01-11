package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private List<Lotto> lottos = new ArrayList<>();

    public LottoGame(int gameCount) {
        for(int i=0; i<gameCount; i++) {
            lottos.add(new Lotto());
        }
    }

    public LottoGame(List<Lotto> lottoList) {// test용 생성자
        this.lottos = lottoList;
    }

    public void createLotto() {
        lottos.forEach(lotto -> lotto.createLotto());
    }

    public List<Lotto> getLottoGames() {
        return this.lottos;
    }

    public LottoResult matching(List<String> winnerNumber) {
        List<LottoScore> lottoScores = new ArrayList<>();

        lottos.forEach(lotto -> {
            lottoScores.add(new LottoScore(lotto, lotto.matching(winnerNumber)));
        });

        return new LottoResult(lottoScores);
    }
}

package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private List<Lotto> lottos = new ArrayList<>();
    private Price price;

    public LottoGame(Price price) {
        this.price = price;

        for(int i=0; i<price.getLottoCount(); i++) {
            lottos.add(new Lotto());
        }

    }

    public LottoGame(List<Lotto> lottoList,Price price) {// test용 생성자
        this.price = price;
        this.lottos = lottoList;
    }

    public List<Lotto> getLottoGames() {
        return this.lottos;
    }

    public LottoResult matching(Lotto winnerNumber) {
        List<LottoScore> lottoScores = new ArrayList<>();

        lottos.forEach(lotto -> {
            lottoScores.add(new LottoScore(lotto, lotto.matching(winnerNumber)));
        });

        return new LottoResult(lottoScores, price);
    }
}

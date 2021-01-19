package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {

    private List<Lotto> lottos = new ArrayList<>();
    private Price price;

    public LottoGame(Price price) {
        this.price = price;

        for(int i=0; i<price.getLottoCount(); i++) {
            lottos.add(new Lotto());
        }

    }

    protected LottoGame(List<Lotto> lottoList,Price price) {// test용 생성자
        this.price = price;
        this.lottos = lottoList;
    }

    public List<Lotto> getLottoGames() {
        return this.lottos;
    }

    public LottoResult matching(Lotto winnerNumber) {
        List<LottoScore> lottoScores = new ArrayList<>();

        lottoScores = lottos.stream()
                .map(lotto -> new LottoScore(lotto, lotto.matching(winnerNumber)))
                .collect(Collectors.toList());

        return new LottoResult(lottoScores, price);
    }
}

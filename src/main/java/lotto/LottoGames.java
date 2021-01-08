package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGames {

    private List<Lotto> lottoGame = new ArrayList<>();

    public LottoGames(int gameCount) {
        for(int i=0; i<gameCount; i++) {
            lottoGame.add(new Lotto());
        }
    }

    public void startGames() {
        lottoGame.forEach(lotto -> lotto.startGame());
    }

    public List<Lotto> getLottoGames() {
        return this.lottoGame;
    }
}

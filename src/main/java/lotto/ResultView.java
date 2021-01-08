package lotto;

public class ResultView {

    protected static void print(LottoGames lottoGames) {
        for(Lotto lotto: lottoGames.getLottoGames()) {
            printLotto(lotto);
        }
    }

    private static void printLotto(Lotto lotto) {
        System.out.println(lotto.getLottoGame());
    }
}

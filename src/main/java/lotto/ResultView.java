package lotto;

public class ResultView {
    private static final long SCORE_3 = Long.parseLong(Reward.SCORE_3.toString());
    private static final long SCORE_4 = 4;
    private static final long SCORE_5 = 5;
    private static final long SCORE_6 = 6;

    protected static void print(LottoGame lottoGame) {
        for(Lotto lotto: lottoGame.getLottoGames()) {
            printLotto(lotto);
        }
    }

    private static void printLotto(Lotto lotto) {
        System.out.println(lotto.getLotto());
    }

    public static void printResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("-----------");

        printScore(lottoResult);

        System.out.println("총 수익률은 " + lottoResult.winningRate() + "입니다.");
    }

    private static void printScore(LottoResult lottoResult) {
        System.out.printf("%f개 일치 (%f 원) - %f 개", SCORE_3, lottoResult.getReward(SCORE_3), lottoResult.getCount(SCORE_3));
        System.out.printf("%f개 일치 (%f 원) - %f 개", SCORE_4, lottoResult.getReward(SCORE_4), lottoResult.getCount(SCORE_4));
        System.out.printf("%f개 일치 (%f 원) - %f 개", SCORE_5, lottoResult.getReward(SCORE_5), lottoResult.getCount(SCORE_5));
        System.out.printf("%f개 일치 (%f 원) - %f 개", SCORE_6, lottoResult.getReward(SCORE_6), lottoResult.getCount(SCORE_6));

    }

}

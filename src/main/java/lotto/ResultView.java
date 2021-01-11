package lotto;

public class ResultView {
    private static final long SCORE_3 = 3;
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

        printScore3(getCount(lottoResult.getResult().get(SCORE_3)));
        printScore4(getCount(lottoResult.getResult().get(SCORE_4)));
        printScore5(getCount(lottoResult.getResult().get(SCORE_5)));
        printScore6(getCount(lottoResult.getResult().get(SCORE_6)));

        System.out.println("총 수익률은 " + lottoResult.winningRate() + "입니다.");
    }

    private static void printScore3(Long count) {
        System.out.println("3개 일치 (" + Reward.rewardOfScore(SCORE_3)  + "원) -" + count + "개");
    }

    private static void printScore4(Long count) {
        System.out.println("4개 일치 (" + Reward.rewardOfScore(SCORE_4)  + "원) -" + count + "개");
    }

    private static void printScore5(Long count) {
        System.out.println("5개 일치 (" + Reward.rewardOfScore(SCORE_5)  + "원) -" + count + "개");
    }

    private static void printScore6(Long count) {
        System.out.println("6개 일치 (" + Reward.rewardOfScore(SCORE_6)  + "원) -" + count + "개");
    }

    private static long getCount(Long count) {
        if(count == null) {
            return 0;
        }
        return count;
    }
}

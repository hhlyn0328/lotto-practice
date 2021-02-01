package lotto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {


    protected static void print(LottoGame lottoGame) {
        for(Lotto lotto: lottoGame.getLottoGames()) {
            printLotto(lotto);
        }
    }

    private static void printLotto(Lotto lotto) {
        List<Integer> lotto1 = lotto.getLotto().stream()
                .map(lottoNo -> lottoNo.getLottoNo())
                .collect(Collectors.toList());

        System.out.println(lotto1);
    }

    public static void printResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("-----------");

        printScore(lottoResult);

        System.out.println("총 수익률은 " + lottoResult.winningRate() + "입니다.");
    }

    private static void printScore(LottoResult lottoResult) {

        Map<Reward, Long> results = lottoResult.getResult();

        results.entrySet()
                .forEach(result -> {
                    if(!Reward.MISS.equals(result.getKey())) {
                        System.out.printf("%d개 일치 (%d 원) - %d 개", Reward.valueOfScore(result.getKey())
                                , Reward.valueOfAmount(result.getKey())
                                , result.getValue());
                        System.out.println();
                    }

                });

    }

}

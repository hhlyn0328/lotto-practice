package lotto;

public class ResultView {

    public static void printLottoNumber(LottoNumbers lottoNumbers) {
        System.out.println(lottoNumbers.getLottoNumbers()
                .size() + "개를 구매했습니다.");

        for (LottoNumber lottoNumber : lottoNumbers.getLottoNumbers()) {
            System.out.println(lottoNumber.toString());
        }
    }

    public static void printMatchCount(LottoTotalResult lottoTotalResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(String.format("%d개 일치 (%d원) - %d개", LottoRank.FIFTH.getCountOfMatch(), LottoRank.FIFTH.getWinningMoney(), lottoTotalResult.getThreeMatchCount()));
        System.out.println(String.format("%d개 일치 (%d원) - %d개", LottoRank.FOURTH.getCountOfMatch(), LottoRank.FOURTH.getWinningMoney(), lottoTotalResult.getFourMatchCount()));
        System.out.println(String.format("%d개 일치 (%d원) - %d개", LottoRank.THIRD.getCountOfMatch(), LottoRank.THIRD.getWinningMoney(), lottoTotalResult.getFiveMatchCount()));
        System.out.println(String.format("%d개 일치, 보너스 볼 일치 (%d원) - %d개", LottoRank.SECOND.getCountOfMatch(), LottoRank.SECOND.getWinningMoney(), lottoTotalResult.getFiveMatchAndBonusMatchCount()));
        System.out.println(String.format("%d개 일치 (%d원) - %d개", LottoRank.FIRST.getCountOfMatch(), LottoRank.FIRST.getWinningMoney(), lottoTotalResult.getSixMatchCount()));
        System.out.println("" + String.format("총 수익률은 : %.2f 입니다.", lottoTotalResult.getReturnRate()));
    }
}

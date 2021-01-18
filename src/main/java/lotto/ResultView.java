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
        System.out.println(String.format("3개 일치 (%d원)- %d개", LottoResult.THREE_MATCH_AMOUNT, lottoTotalResult.getThreeMatchCount()));
        System.out.println(String.format("4개 일치 (%d원)- %d개", LottoResult.THREE_MATCH_AMOUNT, lottoTotalResult.getFourMatchCount()));
        System.out.println(String.format("5개 일치 (%d원)- %d개", LottoResult.THREE_MATCH_AMOUNT, lottoTotalResult.getFiveMatchCount()));
        System.out.println(String.format("6개 일치 (%d원)- %d개", LottoResult.THREE_MATCH_AMOUNT, lottoTotalResult.getSixMatchCount()));
        System.out.println("" + String.format("총 수익률은 : %.2f 입니다.",lottoTotalResult.getReturnRate()));
    }
}

package lotto;

public class ResultView {

    public static void printLottoNumber(LottoNumbers lottoNumbers) {
        System.out.println(lottoNumbers.getLottoNumbers().size() + "개를 구매했습니다.");

        for (LottoNumber lottoNumber : lottoNumbers.getLottoNumbers()) {
            System.out.println(lottoNumber.toString());
        }
    }

    public static void printMatchCount(LottoTotalResult lottoTotalResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (" + LottoResult.THREE_MATCH_AMOUNT + "원)- " + lottoTotalResult.getThreeMatchCount() + "개");
        System.out.println("4개 일치 (" + LottoResult.FOUR_MATCH_AMOUNT + "원)- " + lottoTotalResult.getFourMatchCount() + "개");
        System.out.println("5개 일치 (" + LottoResult.FIVE_MATCH_AMOUNT + "원)- " + lottoTotalResult.getFiveMatchCount() + "개");
        System.out.println("6개 일치 (" + LottoResult.SIX_MATCH_AMOUNT + "원)- " + lottoTotalResult.getSixMatchCount() + "개");
        System.out.println("총 수익률은 : " + lottoTotalResult.getReturnRate() + "입니다.");
    }
}

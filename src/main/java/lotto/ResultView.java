package lotto;


import java.util.Arrays;

public class ResultView {

    public static void printLottoNumber(LottoNumbers lottoNumbers) {
        System.out.println(lottoNumbers.getLottoNumbers().size() + "개를 구매했습니다.");

        for (LottoNumber lottoNumber : lottoNumbers.getLottoNumbers()) {
            System.out.println(Arrays.toString(
                    lottoNumber.getLottoNumber().stream().
                            mapToInt(Integer::intValue).
                            toArray())
            );
        }
    }

    public static void printMatchCount(LottoTotalResult lottoTotalResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + lottoTotalResult.getThreeMatchCount() + "개");
        System.out.println("4개 일치 (50000원)- " + lottoTotalResult.getFourMatchCount() + "개");
        System.out.println("5개 일치 (1500000원)- " + lottoTotalResult.getFiveMatchCount() + "개");
        System.out.println("6개 일치 (2000000000원)- " + lottoTotalResult.getSixMatchCount() + "개");
        System.out.println("총 수익률은 : " + lottoTotalResult.getReturnRate() + "입니다.");
    }
}

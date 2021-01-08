package lotto;

import java.util.List;

public class LottoWinnerNumber {

    private List<Integer> lottoWinnerNumber;

    public LottoWinnerNumber(List<Integer> lottoWinnerNumber) {
        this.lottoWinnerNumber = isOneToFortyFiveNumber(lottoWinnerNumber);
    }

    public List<Integer> getLottoWinnerNumber() {
        return lottoWinnerNumber;
    }

    //테스트 돌려보려고 public으로 열었음
    public static List<Integer> isOneToFortyFiveNumber(List<Integer> lottoWinnerNumber) {

        for (Integer lottoNumber : lottoWinnerNumber) {
            if (lottoNumber <= 0 || lottoNumber > 45) {
                throw new IllegalArgumentException();
            }
        }

        return lottoWinnerNumber;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoWinnerNumber);
    }
}

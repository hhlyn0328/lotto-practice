package lotto;

import java.util.List;

public class LottoWinnerNumber {

    private List<Integer> lottoWinnerNumber;

    public LottoWinnerNumber(List<Integer> lottoWinnerNumber) {
        LottoNumber lottoNumber = new LottoNumber(lottoWinnerNumber);
        this.lottoWinnerNumber = lottoNumber.getLottoNumber();
    }

    public int isMatchCount(LottoNumber lottoNumber) {
        return (int) this.lottoWinnerNumber.stream()
                .filter(lottoNumber::isContains)
                .count();
    }

    @Override
    public String toString() {
        return String.valueOf(lottoWinnerNumber);
    }
}

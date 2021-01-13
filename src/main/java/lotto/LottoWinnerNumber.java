package lotto;

import java.util.List;

public class LottoWinnerNumber {

    private LottoNumber lottoWinnerNumber;

    public LottoWinnerNumber(List<Integer> lottoWinnerNumber) {
        LottoNumber lottoNumber = new LottoNumber(lottoWinnerNumber);
        this.lottoWinnerNumber = lottoNumber;
    }

    public int isMatchCount(LottoNumber lottoNumber) {
        return (int) this.lottoWinnerNumber.getLottoNumber().stream()
                .filter(lottoNumber::isContains)
                .count();
    }

    @Override
    public String toString() {
        return String.valueOf(lottoWinnerNumber);
    }
}

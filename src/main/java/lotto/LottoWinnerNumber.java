package lotto;

import java.util.List;

public class LottoWinnerNumber {

    private LottoNumber lottoWinnerNumber;

    public LottoWinnerNumber(List<Integer> lottoWinnerNumber) {
        LottoNumber lottoNumber = new LottoNumber(lottoWinnerNumber);
        this.lottoWinnerNumber = lottoNumber;
    }

    public LottoResult isMatchCount(LottoNumber lottoNumber) {

        int matchCount = (int) this.lottoWinnerNumber.getLottoNumber().stream()
                .filter(lottoNumber::isContains)
                .count();

        LottoResult lottoResult = new LottoResult(matchCount);

        return lottoResult;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoWinnerNumber);
    }
}

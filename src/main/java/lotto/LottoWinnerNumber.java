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

    public List<Integer> isOneToFortyFiveNumber(List<Integer> lottoWinnerNumber) {
        return LottoNumberValidation.isValidation(lottoWinnerNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoWinnerNumber);
    }
}

package lotto;

import java.util.List;

public class LottoNumber {

    private List<Integer> lottoNumber;

    protected LottoNumber(List<Integer> lottoNumber) {
        this.lottoNumber = LottoNumberValidation.isValidation(lottoNumber);
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }

    public boolean isContains(Integer lottoWinnerNumberEach) {
        return this.lottoNumber.contains(lottoWinnerNumberEach);
    }

    @Override
    public String toString() {
        return String.valueOf(this.lottoNumber);
    }
}

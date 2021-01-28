package lotto;

import java.util.List;

public class LottoWinnerNumber {

    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;

    private LottoNumber lottoWinnerNumber;
    private int lottoWinnerBonusNumber;

    public LottoWinnerNumber(List<Integer> lottoWinnerNumbers, int lottoWinnerBonusNumber) {
        this.lottoWinnerNumber = new LottoNumber(lottoWinnerNumbers);
        this.lottoWinnerBonusNumber = lottoWinnerBonusNumber;
        validations();
    }

    private void validations() {
        rangeValidation();
        duplicationValidation();
    }

    public LottoResult matchCount(LottoNumber lottoNumber) {
        return new LottoResult(lottoNumber.matchCount(this.lottoWinnerNumber), lottoNumber.isContains(this.lottoWinnerBonusNumber));
    }

    public void rangeValidation() {
        if (this.lottoWinnerBonusNumber < LOTTO_START_NUMBER || this.lottoWinnerBonusNumber > LOTTO_LAST_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public void duplicationValidation() {
        if (this.lottoWinnerNumber.isContains(this.lottoWinnerBonusNumber)) {
            throw new IllegalArgumentException();
        }
    }


    @Override
    public String toString() {
        return String.valueOf(lottoWinnerNumber);
    }
}

package lotto;

import java.util.List;

public class LottoNumber {

    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private List<Integer> lottoNumber;

    protected LottoNumber(List<Integer> lottoNumber) {
        this.lottoNumber = validateLottoNumber(lottoNumber);
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }

    public boolean isContains(Integer lottoWinnerNumberEach) {
        return this.lottoNumber.contains(lottoWinnerNumberEach);
    }

    public int matchCount(LottoNumber lottoWinnerNumber) {
        return (int) this.lottoNumber.stream()
                .filter(lottoWinnerNumber::isContains)
                .count();
    }

    public List<Integer> validateLottoNumber(List<Integer> lottoNumber) {
        validateLength(lottoNumber);
        validateDuplication(lottoNumber);

        for (Integer lottoNumberEach : lottoNumber) {
            rangeValidation(lottoNumberEach);
        }

        return lottoNumber;
    }

    public void validateDuplication(List<Integer> lottoNumber) {
        boolean duplicated = lottoNumber.stream()
                .distinct()
                .count() < lottoNumber.size();

        if (duplicated) {
            throw new IllegalArgumentException();
        }
    }

    public void rangeValidation(Integer lottoWinnerNumberEach) {
        if (lottoWinnerNumberEach < LOTTO_START_NUMBER || lottoWinnerNumberEach > LOTTO_LAST_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public void validateLength(List<Integer> lottoNumber) {
        if (lottoNumber == null || lottoNumber.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return String.valueOf(this.lottoNumber);
    }
}

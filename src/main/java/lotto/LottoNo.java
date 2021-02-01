package lotto;

import java.util.Objects;

public class LottoNo {
    private static final int LOTTO_MIN_NUMBER = 0;
    private static final int LOTTO_MAX_NUMBER = 45;

    private int lottoNo;

    public LottoNo(Integer number) {
        this.lottoNo = number;
        isNotRangeNumber();
    }

    public LottoNo(Lotto winnerNumber, int bonusNumber) {
        this.lottoNo = bonusNumber;
        isDupulicationNumber(winnerNumber);
        isNotRangeNumber();
    }


    protected void isNotRangeNumber() {
        if(lottoNo < LOTTO_MIN_NUMBER || lottoNo > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public void isDupulicationNumber(Lotto lotto) {
        if(lotto.isContains(this)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isMatchingBonus(int remainNumber) {
        return lottoNo == remainNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNo lottoNo1 = (LottoNo) o;
        return lottoNo == lottoNo1.lottoNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNo);
    }

    public int getLottoNo() {
        return lottoNo;
    }

}

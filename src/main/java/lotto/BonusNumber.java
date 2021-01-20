package lotto;

import java.util.List;

public class BonusNumber {
    private static final int LOTTO_MIN_NUMBER = 0;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final long ZERO_NUMBER = 0;
    private int bonusNumber;

    public BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void isMinusNumber() {
        if(this.bonusNumber < LOTTO_MIN_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public void isNotRangeNumber() {
        if(bonusNumber < LOTTO_MIN_NUMBER || bonusNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public void isDupulicationNumber(Lotto lotto) {
        boolean isDuplication = lotto.getLotto().stream()
                .filter(number -> number == bonusNumber)
                .count() > ZERO_NUMBER;

        if(isDuplication) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isMatchingBonus(int remainNumber) {
        return bonusNumber == remainNumber;
    }
}

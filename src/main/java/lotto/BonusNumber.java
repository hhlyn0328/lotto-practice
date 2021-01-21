package lotto;

public class BonusNumber {
    private static final int LOTTO_MIN_NUMBER = 0;
    private static final int LOTTO_MAX_NUMBER = 45;
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
        isMinusNumber();
        isNotRangeNumber();
    }

    protected void isMinusNumber() {
        if(this.bonusNumber < LOTTO_MIN_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    protected void isNotRangeNumber() {
        if(bonusNumber < LOTTO_MIN_NUMBER || bonusNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public void isDupulicationNumber(Lotto lotto) {
        boolean isDuplication = lotto.getLotto().stream()
                .anyMatch(number -> number == bonusNumber);

        if(isDuplication) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isMatchingBonus(int remainNumber) {
        return bonusNumber == remainNumber;
    }
}

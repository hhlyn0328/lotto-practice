package lotto;

public class BonusNumber {
    private static final int LOTTO_MIN_NUMBER = 0;
    private static final int LOTTO_MAX_NUMBER = 45;
    private final int bonusNumber;

    public BonusNumber(Lotto winnerNumber, int bonusNumber) {
        isDupulicationNumber(winnerNumber);
        isNotRangeNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    protected void isNotRangeNumber(int bonusNumber) {
        if(bonusNumber < LOTTO_MIN_NUMBER || bonusNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public void isDupulicationNumber(Lotto lotto) {
        if(lotto.isContains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isMatchingBonus(int remainNumber) {
        return bonusNumber == remainNumber;
    }
}

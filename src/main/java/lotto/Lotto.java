package lotto;

import java.util.List;

public class Lotto {

    private List<Integer> lotto ;
    private static final int LOTTO_NUMBER_SIZE = 6;


    public Lotto() {
        lotto = LottoNumber.autoGenerateNumber();
        validationNumber();

    }
    public Lotto(List<Integer> lotto) {
        this.lotto = lotto;
        validationNumber();
    }

    private void validationNumber() {
        isDupulicationNumber();
        isValidRangeNumber();
        idValidNumberSize();
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    public Reward matching(Lotto winnerNumber, BonusNumber bonusNumber) {
        long matchedCount = lotto.stream()
                .filter(number -> winnerNumber.isContains(number))
                .count();

        return Reward.rewardOfScore(matchedCount, hasBonusNumber(bonusNumber));
    }

    public boolean isContains(int number) {
        return lotto.contains(number);
    }
    private boolean hasBonusNumber(BonusNumber bonusNumber) {
        return lotto.stream()
                .anyMatch(number -> bonusNumber.isMatchingBonus(number) );
    }

    public  void idValidNumberSize() {
        if(lotto.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public  void isDupulicationNumber() {
        LottoNumber.isDupulicationNumber(lotto);

    }

    public  void isValidRangeNumber() {
        LottoNumber.isValidRangeNumber(lotto);

    }

}

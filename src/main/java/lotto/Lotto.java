package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int SCORE_IS_FIVE = 5;
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
        bonusNumber.isDupulicationNumber(winnerNumber);

        List<Integer> matchedNumbers = lotto.stream()
                .filter(number -> winnerNumber.getLotto().contains(number))
                .collect(Collectors.toList());

        boolean isMatchingBonusNumber = isFiveScore(bonusNumber, matchedNumbers);
        return Reward.rewardOfScore(matchedNumbers.size(), isMatchingBonusNumber);
    }

    private boolean isFiveScore(BonusNumber bonusNumber, List<Integer> matchedNumbers) {
        if(matchedNumbers.size() != SCORE_IS_FIVE) {
            return false;
        }
        int remainNumber = 0 ;
        for(Integer num : lotto) {
            if(!matchedNumbers.contains(num)) {
                remainNumber = num;
            }
        }

        return bonusNumber.isMatchingBonus(remainNumber);
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

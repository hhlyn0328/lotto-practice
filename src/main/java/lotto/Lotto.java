package lotto;

import java.util.List;

public class Lotto {

    private List<LottoNo> lotto ;
    private static final int LOTTO_NUMBER_SIZE = 6;


    public Lotto() {
        lotto = LottoNumber.autoGenerateNumber();
        validationNumber();

    }
    public Lotto(List<LottoNo> lotto) {
        this.lotto = lotto;
        validationNumber();
    }

    private void validationNumber() {
        isDupulicationNumber();
        idValidNumberSize();
    }

    public List<LottoNo> getLotto() {
        return lotto;
    }

    public Reward matching(Lotto winnerNumber, LottoNo bonusNumber) {
        long matchedCount = lotto.stream()
                .filter(number -> winnerNumber.isContains(number))
                .count();

        return Reward.rewardOfScore(matchedCount, hasBonusNumber(bonusNumber));
    }

    public boolean isContains(LottoNo number) {
        return lotto.stream()
                .anyMatch(lottoNo -> lottoNo.equals(number));
    }
    private boolean hasBonusNumber(LottoNo bonusNumber) {
        return lotto.stream()
                .anyMatch(number -> bonusNumber.equals(number) );
    }

    public  void idValidNumberSize() {
        if(lotto.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public  void isDupulicationNumber() {
        LottoNumber.isDupulicationNumber(lotto);

    }
//
//    public  void isValidRangeNumber() {
//        LottoNumber.isValidRangeNumber(lotto);
//
//    }

}

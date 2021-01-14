package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private List<Integer> lotto ;

    public Lotto() {
        lotto = LottoNumber.autoGenerateNumber();
        validationNumber();

    }
    public Lotto(List<Integer> lotto) {
        this.lotto = lotto;
        validationNumber();
    }

    private void validationNumber() {
        notDupulicateNumber();
        validRangeNumber();
        validNumberSize();
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    public Reward matching(Lotto winnerNumber) {
        long score = lotto.stream()
                .filter(number -> winnerNumber.getLotto().contains(number))
                .mapToInt(Integer::intValue).count();

        return Reward.rewardOfScore(score);
    }

    public  void validNumberSize() {
        if(lotto.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public  void notDupulicateNumber() {
        List<Integer> dupList = lotto.stream().distinct().collect(Collectors.toList());

        if(dupList.size() != LottoNumber.getLottoNumberCount()) {
            throw new IllegalArgumentException();
        }
    }

    public  void validRangeNumber() {
        long minusNumCount = lotto.stream()
                .filter(number -> number < LottoNumber.getMinNumber() || number > LottoNumber.getMaxNumber())
                .count();

        if(minusNumCount > 0) {
            throw new IllegalArgumentException();
        }
    }

}

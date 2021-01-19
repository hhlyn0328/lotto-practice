package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class LottoResult {
    private List<LottoScore> allScore;
    private Map<Reward, Long> countOfScore;
    private Price price;

    public LottoResult(List<LottoScore> lottoScores, Price price) {
        this.allScore = Collections.unmodifiableList(lottoScores);
        this.price = price;
        this.result();
    }

    private void result() {
        countOfScore = allScore.stream()
                .filter(lottoScore -> lottoScore.isNotZeroReward() )
                .collect(Collectors.groupingBy(LottoScore::getReward, TreeMap::new,Collectors.counting()));
    }

    public long winningRate() {

        long winningAmount = countOfScore.entrySet().stream()
                .mapToLong(lotto -> Reward.amountOfReward(lotto.getKey()) * lotto.getValue() ).sum() ;

        return price.getWinningRate(winningAmount);
    }

    public long getCount(Reward reward) {
        if(countOfScore.get(reward) == null) {
            return 0;
        }
        return countOfScore.get(reward);
    }

    public Map<Reward, Long> getResult() {

        Map<Reward, Long> results = new EnumMap<>(Reward.class);

        for (Reward reward : Reward.values()) {
            results.put(reward, getCount(reward));
        }
        return results;
    }
}

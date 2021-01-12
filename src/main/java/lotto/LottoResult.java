package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class LottoResult {
    private static final long WINING_SCORE_LIMIT = 3;

    private List<LottoScore> allScore;
    private Map<Long, Long> result;
    private int lottoPrice;

    public LottoResult(List<LottoScore> lottoScores, int lottoPrice) {
        this.allScore = Collections.unmodifiableList(lottoScores);
        this.lottoPrice = lottoPrice;
        this.result();
    }

    private void result() {
        result = allScore.stream()
                .filter(lottoScore -> lottoScore.getScore() >= WINING_SCORE_LIMIT)
                .collect(Collectors.groupingBy(LottoScore::getScore, TreeMap::new,Collectors.counting()));
    }

    public long winningRate() {
        long winningAmount = result.entrySet().stream()
                .mapToLong(lotto -> Reward.rewardOfScore(lotto.getKey()) * lotto.getValue() ).sum() ;

        return winningAmount / lottoPrice;
    }

    public long getCount(long score) {
        if(result.get(score) == null) {
            return 0;
        }
        return result.get(score);
    }

    public long getReward(long score) {
        return  Reward.rewardOfScore(score);
    }

    public Map<Long, Long> getResult() {
        return result;
    }
}

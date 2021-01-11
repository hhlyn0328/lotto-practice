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

    public LottoResult(List<LottoScore> lottoScores) {
        this.allScore = Collections.unmodifiableList(lottoScores);
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

        return winningAmount / Price.getPrice();
    }

    public Map<Long, Long> getResult() {
        return result;
    }
}

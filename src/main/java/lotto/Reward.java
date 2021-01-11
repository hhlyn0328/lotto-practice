package lotto;

import java.util.Arrays;

public enum Reward {
    SCORE_0(0,0),
    SCORE_3(3,5000),
    SCORE_4(4,50000),
    SCORE_5(5,1500000),
    SCORE_6(6,2000000000);

    private final long score;
    private final long reward;

    Reward(int score, int reward) {
        this.score = score;
        this.reward = reward;
    }

    public static long rewardOfScore(long score) {
        return Arrays.stream(Reward.values())
                .filter(reward -> reward.score == score)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new).reward;
    }


}

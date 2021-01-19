package lotto;

import java.util.Arrays;

public enum Reward {
    SCORE_0(0,0),
    SCORE_3(3,5000),
    SCORE_4(4,50000),
    SCORE_5(5,1500000),
    SCORE_6(6,2000000000);

    private final long score;
    private final long amount;

    Reward(int score, int amount) {
        this.score = score;
        this.amount = amount;
    }

    public static long amountOfReward(Reward reward) {
        return reward.amount ;
    }

    public static long scoreOfReward(Reward reward) {
        return reward.score;
    }

    public static Reward rewardOfScore(long score) {
        return Arrays.stream(Reward.values())
                .filter(reward -> reward.score == score)
                .findFirst()
                .orElse(Reward.SCORE_0);

    }


}

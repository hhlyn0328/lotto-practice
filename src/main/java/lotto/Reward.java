package lotto;

import java.util.Arrays;

public enum Reward {
    FIRST(6,2000000000),
    SECOND(5,30000000),
    THIRD(5,1500000),
    FOURTH(4,50000),
    FIFTH(3,5000),
    MISS(0,0);

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

    public static Reward rewardOfScore(long score, boolean matchBonus) {

        return Arrays.stream(Reward.values())
                .filter(reward -> isSecond(reward, score, matchBonus)
                        || isNotSecond(reward, score))
                .findFirst()
                .orElse(Reward.MISS);
    }

    private static boolean isNotSecond(Reward reward, long score) {
        return !reward.equals(SECOND) && reward.score == score;
    }

    private static boolean isSecond(Reward reward, long score, boolean matchBonus) {
        return reward.equals(SECOND) && reward.score == score && matchBonus;
    }


}

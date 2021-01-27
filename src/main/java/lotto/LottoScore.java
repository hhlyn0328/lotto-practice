package lotto;

public class LottoScore {
    private Lotto lotto;
    private Reward reward;

    public LottoScore(Lotto lotto, Reward reward) {
        this.lotto = lotto;
        this.reward = reward;
    }

    public boolean isNotZeroReward() {
        return !Reward.MISS.equals(reward);
    }

    public Reward getReward() {
        return reward;
    }
}

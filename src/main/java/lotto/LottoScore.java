package lotto;

public class LottoScore {
    private Lotto lotto;

    public Reward getReward() {
        return reward;
    }

    private Reward reward;

    public LottoScore(Lotto lotto, Reward reward) {
        this.lotto = lotto;
        this.reward = reward;
    }

}

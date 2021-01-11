package lotto;

public class LottoScore {
    private Lotto lotto;
    private long score;

    public LottoScore(Lotto lotto, long score) {
        this.lotto = lotto;
        this.score = score;
    }

    public long getScore() {
        return score;
    }
}

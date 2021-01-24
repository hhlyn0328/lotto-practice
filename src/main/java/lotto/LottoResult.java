package lotto;

public class LottoResult {

    private int matchCount;
    private boolean matchBonusNumber;

    private int winningAmount;

    public LottoResult(int matchCount, boolean matchBonusNumber) {
        this.matchCount = matchCount;
        this.matchBonusNumber = matchBonusNumber;
        calculateWinningAmount();
    }

    public void calculateWinningAmount() {
        this.winningAmount = LottoRank.valueOf(this.matchCount, this.matchBonusNumber).getWinningMoney();
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public boolean isMatchBonusNumber() {
        return matchBonusNumber;
    }

    public boolean isMatchCountEqual(int matchCount) {
        return this.matchCount == matchCount;
    }
}

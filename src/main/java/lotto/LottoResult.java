package lotto;

import java.util.List;

public class LottoResult {
    public static final int THREE_MATCH_AMOUNT = 5000;
    public static final int FOUR_MATCH_AMOUNT = 50000;
    public static final int FIVE_MATCH_AMOUNT = 1500000;
    public static final int SIX_MATCH_AMOUNT = 2000000000;

    private int matchCount;
    private int winningAmount;

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public LottoResult(List<Integer> winnerLottoNumber, LottoNumber lottoNumber) {
        initMatchCount(winnerLottoNumber, lottoNumber);
        initWinningAmount();
    }

    private void initWinningAmount() {
        if (this.matchCount == 3) {
            this.winningAmount = THREE_MATCH_AMOUNT;
            return;
        }

        if (this.matchCount == 4) {
            this.winningAmount = FOUR_MATCH_AMOUNT;
            return;
        }

        if (this.matchCount == 5) {
            this.winningAmount = FIVE_MATCH_AMOUNT;
            return;
        }

        if (this.matchCount == 6) {
            this.winningAmount = SIX_MATCH_AMOUNT;
            return;
        }
    }

    private void initMatchCount(List<Integer> winnerLottoNumber, LottoNumber lottoNumber) {
        this.matchCount = (int) winnerLottoNumber.stream().
                filter(i -> lottoNumber.getLottoNumber().contains(i)).
                count();
    }
}

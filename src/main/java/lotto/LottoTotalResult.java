package lotto;

public class LottoTotalResult {
    public static final int LOTTO_PRICE = 1000;

    private int threeMatchCount = 0;
    private int fourMatchCount = 0;
    private int fiveMatchCount = 0;
    private int sixMatchCount = 0;
    private int totalWinningAmount = 0;
    private float returnRate;

    public LottoTotalResult() {
    }

    public void add(LottoResult lottoResult) {
        calculateTotalWinningAmount(lottoResult);
        calculateMatchCount(lottoResult);
    }

    public void calculateTotalWinningAmount(LottoResult lottoResult) {
        this.totalWinningAmount += lottoResult.getWinningAmount();
    }

    public void calculateMatchCount(LottoResult lottoResult) {
        if (lottoResult.isMatchCount(3)) {
            this.threeMatchCount++;
        }

        if (lottoResult.isMatchCount(4)) {
            this.fourMatchCount++;
        }

        if (lottoResult.isMatchCount(5)) {
            this.fiveMatchCount++;
        }

        if (lottoResult.isMatchCount(6)) {
            this.sixMatchCount++;
        }
    }

    public void calculateReturnRate(int lottoNumberSize) {
        float inputAmount = lottoNumberSize * LOTTO_PRICE;
        this.returnRate = this.totalWinningAmount / inputAmount;
    }

    public int getThreeMatchCount() {
        return threeMatchCount;
    }

    public int getFourMatchCount() {
        return fourMatchCount;
    }

    public int getFiveMatchCount() {
        return fiveMatchCount;
    }

    public int getSixMatchCount() {
        return sixMatchCount;
    }

    // 테스트 코드에서 사용하기 위해 작성
    protected int getTotalWinningAmount() {
        return totalWinningAmount;
    }

    public float getReturnRate() {
        return returnRate;
    }

}

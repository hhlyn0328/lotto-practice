package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTotalResult {

    private int threeMatchCount = 0;
    private int fourMatchCount = 0;
    private int fiveMatchCount = 0;
    private int sixMatchCount = 0;
    private int totalWinningAmount = 0;
    private float returnRate;

    public LottoTotalResult(LottoWinnerNumber lottoWinnerNumber, LottoNumbers lottoNumbers) {
        calculateReturnRate(calculateMatchCounts(lottoWinnerNumber, lottoNumbers));
    }

    private List<LottoResult> calculateMatchCounts(LottoWinnerNumber lottoWinnerNumber, LottoNumbers lottoNumbers) {
        List<LottoResult> lottoResultList = new ArrayList<>();
        for (LottoNumber lottoNumber : lottoNumbers.getLottoNumbers()) {

            LottoResult lottoResult = new LottoResult(lottoWinnerNumber, lottoNumber);
            lottoResultList.add(lottoResult);

            calculateTotalWinningAmount(lottoResult);
            calculateMatchCount(lottoResult);
        }
        return lottoResultList;
    }

    private void calculateTotalWinningAmount(LottoResult lottoResult) {
        this.totalWinningAmount += lottoResult.getWinningAmount();
    }

    private void calculateMatchCount(LottoResult lottoResult) {
        if (lottoResult.getMatchCount() == 3) {
            this.threeMatchCount++;
        }

        if (lottoResult.getMatchCount() == 4) {
            this.fourMatchCount++;
        }

        if (lottoResult.getMatchCount() == 5) {
            this.fiveMatchCount++;
        }

        if (lottoResult.getMatchCount() == 6) {
            this.sixMatchCount++;
        }
    }

    private void calculateReturnRate(List<LottoResult> lottoResultList) {
        float inputAmount = lottoResultList.size() * 1000;
        float result = this.totalWinningAmount / inputAmount;
        this.returnRate = (float) (Math.floor(result * 100) / 100);

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

    public float getReturnRate() {
        return returnRate;
    }


}

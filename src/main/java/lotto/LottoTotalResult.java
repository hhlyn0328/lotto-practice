package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTotalResult {

    private int threeMatchCount = 0;
    private int fourMatchCount = 0;
    private int fiveMatchCount = 0;
    private int sixMatchCount = 0;
    private float returnRate;

    public LottoTotalResult(List<Integer> winnerNumber, LottoNumbers lottoNumbers) {
        List<LottoResult> lottoResultList = new ArrayList<>();
        initMatchCounts(winnerNumber, lottoNumbers, lottoResultList);
        initReturnRate(lottoResultList);
    }

    private void initMatchCounts(List<Integer> winnerNumber, LottoNumbers lottoNumbers, List<LottoResult> lottoResultList) {
        for (LottoNumber lottoNumber : lottoNumbers.getLottoNumbers()) {

            LottoResult lottoResult = new LottoResult(winnerNumber, lottoNumber);
            lottoResultList.add(lottoResult);

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
    }

    private void initReturnRate(List<LottoResult> lottoResultList) {
        float totalWinningAmount = lottoResultList.stream().mapToInt(LottoResult::getWinningAmount).sum();
        float inputAmount = lottoResultList.size() * 1000;
        float result = totalWinningAmount / inputAmount;
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

package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {

    public static final int LOTTO_PRICE = 1000;

    private List<LottoNumber> lottoNumbers = new ArrayList<>();

    // 테스트 코드 작성하기 위해서 생성
    public LottoNumbers() {
    }

    public LottoNumbers(int inputAmount) {
        validationInputAmount(inputAmount);
        createLottoNumbers(inputAmount);
    }

    private void validationInputAmount(int inputAmount) {
        if (inputAmount < 1000) {
            throw new IllegalArgumentException();
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public void setLottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public void createLottoNumbers(int inputCash) {

        int lottoCount = inputCash / LOTTO_PRICE;

        for (int i = 0; i < lottoCount; i++) {
            this.lottoNumbers.add(new LottoNumber());
        }

    }

}

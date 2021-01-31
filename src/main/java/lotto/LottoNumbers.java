package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LottoNumbers {

    public static final int LOTTO_PRICE = 1000;

    private List<LottoNumber> lottoNumbers = new ArrayList<>();

    // 테스트 코드 작성하기 위해서 생성
    protected LottoNumbers() {
    }

    // 테스트 코드 작성하기 위해서 생성
    protected LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers(int inputAmount, int manualLottoNumberCount, List<LottoNumber> manualLottoNumbers) {
        validateInputAmount(inputAmount);
        validateManualLottoNumber(manualLottoNumberCount, manualLottoNumbers);
        createLottoNumbers(inputAmount, manualLottoNumberCount, manualLottoNumbers);
    }

    private void validateManualLottoNumber(int manualLottoNumberCount, List<LottoNumber> manualLottoNumbers) {
        List<LottoNumber> nullableManualLottoNumbers = Optional.ofNullable(manualLottoNumbers).orElseThrow(IllegalArgumentException::new);

        if (manualLottoNumberCount != nullableManualLottoNumbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateInputAmount(int inputAmount) {
        if (inputAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException();
        }
    }

    public void createLottoNumbers(int inputCash, int manualLottoNumberCount, List<LottoNumber> manualLottoNumbers) {
        int autoLottoCount = inputCash / LOTTO_PRICE - manualLottoNumberCount;
        addAutoLottoNumber(autoLottoCount);
        addManualLottoNumber(manualLottoNumberCount, manualLottoNumbers);
    }

    private void addManualLottoNumber(int manualLottoNumberCount, List<LottoNumber> manualLottoNumbers) {
        for (int j = 0; j < manualLottoNumberCount; j++) {
            this.lottoNumbers.add(manualLottoNumbers.get(j));
        }
    }

    private void addAutoLottoNumber(int autoLottoCount) {
        for (int i = 0; i < autoLottoCount; i++) {
            this.lottoNumbers.add(LottoNumberGenerator.createLottoNumber());
        }
    }

    public LottoTotalResult calculateMatchCountAndRate(LottoWinnerNumber lottoWinnerNumber) {

        List<LottoResult> lottoResults = this.lottoNumbers.stream()
                .map(lottoWinnerNumber::matchCount)
                .collect(Collectors.toList());

        return new LottoTotalResult(lottoResults);
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers;
    }

}

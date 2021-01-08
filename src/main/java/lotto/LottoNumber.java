package lotto;

import java.util.List;

public class LottoNumber {

    private List<Integer> lottoNumber;

    public LottoNumber() {
        this.lottoNumber = LottoNumberGenerator.createLottoNumber();
    }

    // 테스트 코드 작성하기 위해서 생성
    public LottoNumber(List<Integer> lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }

    public boolean isContains(LottoNumber lottoNumber, Integer i) {
        return lottoNumber.getLottoNumber().contains(i);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }
}

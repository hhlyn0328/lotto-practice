package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoNumber {
    public static final List<Integer> LOTTO_BASE_NUMBER = Arrays.asList(
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
            31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
            41, 42, 43, 44, 45);

    List<Integer> lottoNumber = new ArrayList<>();

    public LottoNumber() {
        createLottoNumber();
    }

    // 테스트 코드 작성하기 위해서 setter 생성
    public void setLottoNumber(List<Integer> lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }

    private void createLottoNumber() {

        Collections.shuffle(LOTTO_BASE_NUMBER);

        for (int i = 0; i < 6; i++) {
            this.lottoNumber.add(LOTTO_BASE_NUMBER.get(i));
        }

        Collections.sort(this.lottoNumber);
    }


}

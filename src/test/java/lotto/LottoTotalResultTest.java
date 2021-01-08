package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTotalResultTest {

    private List<Integer> winnerLottoNumber;
    private LottoNumbers lottoNumbers = new LottoNumbers();

    @BeforeEach
    void setUp() {
        this.winnerLottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);

        LottoNumber lottoNumber = new LottoNumber();
        lottoNumber.setLottoNumber(Arrays.asList(8, 21, 23, 41, 42, 43));

        LottoNumber lottoNumber1 = new LottoNumber();
        lottoNumber1.setLottoNumber(Arrays.asList(3, 5, 11, 16, 32, 38));

        LottoNumber lottoNumber2 = new LottoNumber();
        lottoNumber2.setLottoNumber(Arrays.asList(7, 11, 16, 35, 36, 44));

        LottoNumber lottoNumber3 = new LottoNumber();
        lottoNumber3.setLottoNumber(Arrays.asList(1, 8, 11, 31, 41, 42));

        LottoNumber lottoNumber4 = new LottoNumber();
        lottoNumber4.setLottoNumber(Arrays.asList(13, 14, 16, 38, 42, 45));

        LottoNumber lottoNumber5 = new LottoNumber();
        lottoNumber5.setLottoNumber(Arrays.asList(7, 11, 30, 40, 42, 43));

        LottoNumber lottoNumber6 = new LottoNumber();
        lottoNumber6.setLottoNumber(Arrays.asList(2, 13, 22, 32, 38, 45));

        LottoNumber lottoNumber7 = new LottoNumber();
        lottoNumber7.setLottoNumber(Arrays.asList(23, 25, 33, 36, 39, 41));

        LottoNumber lottoNumber8 = new LottoNumber();
        lottoNumber8.setLottoNumber(Arrays.asList(1, 3, 5, 14, 22, 45));

        LottoNumber lottoNumber9 = new LottoNumber();
        lottoNumber9.setLottoNumber(Arrays.asList(5, 9, 38, 41, 43, 44));

        LottoNumber lottoNumber10 = new LottoNumber();
        lottoNumber10.setLottoNumber(Arrays.asList(2, 8, 9, 18, 19, 21));

        LottoNumber lottoNumber11 = new LottoNumber();
        lottoNumber11.setLottoNumber(Arrays.asList(13, 14, 18, 21, 23, 35));

        LottoNumber lottoNumber12 = new LottoNumber();
        lottoNumber12.setLottoNumber(Arrays.asList(17, 21, 29, 37, 42, 45));

        LottoNumber lottoNumber13 = new LottoNumber();
        lottoNumber13.setLottoNumber(Arrays.asList(3, 8, 27, 30, 35, 44));

        this.lottoNumbers.setLottoNumbers(Arrays.asList(
                lottoNumber,
                lottoNumber1,
                lottoNumber2,
                lottoNumber3,
                lottoNumber4,
                lottoNumber5,
                lottoNumber6,
                lottoNumber7,
                lottoNumber8,
                lottoNumber9,
                lottoNumber10,
                lottoNumber11,
                lottoNumber12,
                lottoNumber13
        ));
    }

    @Test
    void 수익률_계산_테스트() {
        LottoTotalResult lottoTotalResult = new LottoTotalResult(this.winnerLottoNumber, this.lottoNumbers);
        assertThat(lottoTotalResult.getReturnRate()).isEqualTo(0.35f);
    }

    @Test
    void 일치하는_개수_테스트() {
        LottoTotalResult lottoTotalResult = new LottoTotalResult(this.winnerLottoNumber, this.lottoNumbers);
        assertThat(lottoTotalResult.getThreeMatchCount()).isEqualTo(1);
        assertThat(lottoTotalResult.getFourMatchCount()).isEqualTo(0);
        assertThat(lottoTotalResult.getFiveMatchCount()).isEqualTo(0);
        assertThat(lottoTotalResult.getSixMatchCount()).isEqualTo(0);
    }
}

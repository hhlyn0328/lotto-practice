package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTotalResultTest {

    private LottoWinnerNumber lottoWinnerNumber;
    private LottoNumbers lottoNumbers = new LottoNumbers();

    @BeforeEach
    void setUp() {
        this.lottoWinnerNumber = new LottoWinnerNumber(Arrays.asList(1, 2, 3, 4, 5, 6));

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(Arrays.asList(8, 21, 23, 41, 42, 43)));
        lottoNumbers.add(new LottoNumber(Arrays.asList(3, 5, 11, 16, 32, 38)));
        lottoNumbers.add(new LottoNumber(Arrays.asList(7, 11, 16, 35, 36, 44)));
        lottoNumbers.add(new LottoNumber(Arrays.asList(1, 8, 11, 31, 41, 42)));
        lottoNumbers.add(new LottoNumber(Arrays.asList(13, 14, 16, 38, 42, 45)));
        lottoNumbers.add(new LottoNumber(Arrays.asList(7, 11, 30, 40, 42, 43)));
        lottoNumbers.add(new LottoNumber(Arrays.asList(2, 13, 22, 32, 38, 45)));
        lottoNumbers.add(new LottoNumber(Arrays.asList(23, 25, 33, 36, 39, 41)));
        lottoNumbers.add(new LottoNumber(Arrays.asList(1, 3, 5, 14, 22, 45)));
        lottoNumbers.add(new LottoNumber(Arrays.asList(5, 9, 38, 41, 43, 44)));
        lottoNumbers.add(new LottoNumber(Arrays.asList(2, 8, 9, 18, 19, 21)));
        lottoNumbers.add(new LottoNumber(Arrays.asList(13, 14, 18, 21, 23, 35)));
        lottoNumbers.add(new LottoNumber(Arrays.asList(17, 21, 29, 37, 42, 45)));
        lottoNumbers.add(new LottoNumber(Arrays.asList(3, 8, 27, 30, 35, 44)));
        this.lottoNumbers = new LottoNumbers(lottoNumbers);
    }

    @Test
    void 수익률_계산_테스트() {
        LottoTotalResult lottoTotalResult = lottoNumbers.calculateMatchCountAndRate(this.lottoWinnerNumber);
        assertThat(String.format("%.2f",lottoTotalResult.getReturnRate())).isEqualTo("0.36");
    }

    @Test
    void 일치하는_개수_테스트() {
        LottoTotalResult lottoTotalResult = lottoNumbers.calculateMatchCountAndRate(this.lottoWinnerNumber);
        assertThat(lottoTotalResult.getThreeMatchCount()).isEqualTo(1);
        assertThat(lottoTotalResult.getFourMatchCount()).isEqualTo(0);
        assertThat(lottoTotalResult.getFiveMatchCount()).isEqualTo(0);
        assertThat(lottoTotalResult.getSixMatchCount()).isEqualTo(0);
    }
}

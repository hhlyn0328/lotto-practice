package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoWinnerNumberTest {

    @Test
    void 로또가능값_0부터45가_아닌경우_Exception테스트() {

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LottoWinnerNumber(Arrays.asList(0, 2, 3, 4, 5, 6),7);
        });

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LottoWinnerNumber(Arrays.asList(1, 2, 3, 4, 5, 46),7);
        });
    }

    @Test
    void 번호가_중복인경우_Exception테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LottoWinnerNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 6);
        });
    }

    @Test
    void 당첨번호랑_로또번호랑_몇개_일치하는지_체크() {
        LottoWinnerNumber lottoWinnerNumber = new LottoWinnerNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        LottoNumber lottoNumber = new LottoNumber(Arrays.asList(6, 5, 4, 45, 2, 1));

        assertThat(lottoWinnerNumber.matchCount(lottoNumber).getLottoRank().getCountOfMatch()).isEqualTo(5);
    }
}

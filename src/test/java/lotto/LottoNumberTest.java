package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoNumberTest {

    @Test
    public void 랜덤_6자리_생성_테스트() {
        LottoNumber lottoNumber = LottoNumberGenerator.createLottoNumber();
        assertThat(lottoNumber.getLottoNumber().size()).isEqualTo(6);
    }


    @Test
    void 로또가능값_0부터45가_아닌경우_Exception테스트() {

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LottoNumber(Arrays.asList(0, 2, 3, 4, 5, 6));
        });

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 46));
        });
    }

    @Test
    void 번호가_중복인경우_Exception테스트() {

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LottoNumber(Arrays.asList(1, 1, 3, 4, 5, 6));
        });

    }

    @Test
    void 번호가_6자리_Exception테스트() {

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LottoNumber(Arrays.asList(1));
        });

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LottoNumber(Arrays.asList(1, 2));
        });

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LottoNumber(Arrays.asList(1, 2, 3));
        });

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LottoNumber(Arrays.asList(1, 2, 3, 4));
        });

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LottoNumber(Arrays.asList(1, 2, 3, 4, 5));
        });

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        });

    }
}

package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoWinnerNumberTest {

    @Test
    void 로또가능값_0부터45가_아닌경우_Exception테스트() {

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LottoWinnerNumber(Arrays.asList(0, 2, 3, 4, 5, 6));
        });

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LottoWinnerNumber(Arrays.asList(0, 2, 3, 4, 5, 46));
        });
    }
}

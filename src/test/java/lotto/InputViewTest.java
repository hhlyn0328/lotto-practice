package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class InputViewTest {

    @Test
    void 로또가능값_0부터45가_아닌경우_Exception테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            InputView.isOneToFortyFiveNumber(0);
        });

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            InputView.isOneToFortyFiveNumber(46);
        });
    }
}

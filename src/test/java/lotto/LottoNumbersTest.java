package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoNumbersTest {

    @Test
    public void 로또_구매_테스트() {
        LottoNumbers lottoNumbers = new LottoNumbers(14000);
        assertThat(lottoNumbers.getLottoNumbers().size()).isEqualTo(14);
    }

    @Test
    public void 로또_1000원미만_입력시_Exception_테스트() throws Exception {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LottoNumbers(999);
        });
    }


}

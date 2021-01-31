package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoNumbersTest {

    @Test
    public void 로또_구매_테스트() {
        List<LottoNumber> manualLottoNumbers =
                Arrays.asList(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new LottoNumber(Arrays.asList(7, 8, 9, 10, 11, 12)),
                new LottoNumber(Arrays.asList(13, 14, 15, 16, 17, 18))
        );

        LottoNumbers lottoNumbers = new LottoNumbers(14000, 3, manualLottoNumbers);
        assertThat(lottoNumbers.getLottoNumbers().size()).isEqualTo(14);
    }

    @Test
    public void 수동번호_입력안했을시_로또번호_생성_테스() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LottoNumbers(14000, 3, null);
        });
    }

    @Test
    public void 로또_1000원미만_입력시_Exception_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LottoNumbers(999, 0, null);
        });
    }


}

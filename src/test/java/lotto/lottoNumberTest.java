package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class lottoNumberTest {
    @Test
    void lotto_45개_test() {
        // 1장 구매시 6개의 숫자가 생성되었는지
        LottoNumber lottoNumber = new LottoNumber();

        assertThat(lottoNumber.getLottoNumbers().size()).isEqualTo(45);
        assertThat(lottoNumber.getLottoNumbers().get(0)).isEqualTo(1);
        assertThat(lottoNumber.getLottoNumbers().get(44)).isEqualTo(45);

    }

}

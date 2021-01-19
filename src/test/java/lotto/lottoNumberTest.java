package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class lottoNumberTest {
    @Test
    void lottoNumber_1_45사이_숫자_test() {
        //1~45 사이의 숫자인지
        LottoNumber lottoNumber = new LottoNumber();
        assertThat(lottoNumber.getLottoNumbers().size()).isEqualTo(45);
        assertThat(lottoNumber.getLottoNumbers().get(0)).isEqualTo(1);
        assertThat(lottoNumber.getLottoNumbers().get(44)).isEqualTo(45);

    }


}

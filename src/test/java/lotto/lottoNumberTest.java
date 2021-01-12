package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class lottoNumberTest {
    @Test
    void lottoNumber_1_45사이_숫자_test() {
        //1~45 사이의 숫자인지
        LottoNumber lottoNumber = new LottoNumber();
        assertThat(lottoNumber.getLottoNumbers().size()).isEqualTo(45);
        assertThat(lottoNumber.getLottoNumbers().get(0)).isEqualTo(1);
        assertThat(lottoNumber.getLottoNumbers().get(44)).isEqualTo(45);

    }

    @Test
    void lottoNumber_6개_숫자_test() {
        LottoNumber lottoNumber = new LottoNumber();
        assertThat(lottoNumber.getLottoNumbers().size()).isEqualTo(6);
    }

}

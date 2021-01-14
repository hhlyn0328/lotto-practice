package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
        List<Integer> ll = Arrays.asList(1,2,3,4,5) ;
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Lotto(ll).validNumberSize();
        });

    }

    @Test
    void lottoNumber_중복숫자_test() {
        List<Integer> ll = Arrays.asList(1,1,2,3,4,5) ;
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Lotto(ll).notDupulicateNumber();
        });
    }

    @Test
    void lottoNumber_바운더리숫자_test() {
        List<Integer> ll = Arrays.asList(0,0,1,2,3,0) ;
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Lotto(ll).validRangeNumber();
        });

    }
}

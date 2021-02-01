package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class lottoNumberTest {
    @Test
    void lottoNumber_6개_숫자_test() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Lotto(Arrays.asList(
                    new LottoNo(1),
                    new LottoNo(2),
                    new LottoNo(3),
                    new LottoNo(4),
                    new LottoNo(5))).idValidNumberSize();
        });
    }

    @Test
    void lottoNumber_중복숫자_test() {
        List<Integer> ll = Arrays.asList(1,1,2,3,4,5) ;
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Lotto(Arrays.asList(
                    new LottoNo(1),
                    new LottoNo(1),
                    new LottoNo(2),
                    new LottoNo(3),
                    new LottoNo(4),
                    new LottoNo(5))).isDupulicationNumber();
        });
    }


}

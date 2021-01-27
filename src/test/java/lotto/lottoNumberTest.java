package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class lottoNumberTest {
    @Test
    void lottoNumber_6개_숫자_test() {
        List<Integer> ll = Arrays.asList(1,2,3,4,5) ;
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Lotto(ll).idValidNumberSize();
        });
    }

    @Test
    void lottoNumber_중복숫자_test() {
        List<Integer> ll = Arrays.asList(1,1,2,3,4,5) ;
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Lotto(ll).isDupulicationNumber();
        });
    }

    @Test
    void lottoNumber_바운더리숫자_test() {
        List<Integer> ll = Arrays.asList(0,0,1,2,3,0) ;
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Lotto(ll).isValidRangeNumber();
        });

    }

}

package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoNumberTest {

    @Test
    public void NUll로_생성_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LottoNumber(null);
        });
    }


    @Test
    public void 랜덤_6자리_생성_테스트() {
        LottoNumber lottoNumber = LottoNumberGenerator.createLottoNumber();
        assertThat(lottoNumber.getLottoNumber().size()).isEqualTo(6);
    }


    @Test
    void 로또가능값_0부터45가_아닌경우_Exception테스트() {

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LottoNumber(Arrays.asList(0, 2, 3, 4, 5, 6));
        });

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 46));
        });
    }

    @Test
    void 번호가_중복인경우_Exception테스트() {

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LottoNumber(Arrays.asList(1, 1, 3, 4, 5, 6));
        });

    }

    @ParameterizedTest
    @MethodSource("generateData")
    void 번호가_6자리_Exception테스트(List<Integer> numbers) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LottoNumber(numbers);
        });
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1)),
                Arguments.of(Arrays.asList(1, 2)),
                Arguments.of(Arrays.asList(1, 2, 3)),
                Arguments.of(Arrays.asList(1, 2, 3, 4)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
                );
    }

    @Test
    void 당첨번호랑_로또번호랑_몇개_일치하는지_체크() {
        LottoNumber lottoWinnerNumber = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber lottoNumber = new LottoNumber(Arrays.asList(6, 5, 4, 45, 2, 1));

        assertThat(lottoNumber.matchCount(lottoWinnerNumber)).isEqualTo(5);
    }


}

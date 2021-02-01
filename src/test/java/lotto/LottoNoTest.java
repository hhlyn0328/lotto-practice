package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoNoTest {
    Lotto winnerNumber;
    @BeforeEach
    void init() {
        winnerNumber = new Lotto(Arrays.asList(
                new LottoNo(1),
                new LottoNo(2),
                new LottoNo(3),
                new LottoNo(4),
                new LottoNo(5),
                new LottoNo(6)));
    }

    @Test
    void lottoNo_1_45_범위숫자_아니면_test() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LottoNo(46).isNotRangeNumber();
        });

    }

    @Test
    void lottoNo_당첨번호와_보너스번호가_중복이면_test() {

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LottoNo(winnerNumber,2);
        });
    }

    @Test
    void serviceNumber_보너스번호와_일치_test() {
        LottoNo bonusNumber = new LottoNo(winnerNumber,7);
        boolean isMatchingServiceNumber = bonusNumber.isMatchingBonus(7);

        assertThat(isMatchingServiceNumber).isTrue();

    }
}

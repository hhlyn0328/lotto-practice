package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class BonusNumberTest {
    @Test
    void serviceNumber_음수_test() {

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new BonusNumber(-1);
        });
    }

    @Test
    void serviceNumber_1_45_범위가아닌_test() {

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new BonusNumber(46);
        });
    }

    @Test
    void serviceNumber_로또번호와_중복_test() {
        BonusNumber bonusNumber = new BonusNumber(3);
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            bonusNumber.isDupulicationNumber(lotto);
        });

    }

    @Test
    void serviceNumber_서비스번호와_일치_test() {
        BonusNumber bonusNumber = new BonusNumber(7);
        boolean isMatchingServiceNumber = bonusNumber.isMatchingBonus(7);

        assertThat(isMatchingServiceNumber).isTrue();

    }

}

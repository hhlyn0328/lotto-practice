package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class BonusNumberTest {
    Lotto winnerNumber;
    @BeforeEach
    void init() {
        winnerNumber = new Lotto(Arrays.asList(1,2,3,4,5,6));
    }


    @Test
    void serviceNumber_1_45_범위가아닌_test() {

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new BonusNumber(winnerNumber,46);
        });
    }

    @Test
    void serviceNumber_로또번호와_중복_test() {
        BonusNumber bonusNumber = new BonusNumber(winnerNumber,1);
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            bonusNumber.isDupulicationNumber(lotto);
        });

    }

    @Test
    void serviceNumber_서비스번호와_일치_test() {
        BonusNumber bonusNumber = new BonusNumber(winnerNumber,7);
        boolean isMatchingServiceNumber = bonusNumber.isMatchingBonus(7);

        assertThat(isMatchingServiceNumber).isTrue();

    }

}

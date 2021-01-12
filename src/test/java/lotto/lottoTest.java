package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class lottoTest {

    @Test
    void lotto_1게임_숫자6개_test() {
        // 1장 구매시 6개의 숫자가 생성되었는지
        Lotto lotto = new Lotto();
        assertThat(lotto.getLotto().size()).isEqualTo(6);

    }

    @Test
    void lotto_3개일치_Test() {
        List<Integer> ll = Arrays.asList(0,0,1,2,3,0) ;

        Lotto lotto = new Lotto(ll);
        Lotto lottoWinningNumber = new Lotto(Arrays.asList(1,2,3,4,5,6));

        long score = lotto.matching(lottoWinningNumber);

        assertThat(score).isEqualTo(3);

    }

    @Test
    void lotto_숫자중복_test() {
        List<Integer> ll = Arrays.asList(0,0,1,2,3,0) ;
        Lotto lotto = new Lotto(ll);

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            lotto.duplicationNumber();
        });
    }


}

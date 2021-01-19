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
        List<Integer> ll = Arrays.asList(7,8,1,2,3,9) ;

        Lotto lotto = new Lotto(ll);
        Lotto lottoWinningNumber = new Lotto(Arrays.asList(1,2,3,4,5,6));

        Reward reward = lotto.matching(lottoWinningNumber);

        assertThat(Reward.scoreOfReward(reward)).isEqualTo(3);

    }

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

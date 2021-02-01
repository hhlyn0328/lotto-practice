package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class lottoTest {
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
    void lotto_1게임_숫자6개_test() {
        // 1장 구매시 6개의 숫자가 생성되었는지
        Lotto lotto = new Lotto();
        assertThat(lotto.getLotto().size()).isEqualTo(6);
    }

    @Test
    void lotto_3개일치_Test() {
        Lotto lotto = new Lotto(Arrays.asList(
                new LottoNo(2),
                new LottoNo(4),
                new LottoNo(6),
                new LottoNo(10),
                new LottoNo(12),
                new LottoNo(14)));

        Reward reward = lotto.matching(winnerNumber, new LottoNo(winnerNumber,7));

        assertThat(Reward.valueOfScore(reward)).isEqualTo(3);

    }

    @Test
    void lotto_5등_보너스번호_일치_test() {
        Lotto lotto = new Lotto(Arrays.asList(
                new LottoNo(1),
                new LottoNo(2),
                new LottoNo(4),
                new LottoNo(5),
                new LottoNo(6),
                new LottoNo(7)));

        Reward reward = lotto.matching(winnerNumber, new LottoNo(winnerNumber,7));

        assertThat(Reward.valueOfScore(reward)).isEqualTo(5);
        assertThat(Reward.valueOfAmount(reward)).isEqualTo(30000000);

    }

    @Test
    void lotto_5등_보너스번호_일치하지않음_test() {
        Lotto lotto = new Lotto(Arrays.asList(
                new LottoNo(1),
                new LottoNo(2),
                new LottoNo(4),
                new LottoNo(5),
                new LottoNo(6),
                new LottoNo(8)));

        Reward reward = lotto.matching(winnerNumber, new LottoNo(winnerNumber,7));

        assertThat(Reward.valueOfScore(reward)).isEqualTo(5);
        assertThat(Reward.valueOfAmount(reward)).isEqualTo(1500000);

    }




}

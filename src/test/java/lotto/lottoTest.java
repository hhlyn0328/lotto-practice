package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class lottoTest {

    @Test
    void game_1게임_6개숫자_test() {
        // 1장 구매시 6개의 숫자가 생성되었는지
        Lotto lotto = new Lotto();
        lotto.startGame();
        assertThat(lotto.getLottoGame().size()).isEqualTo(6);

    }

    @Test
    void game_3개일치가_1개_Test() {

    }

    @Test
    void game_3개일치가_2개_4개일치가_1개_Test() {

    }
}

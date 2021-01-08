package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class lottoGamesTest {

    @Test
    void game_2게임_6개숫자_test() {
        // 2장 구매시 각 6개의 숫자가 생성되었는지
        LottoGames lottoGames = new LottoGames(2);
        lottoGames.startGames();

        int game1Size = lottoGames.getLottoGames().get(0).getLottoGame().size();
        int game2Size = lottoGames.getLottoGames().get(1).getLottoGame().size();

        assertThat(game1Size).isEqualTo(6);
        assertThat(game2Size).isEqualTo(6);
    }
}

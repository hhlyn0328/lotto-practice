package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class lottoGamesTest {
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
    void game_2게임_숫자6개_test() {
        // 2장 구매시 각 6개의 숫자가 생성되었는지
        LottoGame lottoGame = new LottoGame(new Price(2000));

        int game1Size = lottoGame.getLottoGames().get(0).getLotto().size();
        int game2Size = lottoGame.getLottoGames().get(1).getLotto().size();

        assertThat(game1Size).isEqualTo(6);
        assertThat(game2Size).isEqualTo(6);
    }

    @Test
    void game_3게임_3개일치_4개일치_Test() {

        Lotto lotto1 = new Lotto(Arrays.asList(
                new LottoNo(1),
                new LottoNo(8),
                new LottoNo(10),
                new LottoNo(2),
                new LottoNo(3),
                new LottoNo(9)));
        Lotto lotto2 = new Lotto(Arrays.asList(
                new LottoNo(7),
                new LottoNo(8),
                new LottoNo(9),
                new LottoNo(10),
                new LottoNo(11),
                new LottoNo(12)));
        Lotto lotto3 = new Lotto(Arrays.asList(
                new LottoNo(1),
                new LottoNo(2),
                new LottoNo(8),
                new LottoNo(4),
                new LottoNo(9),
                new LottoNo(6)));
        List<Lotto> lottoList = Arrays.asList(lotto1, lotto2, lotto3);

        LottoGame lottoGame = new LottoGame(lottoList, new Price(3000));


        LottoResult aa =  lottoGame.matching(winnerNumber,new LottoNo(winnerNumber,7));

        assertThat(aa.getResult().get(Reward.FIFTH)).isEqualTo(1L);
        assertThat(aa.getResult().get(Reward.FOURTH)).isEqualTo(1L);

    }


}

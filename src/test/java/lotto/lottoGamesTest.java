package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class lottoGamesTest {

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
        List<Integer> lt1 = Arrays.asList(1,8,10,2,3,9) ;
        List<Integer> lt2 = Arrays.asList(7,8,9,10,11,12) ;
        List<Integer> lt3 = Arrays.asList(1,2,8,4,9,6) ;

        Lotto lotto1 = new Lotto(lt1);
        Lotto lotto2 = new Lotto(lt2);
        Lotto lotto3 = new Lotto(lt3);
        List<Lotto> lottoList = Arrays.asList(lotto1, lotto2, lotto3);

        LottoGame lottoGame = new LottoGame(lottoList, new Price(3000));

        Lotto lottoWinningNumber = new Lotto(Arrays.asList(1,2,3,4,5,6)) ;

        LottoResult aa =  lottoGame.matching(lottoWinningNumber);

        assertThat(aa.getResult().get(Reward.SCORE_3)).isEqualTo(1L);
        assertThat(aa.getResult().get(Reward.SCORE_4)).isEqualTo(1L);

    }


}

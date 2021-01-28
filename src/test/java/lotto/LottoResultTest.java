package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    void 당첨번호랑_로또번호랑_몇개_일치하는지_체크() {
//        LottoWinnerNumber lottoWinnerNumber = new LottoWinnerNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
//        LottoNumber lottoNumber = new LottoNumber(Arrays.asList(6, 5, 4, 45, 2, 1));
//        LottoResult lottoResult = lottoWinnerNumber.matchCount(lottoNumber);
//
//        assertThat(lottoResult.getLottoRank()).isEqualTo(LottoRank.THIRD);
//        assertThat(lottoResult.getWinningAmount()).isEqualTo(LottoRank.THIRD.getWinningMoney());

        LottoWinnerNumber lottoWinnerNumber1 = new LottoWinnerNumber(Arrays.asList(1, 2, 3, 43, 44, 45), 4);
        LottoNumber lottoNumber1 = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoResult lottoResult1 = lottoWinnerNumber1.matchCount(lottoNumber1);

        assertThat(lottoResult1.getLottoRank()).isEqualTo(LottoRank.FIFTH);
    }

}

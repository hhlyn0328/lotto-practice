package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    void 당첨번호랑_로또번호랑_몇개_일치하는지_체크() {
        List<Integer> winnerLottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);

        LottoNumber lottoNumber = new LottoNumber();
        lottoNumber.setLottoNumber(Arrays.asList(6, 5, 4, 45, 2, 1));

        LottoResult lottoResult = new LottoResult(winnerLottoNumber, lottoNumber);
        assertThat(lottoResult.getMatchCount()).isEqualTo(5);
    }

}

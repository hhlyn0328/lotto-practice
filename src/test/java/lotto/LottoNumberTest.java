package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    @Test
    public void 랜덤_6자리_생성_테스트() {
        LottoNumber lottoNumber = new LottoNumber();
        assertThat(lottoNumber.getLottoNumber().size()).isEqualTo(6);
    }

}

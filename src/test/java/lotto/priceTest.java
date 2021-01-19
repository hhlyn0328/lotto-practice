package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class priceTest {
    @Test
    void price_천원미만_test() {
        //1000원 미만의 금이면 예외
        assertThatThrownBy(() -> new Price(900));
    }

    @Test
    void price_로또개수_test() {
        //입력한 금액 /1000 의 몫만큼 로또개수가 일치하는지
        Price price = new Price(10000);
        assertThat(price.getLottoCount()).isEqualTo(10);
    }

}

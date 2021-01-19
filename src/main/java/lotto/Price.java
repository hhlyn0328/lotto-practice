package lotto;

public class Price {
    private static final int PRICE_PER_GAME = 1000;

    private final int price;
    private final int lottoCount;

    public Price(int price) {
        checkPrice(price);
        this.price = price;
        this.lottoCount = price / PRICE_PER_GAME;
    }

    private void checkPrice(int price) {
        if(price < PRICE_PER_GAME) {
            throw new RuntimeException("최소 게임 금액은" + PRICE_PER_GAME + "원입니다. ");
        }

    }

    public int getLottoCount() {
        return lottoCount;
    }

    public long getWinningRate(long winningAmount) {
        return winningAmount / price;
    }
}

package lotto;

public class Price {
    private static final int PRICE_PER_GAME = 1000;

    private static int price;
    private int lottoCount;

    public Price(int price) {
        this.price = price;
        checkPrice(price);
        this.lottoCount = price / PRICE_PER_GAME;
    }

    private void checkPrice(int price) {
        if(price < PRICE_PER_GAME) {
            throw new RuntimeException("최소 게임 금액음 1000원입니다. ");
        }

    }

    public int getLottoCount() {
        return lottoCount;
    }

    public static int getPrice() {
        return price;
    }

}

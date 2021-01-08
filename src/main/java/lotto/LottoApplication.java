package lotto;

public class LottoApplication {
    public static void main(String[] args) {
        int lottoPrice = InputView.inputLottoPrice();

        Price price = new Price(lottoPrice);
        LottoGames lottoGames = new LottoGames(price.getLottoCount());
        lottoGames.startGames();

        ResultView.print(lottoGames);
    }
}

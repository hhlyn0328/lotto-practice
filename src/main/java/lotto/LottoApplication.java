package lotto;

public class LottoApplication {
    public static void main(String[] args) {
        int lottoPrice = InputView.inputLottoPrice();

        Price price = new Price(lottoPrice);
        LottoGame lottoGame = new LottoGame(price);

        ResultView.print(lottoGame);

        Lotto winnerNumber =  InputView.inputLastLottoNumber();

        LottoResult lottoResult = lottoGame.matching(winnerNumber);
        ResultView.printResult(lottoResult);
    }
}

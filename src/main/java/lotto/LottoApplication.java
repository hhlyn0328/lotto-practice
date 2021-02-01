package lotto;

public class LottoApplication {
    public static void main(String[] args) {
        int lottoPrice = InputView.inputLottoPrice();

        Price price = new Price(lottoPrice);
        LottoGame lottoGame = new LottoGame(price);

        ResultView.print(lottoGame);

        Lotto winnerNumber =  InputView.inputLastLottoNumber();
        LottoNo bonusNumber = InputView.inputBonusNumber(winnerNumber);

        LottoResult lottoResult = lottoGame.matching(winnerNumber, bonusNumber);
        ResultView.printResult(lottoResult);
    }
}

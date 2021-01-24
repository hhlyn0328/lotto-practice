package lotto;

public class LottoApplication {

    public static void main(String[] args) {
        LottoNumbers lottoNumbers = new LottoNumbers(InputView.scannerBuyAmount());
        ResultView.printLottoNumber(lottoNumbers);

        LottoWinnerNumber lottoWinnerNumber = InputView.scannerLastWeekLottoNumber();
        LottoTotalResult lottoTotalResult = lottoNumbers.calculateMatchCountAndRate(lottoWinnerNumber);
        ResultView.printMatchCount(lottoTotalResult);
    }

}

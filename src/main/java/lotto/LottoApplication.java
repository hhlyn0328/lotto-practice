package lotto;

public class LottoApplication {

    public static void main(String[] args) {
        LottoNumbers lottoNumbers = new LottoNumbers(InputView.scannerBuyAmount());
        ResultView.printLottoNumber(lottoNumbers);

        LottoTotalResult lottoTotalResult = lottoNumbers.calculateMatchCountAndRate(InputView.scannerLastWeekLottoNumber());
        ResultView.printMatchCount(lottoTotalResult);
    }

}

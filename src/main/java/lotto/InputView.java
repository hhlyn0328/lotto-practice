package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String BLANK = " ";
    private static final String NOT_BLANK = "";
    private static final String COMMA = ",";

    public static int scannerBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(SCANNER.nextLine()); // nextInt 로 하면 뒤에 nextLine 이 넘어가서 parseInt로 한번 wrapping
    }

    public static LottoWinnerNumber scannerLastWeekLottoNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return parseInt(Arrays.asList(SCANNER.nextLine().
                replaceAll(BLANK, NOT_BLANK).
                split(COMMA))
        );
    }

    private static LottoWinnerNumber parseInt(List<String> splitLottoNumberStrings) {
        List<Integer> splitLottoNumberIntegers = new ArrayList<>();

        for (String lottoNumber : splitLottoNumberStrings) {
            splitLottoNumberIntegers.add(Integer.parseInt(lottoNumber));
        }

        return new LottoWinnerNumber(splitLottoNumberIntegers);
    }
}

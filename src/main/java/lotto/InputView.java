package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String BLANK = " ";
    private static final String NOT_BLANK = "";
    private static final String COMMA = ",";

    public static int scannerBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(SCANNER.nextLine()); // nextInt 로 하면 뒤에 nextLine 이 넘어가서 parseInt로 한번 wrapping
    }

    public static Integer scannerBuyManualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static List<LottoNumber> scannerBuyManualLottoNumber(int manualLottoNumberCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < manualLottoNumberCount; i++) {
            lottoNumbers.add(parseLottoNumber(Arrays.asList(SCANNER.nextLine().
                    replaceAll(BLANK, NOT_BLANK).
                    split(COMMA))));
        }

        return lottoNumbers;
    }

    public static LottoWinnerNumber scannerLastWeekLottoNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return parseLottoWinnerNumber(Arrays.asList(SCANNER.nextLine().
                replaceAll(BLANK, NOT_BLANK).
                split(COMMA))
        );
    }

    public static Integer scannerLastWeekBonusLottoNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(SCANNER.nextLine());
    }

    private static LottoNumber parseLottoNumber(List<String> splitLottoNumberStrings) {
        List<Integer> splitLottoNumberIntegers = splitLottoNumberStrings.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return new LottoNumber(splitLottoNumberIntegers);
    }

    private static LottoWinnerNumber parseLottoWinnerNumber(List<String> splitLottoNumberStrings) {
        List<Integer> splitLottoNumberIntegers = splitLottoNumberStrings.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return new LottoWinnerNumber(splitLottoNumberIntegers, scannerLastWeekBonusLottoNumber());
    }
}

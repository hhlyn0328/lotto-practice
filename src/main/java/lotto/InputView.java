package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Scanner scanner1 = new Scanner(System.in);
    private static final String SPLIT_TEXT = ",";

    protected static int inputLottoPrice() {
        System.out.println("구입 금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    protected static List<String> inputLastLottoNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Arrays.asList(scanner1.nextLine().split(SPLIT_TEXT));
    }
}

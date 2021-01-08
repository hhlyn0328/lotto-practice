package lotto;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    protected static int inputLottoPrice() {
        System.out.println("구입 금액을 입력해 주세요.");
        return scanner.nextInt();
    }
}

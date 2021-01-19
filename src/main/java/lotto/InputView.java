package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String SPLIT_TEXT = ",";

    protected static int inputLottoPrice() {
        System.out.println("구입 금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    protected static Lotto inputLastLottoNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return parseLotto(scanner.nextLine().split(SPLIT_TEXT));
    }

    protected static Lotto parseLotto(String[] lottoNumber) {
        List<Integer> lottoNumbers = Arrays.stream(lottoNumber)
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }
}

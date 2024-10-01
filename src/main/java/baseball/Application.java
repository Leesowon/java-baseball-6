package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean playGame = true;

        while (playGame) {
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            playGame = playBaseBallGame(computer);
        }
    }
    private static boolean playBaseBallGame(List<Integer> computer) {
        return restartGame();
    }

    private static boolean restartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();

        if ("1".equals(input)) {
            return true;
        } else if ("2".equals(input)) {
            return false;
        } else {
            throw new IllegalArgumentException("잘못된 입력입니다. 1 또는 2를 입력해야 합니다.");
        }
    }
}




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
    private static boolean playBaseBallGame(List<Integer> computer){
        boolean isGameEnd = false;

        while(!isGameEnd){
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            List<Integer> playerInput = playerInput(input);

            if(playerInput.size() != 3) {
                throw new IllegalArgumentException("입력값이 잘못되었습니다. 3개의 서로 다른 숫자를 입력해야 합니다.");
            }

            int [] result = calculateResult(computer, playerInput);
            printResult(result);

            if(result[0] == 3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                isGameEnd = true;
            }
        }
        return restartGame();
    }

    private static List<Integer> playerInput(String input){
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다. 3자리 숫자를 입력해야 합니다.");
        }

        List<Integer> playerInput = new ArrayList<>();
        for (char c : input.toCharArray()) {
            int num = Character.getNumericValue(c);
            if (num < 1 || num > 9 || playerInput.contains(num)) {
                throw new IllegalArgumentException("입력값이 잘못되었습니다. 1부터 9까지의 서로 다른 숫자를 입력해야 합니다.");
            }
            playerInput.add(num);
        }
        return playerInput;
    }

    private static int[] calculateResult(List<Integer> computer, List<Integer> playerInput) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (computer.get(i).equals(playerInput.get(i))) {
                strikes++;
            } else if (computer.contains(playerInput.get(i))) {
                balls++;
            }
        }
        return new int[]{strikes, balls};
    }

    private static void printResult(int[] result) {
        int strikes = result[0];
        int balls = result[1];

        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
        } else {
            StringBuilder output = new StringBuilder();
            if (balls > 0) {
                output.append(balls).append("볼 ");
            }
            if (strikes > 0) {
                output.append(strikes).append("스트라이크");
            }
            System.out.println(output.toString().trim());
        }
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
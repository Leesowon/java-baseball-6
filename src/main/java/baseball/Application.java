package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        while(true) {
            System.out.print("숫자를 입력해주세요 : ");
            int num = scanner.nextInt();

            if (num < 100 || num > 999) {
                throw new IllegalArgumentException("3자리 숫자를 입력해야 합니다.");
            }

            List<Integer> user = new ArrayList<>();
            user.add(num / 100);
            user.add((num / 10) % 10);
            user.add(num % 10);
        }
    }
}




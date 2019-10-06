import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NumberBaseBallGame {

    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String CORRECT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private List<String> numberList = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
    private String answer;

    public void play() {
        Scanner sc = new Scanner(System.in);
        generateNumbers();

        while (true) {
            System.out.print(INPUT_MESSAGE);
            String guess = sc.nextLine();
            Result result = isRight(guess);
            result.print();
            if (result.isThreeStrike()) {
                System.out.println(CORRECT_MESSAGE);
                break;
            }
        }
    }

    private void generateNumbers() {
        Collections.shuffle(numberList);
        answer = numberList.get(0) + numberList.get(1) + numberList.get(2);
    }

    private Result isRight(String guess) {
        Result result = new Result();
        for (int i = 0; i < guess.length(); i ++) {
            if (answer.charAt(i) == guess.charAt(i)) {
                result.strike();
            } else if (answer.contains(String.valueOf(guess.charAt(i)))) {
                result.ball();
            }
        }
        result.checkFourBall();
        return result;
    }

    public class Result {
        private int strike;
        private int ball;

        public void strike() {
            strike++;
        }

        public void ball() {
            ball++;
        }

        public void checkFourBall() {
            if (strike == 0 && ball == 0) {
                ball = 4;
            }
        }

        public int getStrike() {
            return strike;
        }

        public int getBall() {
            return ball;
        }

        public boolean isThreeStrike() {
            return strike == 3;
        }

        public void print() {
            String result = strike > 0 ? strike + " 스트라이크 " : "";
            result = ball > 0 ? result + ball + " 볼" : result + "";
            System.out.println(result);
        }
    }
}

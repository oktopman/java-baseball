import java.util.Scanner;

public class Main {

    private static final String START_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void main(String[] args) {
        while (true) {
            new NumberBaseBallGame().play();
            if (!wannaPlay()) {
                break;
            }
        }
    }

    private static boolean wannaPlay() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(START_MESSAGE);
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    return true;
                case 2:
                    return false;
            }
        }
    }

}

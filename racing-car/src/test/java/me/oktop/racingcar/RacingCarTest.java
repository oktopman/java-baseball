package me.oktop.racingcar;

import org.junit.Test;

import java.util.Map;
import java.util.Random;

public class RacingCarTest {

    //            1. 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
//            2. 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
//            3. 자동차 이름은 쉼표(,)를 기준으로 구분하여 이름은 5자 이하만 가능하다.
//            4. 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
//            6. 전진하는 조건은 0에서 9사이에서 random값을 구한 후 random값이 4이상일 경우 전진하고, 3이하의 값이면 멈춘다.
//7. 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
    private String[] carName;

    @Test
    public void 자동차_경주_테스트() {
//        Scanner sc = new Scanner(System.in);
//        String cars = sc.nextLine();
        String cars = "avante,sonata,santafe";
        int move = 5;
        carName = cars.split(",");

        for (int i = 0; i < move; i++) {
            for (String car : carName) {
                Random random = new Random();
                int number = random.nextInt(10);
                if (number >= 4) {

                }
            }
        }

    }


}

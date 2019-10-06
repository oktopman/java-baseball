package me.oktop.racingcar.domain;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RacingCarGame {

    private static final String CAR_NAME_ANSWER = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String RACE_COUNT_ANSWER = "시도할 회수는 몇회인가요?";
    private static final String EXECUTE_RESULT = "실행결과";
    private static final String ANNOUNCE_WINNER = "가 최종 우승하였습니다.";

    private List<Car> cars = new ArrayList<>();

    public void play() {
        this.createCar();
        this.execute(this.getExecuteCount());
    }

    private void createCar() {
        System.out.println(CAR_NAME_ANSWER);
        Scanner sc = new Scanner(System.in);
        String carNames = sc.nextLine();
        String[] carNameArray = carNames.split(",");
        for (String carName : carNameArray) {
            cars.add(new Car(carName));
        }
    }

    private void execute(int count) {
        System.out.println(EXECUTE_RESULT);
        for (int i = 0; i < count; i++) {
            this.racing();
            System.out.println();
        }
        this.announceWinner();
    }

    private int getExecuteCount() {
        System.out.println(RACE_COUNT_ANSWER);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private void racing() {
        for (Car car : cars) {
            Random random = new Random();
            int number = random.nextInt(10);
            if (number >= 4) {
                car.move();
            }
            car.printDistance();
        }
    }

    private void announceWinner() {
        int winnerDistance = this.getWinnerDistance();
        System.out.println(this.calcWinner(winnerDistance) + ANNOUNCE_WINNER);
    }

    private int getWinnerDistance() {
        int winnerDistance = 0;
        for (Car car : cars) {
            if (car.getDistance().length() > winnerDistance) {
                winnerDistance = car.getDistance().length();
            }
        }
        return winnerDistance;
    }

    private String calcWinner(int distance) {
        return cars.stream()
                .filter(car -> car.getDistance().length() == distance)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
//        StringBuilder sb = new StringBuilder();
//        for (Car car : cars) {
//            if (car.getDistance().length() == distance) {
//                sb.append(car.getName()).append(",");
//            }
//        }
//        return sb.substring(0, sb.length() - 1);
    }

}

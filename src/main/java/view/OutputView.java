package view;

import domain.Car;

import java.util.List;

public class OutputView {
    public static void printResult(List<List<Car>> history) {
        for (List<Car> historyByTerm : history) {
            printResultByTerm(historyByTerm);
        }
    }

    public static void printWinners(List<Car> winnerCars) {
        List<String> winnerNames = winnerCars.stream()
                .map(Car::getName).toList();
        System.out.println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
    }

    private static void printResultByTerm(List<Car> historyByTerm) {
        for (Car car : historyByTerm) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        }
        System.out.println();
    }

}

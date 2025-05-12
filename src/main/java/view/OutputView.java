package view;

import data.CarSnapShot;
import domain.Car;

import java.util.List;

public class OutputView {

    public static void printWinners(List<String> winnerNames) {
        System.out.println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
    }

    public static void printRoundResult(List<String> formattedroundResult) {
        formattedroundResult.forEach(System.out::println);
        System.out.println();
    }

}

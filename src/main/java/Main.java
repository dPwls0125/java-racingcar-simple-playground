import domain.Car;
import domain.RacingWithCars;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] carNames = InputView.getCarNames();
        int times = InputView.getTimes();

        RacingWithCars racingWithCars = new RacingWithCars(carNames, times);
        List<List<Car>> history = racingWithCars.race();

        OutputView.printResult(history);
        OutputView.printWinners(racingWithCars.getWinner());
    }
}

import domain.RacingWithCars;
import view.InputView;
import view.OutputView;

public class Main {
    public static void main(String[] args) {
        String[] carNames = InputView.getCarNames();
        int times = InputView.getTimes();

        RacingWithCars racingWithCars = new RacingWithCars(carNames, times);
        RacingGameManager racingGameManager = new RacingGameManager(racingWithCars);

        racingGameManager.raceAndPrintRoundResults();

        OutputView.printWinners(racingGameManager.getWinnerNames());
    }
}

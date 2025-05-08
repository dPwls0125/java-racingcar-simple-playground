import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingWithCars {

    private List<Car> participatingCars;
    private int times;

    public RacingWithCars(String[] carNames, int times) {
        this.participatingCars = Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
        this.times = times;
    }

    public List<List<Car>> race() {
        List<List<Car>> history = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            participatingCars
                    .forEach(Car::move);
            history.add(deepCopiedCars());
        }
        return history;
    }

    public List<Car> getWinner() {
        int maxDistance = participatingCars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow(() -> new RuntimeException("참여중인 자동차가 없습니다."));

        return participatingCars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .collect(Collectors.toList());
    }

    private List<Car> deepCopiedCars() {
        return participatingCars
                .stream()
                .map(Car::getDeepCopy)
                .collect(Collectors.toList());
    }

}

import java.util.List;
import java.util.stream.Collectors;

public class RaceWithCars {

    private List<Car> participatingCars;

    public RaceWithCars(List<Car> participatingCars) {
        this.participatingCars = participatingCars;
    }

    public void race(int times) {
        for (int i = 0; i < times; i++) {
            participatingCars
                    .forEach(Car::move);
        }
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
}

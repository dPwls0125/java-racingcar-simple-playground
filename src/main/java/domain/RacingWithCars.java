package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingWithCars {
    private final List<Car> participatingCars;
    private final int times;

    public List<Car> getParticipatingCars() {
        return participatingCars;
    }

    public RacingWithCars(String[] carNames, int times) {
        this.participatingCars = Arrays.stream(carNames)
                .map(carName -> new Car(new CarName(carName)))
                .collect(Collectors.toList());
        this.times = times;
    }

    public List<List<Car>> race() {
        List<List<Car>> history = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            participatingCars
                    .forEach(car -> car.move(RandomNumberGenerator.getRandomNumberFrom0To9()));
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

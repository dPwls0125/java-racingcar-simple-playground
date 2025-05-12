package domain;

import data.CarSnapShot;
import data.RoundResult;
import utils.RandomNumberGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingWithCars {
    private final List<Car> participatingCars;
    private final int times;

    public RacingWithCars(String[] carNames, int times) {
        this.participatingCars = Arrays.stream(carNames)
                .map(carName -> new Car(new CarName(carName)))
                .collect(Collectors.toList());
        this.times = times;
    }

    public RoundResult raceOneRound() {
        RandomNumberGenerator numberGenerator = new RandomNumberGenerator();
        participatingCars
                .forEach(car -> car.move(numberGenerator));
        return getRoundResult();
    }

    public List<CarSnapShot> getWinner() {
        int maxDistance = participatingCars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow(() -> new RuntimeException("참여중인 자동차가 없습니다."));

        return participatingCars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(car -> new CarSnapShot(car.getName(), car.getDistance()))
                .collect(Collectors.toList());
    }

    private RoundResult getRoundResult() {
        List<CarSnapShot> roundResult = participatingCars.stream()
                .map(car -> new CarSnapShot(car.getName(), car.getDistance()))
                .collect(Collectors.toList());
        return new RoundResult(roundResult);
    }

    public List<Car> getParticipatingCars() {
        return participatingCars;
    }

    public int getTimes() {
        return times;
    }
}

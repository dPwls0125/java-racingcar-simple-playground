import domain.Car;
import domain.RacingWithCars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingWithCarsTest {
    @Test
    @DisplayName("자동차가 옳바르게 생성되는지 테스트")
    void testCarInitialization() {
        String[] carNames = {"car1", "car2", "car3"};
        RacingWithCars racing = new RacingWithCars(carNames, 5);
        List<Car> cars = racing.getParticipatingCars();
        assertThat(cars).hasSize(3)
                .extracting(Car::getName)
                .containsExactlyInAnyOrder("car1", "car2", "car3");
    }

    @ParameterizedTest(name = "레이스 히스토리가 times 만큼 쌓인다.")
    @CsvSource({"1,1", "2,2", "3,3"})
    void testRaceHistorySize(int times, int expected) {
        String[] carNames = {"car1", "car2"};
        RacingWithCars racing = new RacingWithCars(carNames, times);

        List<List<Car>> history = racing.race();

        assertThat(history).hasSize(expected);
    }

    @Test
    @DisplayName("참여한 모든 자동차에 대한 히스토리가 존재한다.")
    void testRaceHistoryContainsAllCarRecord() {
        String[] carNames = {"car1", "car2"};
        RacingWithCars racing = new RacingWithCars(carNames, 5);

        List<List<Car>> totalHistory = racing.race();

        for (List<Car> historyPerTime : totalHistory) {
            assertThat(historyPerTime).hasSize(2);
        }
    }

    @ParameterizedTest(name = "주행거리:{0}, 예상 우승자 인덱스 : {1}")
    @MethodSource("carDistancesForWinners")
    void testGetWinnerCorrectly(int[] distances, List<Integer> expectedWinnerIndexes) {
        String[] carNames = {"car1", "car2", "car3"};
        RacingWithCars racing = new RacingWithCars(carNames, 0);

        List<Car> participaintCars = racing.getParticipatingCars();
        for (int i = 0; i < 3; i++) {
            participaintCars.get(i).setDistance(distances[i]);
        }

        List<Car> winners = racing.getWinner();
        List<Car> expectedWinners = expectedWinnerIndexes.stream()
                .map(participaintCars::get)
                .collect(Collectors.toList());
        assertThat(winners)
                .containsExactlyInAnyOrderElementsOf(expectedWinners);
    }

    private static Stream<Arguments> carDistancesForWinners() {
        return Stream.of(
                Arguments.of(new int[]{5, 2, 4}, List.of(0)),
                Arguments.of(new int[]{1, 3, 3}, List.of(1, 2)),
                Arguments.of(new int[]{0, 0, 0}, List.of(0, 1, 2))
        );
    }

}

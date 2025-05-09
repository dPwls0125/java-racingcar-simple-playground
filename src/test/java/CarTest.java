import domain.Car;
import domain.CarName;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CarTest {

    @Nested
    @DisplayName("랜덤 숫자에 따른 주행 테스트")
    class moveTest {
        private Car car;

        @BeforeEach
        void setUP() {
            car = new Car(new CarName("car1"));
        }

        @ParameterizedTest(name = "random값이 4 이상일 경우 한칸 주행한다.")
        @ValueSource(ints = {4, 5, 6})
        void moveForward_whenRandomNumberIsGreaterThanOrEqualToFour(int randomNum) {
            // when
            car.move(randomNum);
            // then
            assertThat(car.getDistance()).isEqualTo(1);
        }

        @ParameterizedTest(name = "random값이 4 미만인 경우 주행하지 않는다.")
        @ValueSource(ints = {0, 1, 2})
        void stop_whenRandomNumberIsLowerThenFour(int randomNum) {
            // when
            car.move(randomNum);
            // then
            assertThat(car.getDistance()).isEqualTo(0);
        }

        @Test
        @DisplayName("Car 인스턴스가 생성된 직후 distance는 0이다.")
        void distanceIsZero_givenCarIsNew() {
            assertThat(car.getDistance()).isEqualTo(0);
        }
    }

}

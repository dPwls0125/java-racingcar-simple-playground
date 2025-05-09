import domain.CarName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CarNameTest {
    @Test
    @DisplayName("5자를 초과하면 예와가 발생 한다.")
    void throwsInvalidLengthUserNameException() {
        assertThatThrownBy(() -> new CarName("123456")).isInstanceOf(CarName.InvalidLengthUserNameException.class);
    }

    @Test
    @DisplayName("공백이나 null을 입력하면 예외가 발생한다.")
    void throwsIllegalArgumentException() {
        assertAll(
                () -> assertThatThrownBy(() -> new CarName(" ")).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new CarName("")).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new CarName(null)).isInstanceOf(IllegalArgumentException.class)
        );
    }
}

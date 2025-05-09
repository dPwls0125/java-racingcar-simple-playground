package domain;

import java.util.Objects;

public class CarName {
    private final String name;

    public CarName(String name) {
        validateNotBlankOrNull(name);
        validateNameLengthIsLessThanOrEqualToFive(name);
        this.name = name;
    }

    private void validateNotBlankOrNull(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
    }

    private void validateNameLengthIsLessThanOrEqualToFive(String name) {
        if (name.length() > 5) {
            throw new InvalidLengthUserNameException("이름은 5자까지 가능합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarName carName)) return false;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public static class InvalidLengthUserNameException extends IllegalArgumentException {
        InvalidLengthUserNameException(String errorMessage) {
            super(errorMessage);
        }
    }
}

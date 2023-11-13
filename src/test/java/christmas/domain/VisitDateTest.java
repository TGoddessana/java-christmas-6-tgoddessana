package christmas.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class VisitDateTest {
    @ParameterizedTest
    @DisplayName("1부터 31까지의 유효한 날짜는 예외를 발생시키지 않는다.")
    @MethodSource("validDates")
    public void validDateShouldNotThrowException(int validDate) {
        assertThatCode(() -> new VisitDate(validDate))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("1보다 작거나, 31보다 큰 날짜는 예외를 발생시킨다.")
    @MethodSource("invalidDates")
    public void invalidDateShouldThrowIllegalArgumentException(int invalidDate) {
        assertThatThrownBy(() -> new VisitDate(invalidDate))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static IntStream validDates() {
        return IntStream.rangeClosed(1, 31);
    }


    private static IntStream invalidDates() {
        return IntStream.of(0, 32, 40);
    }
}
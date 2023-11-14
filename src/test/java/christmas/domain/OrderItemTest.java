package christmas.domain;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderItemTest {
    @DisplayName("1부터 19까지의 유효한 수량은 예외를 발생시키지 않는다.")
    @Test
    void validQuantityShouldNotThrowException() {
        assertThatCode(() -> new OrderItem("후라이드", 1)).doesNotThrowAnyException();
    }

    @DisplayName("1보다 작은 수량은 예외를 발생시킨다.")
    @Test
    void invalidQuantityShouldThrowIllegalArgumentException() {
        assertThatCode(() -> new OrderItem("후라이드", 0)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("19보다 큰 수량은 예외를 발생시킨다.")
    @Test
    void invalidQuantityShouldThrowIllegalArgumentException2() {
        assertThatCode(() -> new OrderItem("후라이드", 20)).isInstanceOf(IllegalArgumentException.class);
    }
}

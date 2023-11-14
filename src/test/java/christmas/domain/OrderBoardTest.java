package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.domain.order.OrderBoard;
import christmas.domain.order.OrderItem;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderBoardTest {

    @DisplayName("주문 메뉴가 20개 이하일 경우, 예외를 발생시키지 않는다.")
    @Test
    public void testValidOrderBoardCreation() {
        List<OrderItem> validOrderItems = Arrays.asList(new OrderItem("Item1", 5), new OrderItem("Item2", 10),
                new OrderItem("Item3", 5));

        OrderBoard orderBoard = new OrderBoard(validOrderItems);

        assertThat(orderBoard).isNotNull();
        assertThat(orderBoard.toString()).contains("Item1", "Item2", "Item3");
    }

    @DisplayName("주문 메뉴가 20개를 초과할 경우, 예외를 발생시킨다.")
    @Test
    public void testOrderBoardWithExceedingTotalQuantity() {
        List<OrderItem> orderItemsExceedingTotal = Arrays.asList(new OrderItem("Item1", 19),
                new OrderItem("Item2", 19));

        assertThatThrownBy(() -> new OrderBoard(orderItemsExceedingTotal)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 이름의 메뉴가 존재할 경우, 예외를 발생시킨다.")
    @Test
    public void testOrderBoardWithDuplicatedMenuName() {
        List<OrderItem> orderItemsWithDuplicatedMenuName = Arrays.asList(new OrderItem("Item1", 5),
                new OrderItem("Item1", 5));

        assertThatThrownBy(() -> new OrderBoard(orderItemsWithDuplicatedMenuName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
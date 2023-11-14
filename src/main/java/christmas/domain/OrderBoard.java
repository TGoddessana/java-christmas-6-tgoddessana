package christmas.domain;

import java.util.List;

public class OrderBoard {
    private final List<OrderItem> orderItems;

    public OrderBoard(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<주문 메뉴>\n");
        for (OrderItem orderItem : orderItems) {
            sb.append(orderItem.toString()).append("\n");
        }
        return sb.toString();
    }
}

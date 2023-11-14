package christmas.domain;

import java.util.List;

public class OrderBoard {
    private final List<OrderItem> orderItems;

    public OrderBoard(List<OrderItem> orderItems) {
        validate(orderItems);
        this.orderItems = orderItems;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    private void validate(List<OrderItem> orderItems) {
        int sum = orderItems.stream().mapToInt(OrderItem::getQuantity).sum();

        if (sum > 20) {
            throw new IllegalArgumentException("총 수량은 20개 이하여야 합니다.");
        }

        if (orderItems.stream().map(OrderItem::getItemName).distinct().count() != orderItems.size()) {
            throw new IllegalArgumentException("중복된 메뉴가 존재합니다.");
        }
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

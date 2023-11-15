package christmas.service;

import christmas.domain.menu.MenuBoard;
import christmas.domain.order.OrderBoard;
import christmas.domain.order.OrderItem;
import christmas.domain.order.VisitDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderService {
    public VisitDate createVisitDate(int visitDate) {
        return new VisitDate(visitDate);
    }

    public OrderBoard createOrderBoard(List<HashMap<String, Integer>> order) {
        List<OrderItem> orderItems = new ArrayList<>();

        for (HashMap<String, Integer> orderItem : order) {
            orderItems.add(createOrderItem(orderItem));
        }

        return new OrderBoard(orderItems);
    }

    private OrderItem createOrderItem(HashMap<String, Integer> orderItem) {
        String itemName = orderItem.keySet().iterator().next();
        int quantity = orderItem.get(itemName);

        return new OrderItem(itemName, quantity);
    }

    public void validateOrderBoard(OrderBoard orderBoard, MenuBoard menuBoard) {
        // 메뉴에 없는 음식은 주문할 수 없습니다.
        for (OrderItem orderItem : orderBoard.getOrderItems()) {
            try {
                menuBoard.findMenuItem(orderItem.getItemName());
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("메뉴에 없는 음식은 주문할 수 없습니다.");
            }
        }

    }

}

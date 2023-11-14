package christmas.service;

import christmas.domain.OrderBoard;
import christmas.domain.OrderItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderService {
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
}

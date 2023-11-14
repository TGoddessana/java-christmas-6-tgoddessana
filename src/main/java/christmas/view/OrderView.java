package christmas.view;

import christmas.domain.OrderBoard;
import java.util.HashMap;
import java.util.List;

public interface OrderView {
    List<HashMap<String, Integer>> inputOrder();

    OrderBoard displayOrdered(OrderBoard orderBoard);
}

package christmas.view;

import java.util.HashMap;
import java.util.List;

public interface OrderView {
    List<HashMap<String, Integer>> inputOrder();

    void displayOrdered();
}

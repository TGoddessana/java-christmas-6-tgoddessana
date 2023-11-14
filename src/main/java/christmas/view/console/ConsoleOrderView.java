package christmas.view.console;

import christmas.domain.order.OrderBoard;
import christmas.view.OrderView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConsoleOrderView extends ConsoleView implements OrderView {
    private static final String ASK_ORDER_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    private static final String INVALID_INPUT_MESSAGE = "유효하지 않은 주문입니다. 다시 입력해 주세요.";

    @Override
    public List<HashMap<String, Integer>> inputOrder() {
        String userInput = input(ASK_ORDER_MESSAGE);
        return getCleanInput(userInput);
    }

    @Override
    public OrderBoard displayOrdered(OrderBoard orderBoard) {
        display("");
        display("<주문 메뉴>");

        for (int i = 0; i < orderBoard.getOrderItems().size(); i++) {
            display(orderBoard.getOrderItems().get(i).getItemName() + " " + orderBoard.getOrderItems().get(i)
                    .getQuantity() + "개");
        }

        return orderBoard;
    }


    private List<HashMap<String, Integer>> getCleanInput(String input) {
        try {
            return parseInput(input);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }

    private List<HashMap<String, Integer>> parseInput(String input) {
        List<HashMap<String, Integer>> parsedInput = new ArrayList<>();
        String[] orders = input.split(",");

        for (String order : orders) {
            HashMap<String, Integer> parsedOrder = parseSingleOrder(order);
            parsedInput.add(parsedOrder);
        }

        return parsedInput;
    }

    private HashMap<String, Integer> parseSingleOrder(String order) {
        HashMap<String, Integer> parsedOrder = new HashMap<>();
        String[] orderAndCount = order.split("-");
        parsedOrder.put(orderAndCount[0], Integer.parseInt(orderAndCount[1]));
        return parsedOrder;
    }
}

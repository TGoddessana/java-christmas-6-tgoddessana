package christmas.view.console;

import christmas.domain.MenuBoard;
import christmas.domain.OrderBoard;
import christmas.view.EventView;

public class ConsoleEventView extends ConsoleView implements EventView {
    private static final String EVENT_PREVIEW_MESSAGE = "12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";

    @Override
    public String displayPreviewMessage() {
        display(EVENT_PREVIEW_MESSAGE);
        return EVENT_PREVIEW_MESSAGE;
    }

    @Override
    public Integer displayPriceBeforeEvent(OrderBoard orderBoard, MenuBoard menuBoard) {
        int priceBeforeEvent = menuBoard.calculateTotalPrice(orderBoard);

        display("");
        display("<할인 전 총주문 금액>");
        display(String.format("%,d원", priceBeforeEvent));

        return priceBeforeEvent;
    }
}

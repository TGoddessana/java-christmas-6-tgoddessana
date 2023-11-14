package christmas.view;

import christmas.domain.menu.MenuBoard;
import christmas.domain.order.OrderBoard;

public interface EventView {
    String displayPreviewMessage();

    Integer displayPriceBeforeEvent(OrderBoard orderBoard, MenuBoard menuBoard);
}

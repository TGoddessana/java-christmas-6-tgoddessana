package christmas.view;

import christmas.domain.MenuBoard;
import christmas.domain.OrderBoard;

public interface EventView {
    String displayPreviewMessage();

    Integer displayPriceBeforeEvent(OrderBoard orderBoard, MenuBoard menuBoard);
}

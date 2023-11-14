package christmas.domain.event;

import christmas.domain.menu.MenuBoard;
import christmas.domain.menu.MenuItem;
import christmas.domain.order.OrderBoard;
import java.util.List;

public class GiveawayEvent {
    private final static int EVENT_PRICE = 120000;
    private final List<MenuItem> eventItems;
    private final MenuBoard menuBoard;
    private final OrderBoard orderBoard;

    public GiveawayEvent(List<MenuItem> eventItems, OrderBoard orderBoard, MenuBoard menuBoard) {
        this.eventItems = eventItems;
        this.menuBoard = menuBoard;
        this.orderBoard = orderBoard;
    }

    public String getEventItemName() {
        if (isOverEventPrice()) {
            StringBuilder eventItemNames = new StringBuilder();

            for (MenuItem eventItem : eventItems) {
                eventItemNames.append(eventItem.getName()).append(" 1개, ");
            }

            return eventItemNames.substring(0, eventItemNames.length() - 2);
        }
        return "없음";
    }

    private boolean isOverEventPrice() {
        return menuBoard.calculateTotalPrice(orderBoard) >= EVENT_PRICE;
    }

}

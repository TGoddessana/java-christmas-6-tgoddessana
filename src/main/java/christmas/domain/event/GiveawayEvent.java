package christmas.domain.event;

import christmas.domain.menu.MenuBoard;
import christmas.domain.menu.MenuItem;
import christmas.domain.order.OrderBoard;
import java.util.List;

public class GiveawayEvent extends BeneficialEvent {
    private static final String EVENT_NAME = "증정 이벤트";
    private final static int EVENT_PRICE = 120000;
    private final List<MenuItem> eventItems;
    private final MenuBoard menuBoard;
    private final OrderBoard orderBoard;

    public GiveawayEvent(List<MenuItem> eventItems, OrderBoard orderBoard, MenuBoard menuBoard) {
        this.eventItems = eventItems;
        this.menuBoard = menuBoard;
        this.orderBoard = orderBoard;
    }

    @Override
    public String getEventName() {
        return EVENT_NAME;
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

    @Override
    public int calculateBenefitPrice() {
        int benefitPrice = 0;

        for (MenuItem eventItem : eventItems) {
            if (isOverEventPrice()) {
                benefitPrice += eventItem.getPrice();
            }
        }

        return benefitPrice;
    }

    @Override
    public String toString() {
        return "증정 이벤트: " + getEventItemName() + "(" + getEventItemName() + ")";
    }
}

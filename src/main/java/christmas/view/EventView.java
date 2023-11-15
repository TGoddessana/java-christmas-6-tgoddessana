package christmas.view;

import christmas.domain.event.DDayDiscountEvent;
import christmas.domain.event.GiveawayEvent;
import christmas.domain.menu.MenuBoard;
import christmas.domain.order.OrderBoard;

public interface EventView {
    String displayPreviewMessage();

    Integer displayPriceBeforeEvent(OrderBoard orderBoard, MenuBoard menuBoard);

    String displayEventHeaderMessage();

    GiveawayEvent displayGiveawayEvent(GiveawayEvent giveawayEvent);

    DDayDiscountEvent displayDDayDiscountEvent(DDayDiscountEvent dDayDiscountEvent);
}

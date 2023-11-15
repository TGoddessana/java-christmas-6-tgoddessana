package christmas.view;

import christmas.domain.event.BadgeEvent;
import christmas.domain.event.BeneficialEvent;
import christmas.domain.event.GiveawayEvent;
import christmas.domain.menu.MenuBoard;
import christmas.domain.order.OrderBoard;

public interface EventView {
    String displayPreviewMessage();

    Integer displayPriceBeforeEvent(OrderBoard orderBoard, MenuBoard menuBoard);

    String displayEventHeaderMessage();

    GiveawayEvent displayGiveawayEvent(GiveawayEvent giveawayEvent);

    BeneficialEvent displayBeneficialEvent(BeneficialEvent beneficialEvent);

    BadgeEvent displayBadgeEvent(BadgeEvent badgeEvent);

    Integer displayPriceAfterEvent(int priceAfterEvent);
}

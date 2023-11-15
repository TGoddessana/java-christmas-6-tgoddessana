package christmas.view;

import christmas.domain.event.BadgeEvent;
import christmas.domain.event.BeneficialEvent;
import christmas.domain.event.GiveawayEvent;
import christmas.domain.menu.MenuBoard;
import christmas.domain.order.OrderBoard;
import java.util.List;

public interface EventView {
    String displayPreviewMessage();

    Integer displayPriceBeforeEvent(OrderBoard orderBoard, MenuBoard menuBoard);

    GiveawayEvent displayGiveawayEvent(GiveawayEvent giveawayEvent);

    BeneficialEvent displayBeneficialEvent(List<BeneficialEvent> beneficialEvents);

    Integer displayTotalBenefit(int priceAfterEvent);

    Integer displayPriceAfterEvent(int priceAfterEvent, int priceBeforeEvent);

    BadgeEvent displayBadgeEvent(BadgeEvent badgeEvent);
}

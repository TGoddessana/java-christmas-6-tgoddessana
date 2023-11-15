package christmas.view.console;

import christmas.domain.event.BadgeEvent;
import christmas.domain.event.BeneficialEvent;
import christmas.domain.event.GiveawayEvent;
import christmas.domain.menu.MenuBoard;
import christmas.domain.order.OrderBoard;
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

    @Override
    public String displayEventHeaderMessage() {
        String header = "<혜택 내역>";

        display("");
        display(header);

        return header;
    }

    @Override
    public GiveawayEvent displayGiveawayEvent(GiveawayEvent giveawayEvent) {
        display("");
        display("<증정 메뉴>");
        display(giveawayEvent.getEventItemName());

        return giveawayEvent;
    }

    @Override
    public BeneficialEvent displayBeneficialEvent(BeneficialEvent beneficialEvent) {
        int benefitPrice = beneficialEvent.calculateBenefitPrice();

        if (benefitPrice == 0) {
            return beneficialEvent;
        }

        display(beneficialEvent.getEventName() + ": -" + (String.format("%,d원", benefitPrice)));

        return beneficialEvent;
    }

    @Override
    public BadgeEvent displayBadgeEvent(BadgeEvent badgeEvent) {
        display("");
        display("<12월 이벤트 배지>");
        display(String.valueOf(badgeEvent.getBadge()));

        return badgeEvent;
    }
}

package christmas.view.console;

import christmas.domain.event.BadgeEvent;
import christmas.domain.event.BeneficialEvent;
import christmas.domain.event.GiveawayEvent;
import christmas.domain.menu.MenuBoard;
import christmas.domain.order.OrderBoard;
import christmas.view.EventView;
import java.util.List;

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
    public GiveawayEvent displayGiveawayEvent(GiveawayEvent giveawayEvent) {
        display("");
        display("<증정 메뉴>");
        display(giveawayEvent.getEventItemName());

        return giveawayEvent;
    }

    @Override
    public BeneficialEvent displayBeneficialEvent(List<BeneficialEvent> beneficialEvents) {
        display("");
        display("<혜택 내역>");

        int totalBenefit = 0;

        for (BeneficialEvent beneficialEvent : beneficialEvents) {
            totalBenefit += beneficialEvent.calculateBenefitPrice();
        }

        if (totalBenefit == 0) {
            display("없음");
            return null;
        }

        for (BeneficialEvent beneficialEvent : beneficialEvents) {
            int benefitPrice = beneficialEvent.calculateBenefitPrice();

            if (benefitPrice == 0) {
                continue;
            }

            display(beneficialEvent.getEventName() + ": -" + (String.format("%,d원", benefitPrice)));
        }

        return beneficialEvents.get(0);
    }

    @Override
    public Integer displayTotalBenefit(int priceAfterEvent) {
        display("");
        display("<총혜택 금액>");

        if (priceAfterEvent == 0) {
            display("없음");
            return priceAfterEvent;
        }

        display("-" + String.format("%,d원", priceAfterEvent));

        return priceAfterEvent;
    }

    @Override
    public Integer displayPriceAfterEvent(int priceAfterEvent, int priceBeforeEvent) {
        display("");
        display("<할인 후 예상 결제 금액>");
        display(String.format("%,d원", priceBeforeEvent - priceAfterEvent));

        return priceBeforeEvent - priceAfterEvent;
    }

    @Override
    public BadgeEvent displayBadgeEvent(BadgeEvent badgeEvent) {
        display("");
        display("<12월 이벤트 배지>");
        display(String.valueOf(badgeEvent.getBadge()));

        return badgeEvent;
    }


}

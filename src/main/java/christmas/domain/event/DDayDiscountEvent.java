package christmas.domain.event;

import christmas.domain.menu.MenuBoard;
import christmas.domain.order.OrderBoard;
import christmas.domain.order.VisitDate;

public class DDayDiscountEvent extends DiscountEvent {
    public static final String EVENT_NAME = "크리스마스 디데이 할인";

    public DDayDiscountEvent(VisitDate visitDate, OrderBoard orderBoard, MenuBoard menuBoard) {
        super(visitDate, orderBoard, menuBoard);
    }

    @Override
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override
    public int calculateDiscountPrice() {
        if (visitDate.getUntilChristmas() < 0) {
            return 0;
        }

        return 1000 + (24 - visitDate.getUntilChristmas()) * 100;
    }

    @Override
    public int calculateBenefitPrice() {
        return calculateDiscountPrice();
    }

    @Override
    public String toString() {
        return "크리스마스 디데이 할인: -" + calculateDiscountPrice() + "원";
    }
}

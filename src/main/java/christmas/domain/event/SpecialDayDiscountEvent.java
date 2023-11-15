package christmas.domain.event;

import christmas.domain.menu.MenuBoard;
import christmas.domain.order.OrderBoard;
import christmas.domain.order.VisitDate;

public class SpecialDayDiscountEvent extends DiscountEvent {
    private static final String EVENT_NAME = "특별 할인";

    public SpecialDayDiscountEvent(VisitDate visitDate, OrderBoard orderBoard,
                                   MenuBoard menuBoard) {
        super(visitDate, orderBoard, menuBoard);
    }

    @Override
    public int calculateDiscountPrice() {
        if (visitDate.isSpecialDay()) {
            return 1000;
        }

        return 0;
    }

    @Override
    public String toString() {
        return EVENT_NAME + " -" + calculateDiscountPrice() + "원 할인";
    }
}

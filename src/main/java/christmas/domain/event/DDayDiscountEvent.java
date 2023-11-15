package christmas.domain.event;

import christmas.domain.menu.MenuBoard;
import christmas.domain.order.OrderBoard;
import christmas.domain.order.VisitDate;

public class DDayDiscountEvent extends DiscountEvent {
    public DDayDiscountEvent(VisitDate visitDate, OrderBoard orderBoard, MenuBoard menuBoard) {
        super(visitDate, orderBoard, menuBoard);
    }

    @Override
    public int calculateDiscountPrice() {
        if (visitDate.getUntilChristmas() < 0) {
            return 0;
        }

        return 1000 + (24 - visitDate.getUntilChristmas()) * 100;
    }
}

package christmas.domain.event;

import christmas.domain.menu.MenuBoard;
import christmas.domain.order.OrderBoard;
import christmas.domain.order.VisitDate;

public abstract class DiscountEvent {
    protected final VisitDate visitDate;
    protected final OrderBoard orderBoard;
    protected final MenuBoard menuBoard;

    public DiscountEvent(VisitDate visitDate, OrderBoard orderBoard, MenuBoard menuBoard) {
        this.visitDate = visitDate;
        this.orderBoard = orderBoard;
        this.menuBoard = menuBoard;
    }

    public abstract int calculateDiscountPrice();
}

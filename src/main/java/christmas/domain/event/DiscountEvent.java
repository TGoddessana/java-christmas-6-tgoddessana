package christmas.domain.event;

import christmas.domain.menu.MenuBoard;
import christmas.domain.order.OrderBoard;
import christmas.domain.order.VisitDate;

/**
 * 실제 고객의 결제 금액에 영향을 주는 이벤트를 나타냅니다.
 */
public abstract class DiscountEvent extends BeneficialEvent {
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

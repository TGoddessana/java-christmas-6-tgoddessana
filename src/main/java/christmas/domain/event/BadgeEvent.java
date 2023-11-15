package christmas.domain.event;

import christmas.domain.menu.MenuBoard;
import christmas.domain.order.OrderBoard;
import christmas.domain.order.VisitDate;

public class BadgeEvent {
    protected final VisitDate visitDate;
    protected final OrderBoard orderBoard;
    protected final MenuBoard menuBoard;

    private static final String EVENT_NAME = "이벤트 배지";

    public BadgeEvent(VisitDate visitDate, OrderBoard orderBoard, MenuBoard menuBoard) {
        this.visitDate = visitDate;
        this.orderBoard = orderBoard;
        this.menuBoard = menuBoard;
    }

    enum Badge {
        별(5000), 트리(10000), 산타(20000);

        private final int price;

        Badge(int price) {
            this.price = price;
        }

        public int getPrice() {
            return price;
        }
    }

    private Badge getBadge() {
        int totalPrice = menuBoard.calculateTotalPrice(orderBoard);

        if (totalPrice >= Badge.산타.getPrice()) {
            return Badge.산타;
        }
        if (totalPrice >= Badge.트리.getPrice()) {
            return Badge.트리;
        }
        if (totalPrice >= Badge.별.getPrice()) {
            return Badge.별;
        }
        return null;
    }

    @Override
    public String toString() {
        Badge badge = getBadge();

        if (badge == null) {
            return "없음";
        }

        return String.format("%s: %s", EVENT_NAME, badge.name());
    }

}

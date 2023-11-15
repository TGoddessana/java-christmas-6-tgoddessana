package christmas.domain.event;

import christmas.domain.menu.MenuBoard;
import christmas.domain.order.OrderBoard;
import christmas.domain.order.OrderItem;
import christmas.domain.order.VisitDate;

public class WeekdayDiscountEvent extends DiscountEvent {
    public static final String EVENT_NAME = "평일 할인";

    public WeekdayDiscountEvent(VisitDate visitDate, OrderBoard orderBoard, MenuBoard menuBoard) {
        super(visitDate, orderBoard, menuBoard);
    }

    @Override
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override
    public int calculateDiscountPrice() {
        if (!visitDate.isWeekend()) {
            int orderQuantity = 0;

            for (OrderItem orderItem : orderBoard.getOrderItems()) {
                if (orderItem.getCategory(menuBoard).getName().equals("디저트")) {
                    orderQuantity += orderItem.getQuantity();
                }
            }

            return orderQuantity * 2023;
        }

        return 0;
    }

    @Override
    public int calculateBenefitPrice() {
        return calculateDiscountPrice();
    }

    @Override
    public String toString() {
        return EVENT_NAME + " -" + calculateDiscountPrice() + "원";
    }
}

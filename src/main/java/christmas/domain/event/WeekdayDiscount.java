package christmas.domain.event;

import christmas.domain.menu.MenuBoard;
import christmas.domain.order.OrderBoard;
import christmas.domain.order.OrderItem;
import christmas.domain.order.VisitDate;

public class WeekdayDiscount extends DiscountEvent {
    public WeekdayDiscount(VisitDate visitDate, OrderBoard orderBoard, MenuBoard menuBoard) {
        super(visitDate, orderBoard, menuBoard);
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
}

package christmas.service;

import christmas.domain.event.DDayDiscountEvent;
import christmas.domain.event.GiveawayEvent;
import christmas.domain.event.SpecialDayDiscountEvent;
import christmas.domain.event.WeekdayDiscountEvent;
import christmas.domain.event.WeekendDiscountEvent;
import christmas.domain.menu.MenuBoard;
import christmas.domain.menu.MenuItem;
import christmas.domain.order.OrderBoard;
import christmas.domain.order.VisitDate;
import java.util.List;

public class EventService {
    public GiveawayEvent initGiveawayEvent(MenuBoard menuBoard, OrderBoard orderBoard) {
        List<MenuItem> eventItem = List.of(menuBoard.findMenuItem("샴페인"));
        return new GiveawayEvent(eventItem, orderBoard, menuBoard);
    }

    public DDayDiscountEvent initDDayDiscountEvent(VisitDate visitDate, MenuBoard menuBoard, OrderBoard orderBoard) {
        return new DDayDiscountEvent(visitDate, orderBoard, menuBoard);
    }

    public WeekdayDiscountEvent initWeekdayDiscount(VisitDate visitDate, MenuBoard menuBoard, OrderBoard orderBoard) {
        return new WeekdayDiscountEvent(visitDate, orderBoard, menuBoard);
    }

    public WeekendDiscountEvent initWeekendDiscount(VisitDate visitDate, MenuBoard menuBoard, OrderBoard orderBoard) {
        return new WeekendDiscountEvent(visitDate, orderBoard, menuBoard);
    }

    public SpecialDayDiscountEvent initSpecialDayDiscount(VisitDate visitDate, MenuBoard menuBoard,
                                                          OrderBoard orderBoard) {
        return new SpecialDayDiscountEvent(visitDate, orderBoard, menuBoard);
    }
}

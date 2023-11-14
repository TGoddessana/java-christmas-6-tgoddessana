package christmas.service;

import christmas.domain.event.GiveawayEvent;
import christmas.domain.menu.MenuBoard;
import christmas.domain.menu.MenuItem;
import christmas.domain.order.OrderBoard;
import java.util.List;

public class EventService {
    public GiveawayEvent initGiveawayEvent(MenuBoard menuBoard, OrderBoard orderBoard) {
        List<MenuItem> eventItem = List.of(menuBoard.findMenuItem("샴페인"));
        return new GiveawayEvent(eventItem, orderBoard, menuBoard);
    }
}

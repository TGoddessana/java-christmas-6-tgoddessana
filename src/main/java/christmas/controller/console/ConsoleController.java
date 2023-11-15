package christmas.controller.console;

import christmas.domain.event.BadgeEvent;
import christmas.domain.event.BeneficialEvent;
import christmas.domain.event.GiveawayEvent;
import christmas.domain.menu.MenuBoard;
import christmas.domain.order.OrderBoard;
import christmas.domain.order.VisitDate;
import christmas.service.EventService;
import christmas.service.MenuService;
import christmas.service.OrderService;
import christmas.view.ErrorView;
import christmas.view.EventView;
import christmas.view.OrderView;
import christmas.view.VisitDateView;
import christmas.view.WelcomeView;
import christmas.view.console.ConsoleErrorView;
import christmas.view.console.ConsoleEventView;
import christmas.view.console.ConsoleOrderView;
import christmas.view.console.ConsoleVisitDateView;
import christmas.view.console.ConsoleWelcomeView;
import java.util.List;
import java.util.function.Supplier;

public class ConsoleController {
    private static final WelcomeView welcomeView = new ConsoleWelcomeView();
    private static final VisitDateView visitDateView = new ConsoleVisitDateView();
    private static final OrderView orderView = new ConsoleOrderView();
    private static final EventView eventView = new ConsoleEventView();
    private static final ErrorView errorView = new ConsoleErrorView();

    private static final MenuService menuService = new MenuService();
    private static final OrderService orderService = new OrderService();
    private static final EventService eventService = new EventService();

    public void run() {
        // 식당 오픈 전, 메뉴판을 미리 만들어둡니다.
        MenuBoard menuBoard = menuService.setUpMenuBoard();

        // 손님에게 환영 메시지를 보여줍니다.
        welcomeView.displayWelcomeMessage();

        // 손님에게 방문할 날짜를 입력받습니다.
        VisitDate visitDate = getVisitDate();

        // 손님에게 주문을 입력받습니다.
        OrderBoard orderBoard = getOrderBoard();

        // 손님이 주문한 메뉴를 출력합니다.
        eventView.displayPreviewMessage();
        orderView.displayOrdered(orderBoard);

        // 할인 전 가격을 출력합니다.
        eventView.displayPriceBeforeEvent(orderBoard, menuBoard);

        // 증정 이벤트 객체를 만들고, 결과를 계산합니다.
        GiveawayEvent giveawayEvent = eventService.initGiveawayEvent(menuBoard, orderBoard);
        eventView.displayGiveawayEvent(giveawayEvent);

        // 크리스마스 디데이 할인, 평일 할인, 주말 할인, 특별 할인 객체를 만듭니다.
        BeneficialEvent dDayDiscountEvent = eventService.initDDayDiscountEvent(visitDate, menuBoard, orderBoard);
        BeneficialEvent weekdayDiscountEvent = eventService.initWeekdayDiscount(visitDate, menuBoard, orderBoard);
        BeneficialEvent weekendDiscountEvent = eventService.initWeekendDiscount(visitDate, menuBoard, orderBoard);
        BeneficialEvent specialDayDiscountEvent = eventService.initSpecialDayDiscount(visitDate, menuBoard, orderBoard);
        BadgeEvent badgeEvent = new BadgeEvent(visitDate, orderBoard, menuBoard);

        eventView.displayEventHeaderMessage();
        eventView.displayBeneficialEvent(dDayDiscountEvent);
        eventView.displayBeneficialEvent(weekdayDiscountEvent);
        eventView.displayBeneficialEvent(weekendDiscountEvent);
        eventView.displayBeneficialEvent(specialDayDiscountEvent);
        eventView.displayBeneficialEvent(giveawayEvent);

        // 할인 후 가격을 출력합니다.
        int totalBenefitPrice = eventService.getTotalBenefitPrice(
                List.of(dDayDiscountEvent, weekdayDiscountEvent, weekendDiscountEvent, specialDayDiscountEvent,
                        giveawayEvent));

        eventView.displayTotalBenefit(totalBenefitPrice);
        eventView.displayPriceAfterEvent(totalBenefitPrice, menuBoard.calculateTotalPrice(orderBoard));

        // 뱃지 이벤트를 출력합니다.
        eventView.displayBadgeEvent(badgeEvent);
    }

    private <T> T getInput(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            errorView.displayErrorMessage(e.getMessage());
            return getInput(supplier);
        }
    }


    private VisitDate getVisitDate() {
        return getInput(() -> orderService.createVisitDate(visitDateView.inputVisitDate()));
    }

    private OrderBoard getOrderBoard() {
        return getInput(() -> orderService.createOrderBoard(orderView.inputOrder()));
    }


}

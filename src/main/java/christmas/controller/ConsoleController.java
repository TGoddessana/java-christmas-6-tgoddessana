package christmas.controller;

import christmas.domain.MenuBoard;
import christmas.domain.OrderBoard;
import christmas.domain.VisitDate;
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
import java.util.function.Supplier;

public class ConsoleController {
    private static final WelcomeView welcomeView = new ConsoleWelcomeView();
    private static final VisitDateView visitDateView = new ConsoleVisitDateView();
    private static final OrderView orderView = new ConsoleOrderView();
    private static final EventView eventView = new ConsoleEventView();
    private static final ErrorView errorView = new ConsoleErrorView();

    private static final MenuService menuService = new MenuService();
    private static final OrderService orderService = new OrderService();

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

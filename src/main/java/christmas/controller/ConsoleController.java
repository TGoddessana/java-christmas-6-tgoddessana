package christmas.controller;

import christmas.domain.MenuBoard;
import christmas.domain.VisitDate;
import christmas.service.MenuService;
import christmas.view.ErrorView;
import christmas.view.OrderView;
import christmas.view.VisitDateView;
import christmas.view.WelcomeView;
import christmas.view.console.ConsoleErrorView;
import christmas.view.console.ConsoleOrderView;
import christmas.view.console.ConsoleVisitDateView;
import christmas.view.console.ConsoleWelcomeView;
import java.util.HashMap;
import java.util.List;

public class ConsoleController {
    private static final WelcomeView welcomeView = new ConsoleWelcomeView();
    private static final VisitDateView visitDateView = new ConsoleVisitDateView();
    private static final OrderView orderView = new ConsoleOrderView();
    private static final ErrorView errorView = new ConsoleErrorView();

    private static final MenuService menuService = new MenuService();

    public void run() {
        // 식당 오픈 전, 메뉴판을 미리 만들어둡니다.
        MenuBoard menuBoard = menuService.setUpMenuBoard();

        // 손님에게 환영 메시지를 보여줍니다.
        welcome();

        // 손님에게 방문할 날짜를 입력받습니다.
        VisitDate visitDate = getVisitDate();

        // 손님에게 주문을 입력받습니다.
        getOrder();

        // 손님에게 주문 내역을 보여줍니다.

    }

    private void welcome() {
        welcomeView.displayWelcomeMessage();
    }


    private VisitDate getVisitDate() {
        try {
            return new VisitDate(visitDateView.inputVisitDate());
        } catch (IllegalArgumentException e) {
            errorView.displayErrorMessage(e.getMessage());
            return getVisitDate();
        }
    }

    private List<HashMap<String, Integer>> getOrder() {
        try {
            return orderView.inputOrder();

        } catch (IllegalArgumentException e) {
            errorView.displayErrorMessage(e.getMessage());
            return getOrder();
        }
    }
}

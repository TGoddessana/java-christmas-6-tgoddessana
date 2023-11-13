package christmas.controller;

import christmas.domain.VisitDate;
import christmas.view.ErrorView;
import christmas.view.OrderView;
import christmas.view.VisitDateView;
import christmas.view.WelcomeView;
import christmas.view.console.ConsoleErrorView;
import christmas.view.console.ConsoleOrderView;
import christmas.view.console.ConsoleVisitDateView;
import christmas.view.console.ConsoleWelcomeView;

public class ConsoleController {
    private static final WelcomeView welcomeView = new ConsoleWelcomeView();
    private static final VisitDateView visitDateView = new ConsoleVisitDateView();
    private static final OrderView orderView = new ConsoleOrderView();
    private static final ErrorView errorView = new ConsoleErrorView();

    public void run() {
        welcome();
        getVisitDate();
        getOrder();
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

    private void getOrder() {
        try {
            System.out.println(orderView.inputOrder());
        } catch (IllegalArgumentException e) {
            errorView.displayErrorMessage(e.getMessage());
            getOrder();
        }
    }
}

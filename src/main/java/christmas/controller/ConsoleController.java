package christmas.controller;

import christmas.domain.VisitDate;
import christmas.view.ErrorView;
import christmas.view.VisitDateView;
import christmas.view.WelcomeView;
import christmas.view.console.ConsoleErrorView;
import christmas.view.console.ConsoleVisitDateView;
import christmas.view.console.ConsoleWelcomeView;

public class ConsoleController {
    private static final WelcomeView welcomeView = new ConsoleWelcomeView();
    private static final VisitDateView visitDateView = new ConsoleVisitDateView();
    private static final ErrorView errorView = new ConsoleErrorView();

    public void run() {
        welcome();
        getVisitDate();
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
}
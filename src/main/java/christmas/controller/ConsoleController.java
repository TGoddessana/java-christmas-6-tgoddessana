package christmas.controller;

import christmas.view.VisitDateView;
import christmas.view.WelcomeView;
import christmas.view.console.ConsoleVisitDateView;
import christmas.view.console.ConsoleWelcomeView;

public class ConsoleController {
    private static final WelcomeView welcomeView = new ConsoleWelcomeView();
    private static final VisitDateView visitDateView = new ConsoleVisitDateView();

    public void run() {
        welcome();
        getVisitDate();
    }

    private void welcome() {
        welcomeView.displayWelcomeMessage();
    }


    private void getVisitDate() {
        try {
            visitDateView.inputVisitDate();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getVisitDate();
        }
    }
}

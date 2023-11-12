package christmas.controller;

import christmas.view.WelcomeView;
import christmas.view.console.ConsoleWelcomeView;

public class ConsoleController {
    private static final WelcomeView welcomeView = new ConsoleWelcomeView();

    public void run() {
        welcome();
    }

    public void welcome() {
        welcomeView.displayWelcomeMessage();
    }
}

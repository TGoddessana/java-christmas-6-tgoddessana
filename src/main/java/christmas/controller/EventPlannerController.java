package christmas.controller;

import christmas.view.ConsoleOutputView;

public class EventPlannerController {
    public void run() {
        ConsoleOutputView consoleOutputView = new ConsoleOutputView();
        consoleOutputView.displayWelcomeMessage();
    }
}

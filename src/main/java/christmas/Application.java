package christmas;

import christmas.controller.console.ConsoleController;

public class Application {
    public static void main(String[] args) {
        ConsoleController eventPlannerController = new ConsoleController();
        eventPlannerController.run();
    }
}

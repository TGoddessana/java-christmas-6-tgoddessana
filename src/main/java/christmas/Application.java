package christmas;

import christmas.controller.ConsoleController;

public class Application {
    public static void main(String[] args) {
        ConsoleController eventPlannerController = new ConsoleController();
        eventPlannerController.run();
    }
}

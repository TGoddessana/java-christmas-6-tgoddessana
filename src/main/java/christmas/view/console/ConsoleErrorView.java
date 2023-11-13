package christmas.view.console;

import christmas.view.ErrorView;

public class ConsoleErrorView extends ConsoleView implements ErrorView {
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    @Override
    public void displayErrorMessage(String message) {
        display(ERROR_MESSAGE_PREFIX + message);
    }
}

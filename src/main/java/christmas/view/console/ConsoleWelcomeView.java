package christmas.view.console;

import christmas.view.WelcomeView;

public class ConsoleWelcomeView extends ConsoleView implements WelcomeView {
    private final static String WELCOME_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";

    @Override
    public String displayWelcomeMessage() {
        return display(WELCOME_MESSAGE);
    }
}

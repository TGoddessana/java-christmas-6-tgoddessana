package christmas.view.console;

import christmas.view.EventView;

public class ConsoleEventView extends ConsoleView implements EventView {
    private static final String EVENT_PREVIEW_MESSAGE = "12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";

    @Override
    public String displayPreviewMessage() {
        display(EVENT_PREVIEW_MESSAGE);
        return EVENT_PREVIEW_MESSAGE;
    }
}

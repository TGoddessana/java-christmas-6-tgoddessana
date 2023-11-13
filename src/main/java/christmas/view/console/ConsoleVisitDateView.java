package christmas.view.console;

import christmas.view.VisitDateView;

public class ConsoleVisitDateView extends ConsoleView implements VisitDateView {
    private static final String ASK_VISIT_DATE_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String INVALID_INPUT_MESSAGE = "유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    @Override
    public Integer inputVisitDate() {
        String userInput = input(ASK_VISIT_DATE_MESSAGE);
        return getCleanInput(userInput);
    }

    private Integer getCleanInput(String input) {
        try {
            return parseInput(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }

    private Integer parseInput(String input) {
        return Integer.parseInt(input);
    }

}

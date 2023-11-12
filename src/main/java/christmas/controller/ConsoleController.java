package christmas.controller;

public class ConsoleController {
    public void run() {
        ConsoleInputView consoleInputView = new ConsoleInputView();
        ConsoleOutputView consoleOutputView = new ConsoleOutputView();

        // 환영 메시지 출력
        consoleOutputView.displayWelcomeMessage();

        // 방문 날짜 입력
        Integer visitDate = consoleInputView.getVisitDateInput();

        // 주문할 메뉴, 개수 입력
    }
}

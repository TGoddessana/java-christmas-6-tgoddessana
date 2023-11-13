package christmas.view.console;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleView {
    protected String input() {
        return Console.readLine();
    }

    protected String input(String message) {
        display(message);
        return input();
    }

    protected String display(String message) {
        System.out.println(message);
        return message;
    }
}

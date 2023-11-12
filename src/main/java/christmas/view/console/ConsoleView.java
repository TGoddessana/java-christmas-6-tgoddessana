package christmas.view.console;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleView {
    protected String input() {
        return Console.readLine();
    }

    protected String display(String message) {
        System.out.println(message);
        return message;
    }
}

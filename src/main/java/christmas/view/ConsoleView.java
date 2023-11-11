package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public abstract class ConsoleView {
    protected String input() {
        return Console.readLine();
    }

    protected void display(String message) {
        System.out.println(message);
    }
}

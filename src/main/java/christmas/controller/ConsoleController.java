package christmas.controller;

import christmas.domain.MenuBoard;
import christmas.domain.MenuCategory;
import christmas.domain.MenuItem;
import christmas.domain.VisitDate;
import christmas.view.ErrorView;
import christmas.view.OrderView;
import christmas.view.VisitDateView;
import christmas.view.WelcomeView;
import christmas.view.console.ConsoleErrorView;
import christmas.view.console.ConsoleOrderView;
import christmas.view.console.ConsoleVisitDateView;
import christmas.view.console.ConsoleWelcomeView;
import java.util.ArrayList;
import java.util.List;

public class ConsoleController {
    private static final WelcomeView welcomeView = new ConsoleWelcomeView();
    private static final VisitDateView visitDateView = new ConsoleVisitDateView();
    private static final OrderView orderView = new ConsoleOrderView();
    private static final ErrorView errorView = new ConsoleErrorView();

    public void run() {
        setUpMenuBoard();
        welcome();
        getVisitDate();
        getOrder();
    }

    private void welcome() {
        welcomeView.displayWelcomeMessage();
    }


    private VisitDate getVisitDate() {
        try {
            return new VisitDate(visitDateView.inputVisitDate());
        } catch (IllegalArgumentException e) {
            errorView.displayErrorMessage(e.getMessage());
            return getVisitDate();
        }
    }

    private void getOrder() {
        try {
            orderView.inputOrder();
        } catch (IllegalArgumentException e) {
            errorView.displayErrorMessage(e.getMessage());
            getOrder();
        }
    }

    private MenuBoard setUpMenuBoard() {
        List<MenuCategory> menuCategories = new ArrayList<>();

        menuCategories.add(cookAppetizer());
        menuCategories.add(cookMain());
        menuCategories.add(cookDessert());
        menuCategories.add(cookDrink());

        return new MenuBoard(menuCategories);
    }

    private MenuCategory cookAppetizer() {
        MenuCategory appetizer = new MenuCategory("애피타이저");
        appetizer.addMenu(new MenuItem("양송이수프", 6000, appetizer));
        appetizer.addMenu(new MenuItem("타파스", 5500, appetizer));
        appetizer.addMenu(new MenuItem("시저샐러드", 8000, appetizer));
        return appetizer;
    }

    private MenuCategory cookMain() {
        MenuCategory main = new MenuCategory("메인");
        main.addMenu(new MenuItem("티본스테이크", 55000, main));
        main.addMenu(new MenuItem("바비큐립", 54000, main));
        main.addMenu(new MenuItem("해산물파스타", 35000, main));
        main.addMenu(new MenuItem("크리스마스파스타", 25000, main));
        return main;
    }

    private MenuCategory cookDessert() {
        MenuCategory dessert = new MenuCategory("디저트");
        dessert.addMenu(new MenuItem("초코케이크", 15000, dessert));
        dessert.addMenu(new MenuItem("아이스크림", 5000, dessert));
        return dessert;
    }

    private MenuCategory cookDrink() {
        MenuCategory drink = new MenuCategory("음료");
        drink.addMenu(new MenuItem("제로콜라", 3000, drink));
        drink.addMenu(new MenuItem("레드와인", 60000, drink));
        drink.addMenu(new MenuItem("샴페인", 25000, drink));
        return drink;
    }
}

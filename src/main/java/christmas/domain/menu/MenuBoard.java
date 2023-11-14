package christmas.domain.menu;

import christmas.domain.order.OrderBoard;
import christmas.domain.order.OrderItem;
import java.util.List;
import java.util.StringJoiner;

public class MenuBoard {
    private final List<MenuCategory> menuCategories;

    public MenuBoard(List<MenuCategory> menuCategories) {
        this.menuCategories = menuCategories;
    }

    public int calculateTotalPrice(OrderBoard orderBoard) {
        int totalPrice = 0;

        for (OrderItem orderItem : orderBoard.getOrderItems()) {
            totalPrice += orderItem.getPrice(findMenuItem(orderItem));
        }

        return totalPrice;
    }

    private MenuItem findMenuItem(OrderItem orderItem) {
        List<MenuItem> allMenuItems = menuCategories.stream()
                .flatMap(category -> category.getMenuItems().stream())
                .toList();

        return allMenuItems.stream()
                .filter(menuItem -> menuItem.getName().equals(orderItem.getItemName()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메뉴입니다."));
    }

    public MenuItem findMenuItem(String itemName) {
        List<MenuItem> allMenuItems = menuCategories.stream()
                .flatMap(category -> category.getMenuItems().stream())
                .toList();

        return allMenuItems.stream()
                .filter(menuItem -> menuItem.getName().equals(itemName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메뉴입니다."));
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner("\n");

        for (MenuCategory menuCategory : menuCategories) {
            sj.add("<" + menuCategory + ">");

            StringJoiner menuItemsJoiner = new StringJoiner(", ");
            for (MenuItem menuItem : menuCategory.getMenuItems()) {
                menuItemsJoiner.add(menuItem.toString());
            }

            sj.add(menuItemsJoiner.toString());
        }

        return sj.toString();
    }
}

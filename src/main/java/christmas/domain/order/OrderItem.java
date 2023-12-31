package christmas.domain.order;

import christmas.domain.menu.MenuBoard;
import christmas.domain.menu.MenuCategory;
import christmas.domain.menu.MenuItem;

public class OrderItem {
    private final String itemName;
    private final int quantity;

    public OrderItem(String itemName, int quantity) {
        validateQuantity(quantity);
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice(MenuItem menuItem) {
        return menuItem.getPrice() * quantity;
    }

    public MenuCategory getCategory(MenuBoard menuBoard) {
        return menuBoard.findMenuItem(itemName).getCategory();
    }

    private void validateQuantity(int quantity) {
        if (quantity < 1 || quantity > 19) {
            throw new IllegalArgumentException("유효하지 않은 수량입니다.");
        }
    }

    @Override
    public String toString() {
        return itemName + " " + quantity + "개";
    }


}

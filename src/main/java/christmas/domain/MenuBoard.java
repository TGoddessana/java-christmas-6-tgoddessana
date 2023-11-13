package christmas.domain;

import java.util.List;
import java.util.StringJoiner;

public class MenuBoard {
    private final List<MenuCategory> menuCategories;

    public MenuBoard(List<MenuCategory> menuCategories) {
        this.menuCategories = menuCategories;
    }

    public List<MenuCategory> getMenuCategories() {
        return menuCategories;
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

package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class MenuCategory {
    private final String name;
    private final List<MenuItem> items;

    public MenuCategory(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public void addMenu(MenuItem item) {
        items.add(item);
    }

    public List<MenuItem> getMenuItems() {
        return items;
    }

    @Override
    public String toString() {
        return name;
    }
}

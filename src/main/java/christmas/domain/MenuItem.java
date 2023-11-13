package christmas.domain;

public class MenuItem {
    private final String name;
    private final int price;
    private final MenuCategory category;

    public MenuItem(String name, int price, MenuCategory category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public MenuCategory getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name + " " + price + "원";
    }
}

package inventory;

import java.util.LinkedHashMap;
import java.util.Map;

public class InventoryService {

    private final Map<String, Item> items = new LinkedHashMap<>();

    public boolean addItem(String name, int quantity) {
        String key = normalize(name);

        if (key.isEmpty()) return false;
        if (quantity < 0) return false;
        if (items.containsKey(key)) return false;

        items.put(key, new Item(name, quantity));
        return true;
    }

    public boolean updateQuantity(String name, int quantity) {
        String key = normalize(name);

        if (!items.containsKey(key)) return false;
        if (quantity < 0) return false;

        items.get(key).setQuantity(quantity);
        return true;
    }

    public boolean removeItem(String name) {
        String key = normalize(name);

        if (!items.containsKey(key)) return false;

        items.remove(key);
        return true;
    }

    public void printInventory() {
        System.out.println();
        System.out.println("=== Current Inventory ===");

        if (items.isEmpty()) {
            System.out.println("(empty)");
            return;
        }

        for (Item item : items.values()) {
            System.out.println("- " + item.getName() + ": " + item.getQuantity());
        }
    }

    private String normalize(String name) {
        return name == null ? "" : name.trim().toLowerCase();
    }
}

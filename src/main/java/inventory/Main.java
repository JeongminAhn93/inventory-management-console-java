package inventory;

import java.util.Scanner;

public class Main {

    private static void printMenu() {
        System.out.println();
        System.out.println("=== Inventory Management Console ===");
        System.out.println("1) Add item");
        System.out.println("2) Remove item");
        System.out.println("3) Update quantity");
        System.out.println("4) View inventory");
        System.out.println("0) Exit");
        System.out.print("Select an option: ");
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryService inventory = new InventoryService();

        boolean running = true;

        while (running) {
            printMenu();
            String option = scanner.nextLine().trim();

            switch (option) {
                case "1": {
                    System.out.print("Item name: ");
                    String name = scanner.nextLine();

                    int qty = readInt(scanner, "Quantity: ");

                    boolean ok = inventory.addItem(name, qty);
                    if (ok) System.out.println("Added.");
                    else System.out.println("Failed to add (check name, quantity, or duplicate).");
                    break;
                }
                case "4":
                    inventory.printInventory();
                    break;

                case "0":
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                case "2":
                    System.out.println("[Remove item] - Coming next step");
                    break;
                case "3":
                    System.out.println("[Update quantity] - Coming next step");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}

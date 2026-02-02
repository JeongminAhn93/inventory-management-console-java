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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            printMenu();

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    System.out.println("[Add item] - (Coming next step)");
                    break;
                case "2":
                    System.out.println("[Remove item] - (Coming next step)");
                    break;
                case "3":
                    System.out.println("[Update quantity] - (Coming next step)");
                    break;
                case "4":
                    System.out.println("[View inventory] - (Coming next step)");
                    break;
                case "0":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}

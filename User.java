import java.util.HashMap;
import java.util.Scanner;

public class User {
    HashMap<String, Integer> mp;
    Scanner sc;

    public User() {
        mp = new HashMap<>();
        sc = new Scanner(System.in);
        mp.put("idli", 20);
        mp.put("dosa", 10);

    }

    public void displayItems() {
        System.out.println("Menu:");
        for (String item : mp.keySet()) {
            System.out.println(item + " - Rs - " + mp.get(item));
        }
    }

    public void selectItems() {
        int total = 0;
        String choice;

        do {
            System.out.print("Enter item name: ");
            String item = sc.nextLine().toLowerCase();

            if (mp.containsKey(item)) {
                System.out.print("Enter quantity: ");
                int qty = sc.nextInt();
                sc.nextLine();
                int cost = mp.get(item) * qty;
                total += cost;
                System.out.println(item + " cost: ₹" + cost);
            } else {
                System.out.println("Item not found in menu!");
            }

            System.out.print("Do you want to order more items? (yes/no): ");
            choice = sc.nextLine().toLowerCase();
        } while (choice.equals("yes"));

        System.out.println("Total Bill: ₹" + total);
    }




}

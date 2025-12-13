package Shop;

import Hero.*;
import Inventory.Inventory;

import java.util.*;
import java.text.DecimalFormat;

public class Shop {
    Scanner sc = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("#,###.##");

    private int[] itemPrice = {
        450,    // Small Health Potion
        1350,   // Medium Health Potion
        2750,   // Large Health Potion
        450,    // Small Mana Potion
        1350,   // Medium Mana Potion
        2750    // Large Mana Potion
    };

    private String[] item = {
        "Small Health Potion",
        "Medium Health Potion",
        "Large Health Potion",
        "Small Mana Potion",
        "Medium Mana Potion",
        "Large Mana Potion"
    };

    public void shop(Hero hero) {
        int choice = 0, select = 0;
        System.out.println();
        System.out.println();
        while(true){
            while(true){
                try{
                    System.out.println();
                    System.out.println();
                    System.out.println(" \tGold: " + df.format(hero.getGold()));
                    System.out.println(" \t┌─────────────────────────────────────────────────────────────────────────────┐");
                    System.out.println(" \t│                                                                             │");
                    System.out.println(" \t│                                                                             │");
                    System.out.println(" \t│                      WELCOME TO MYSTVALE ACADEMY SHOP                       │");
                    System.out.println(" \t│                                                                             │");
                    System.out.println(" \t│                                                                             │");
                    System.out.println(" \t│                   What would you like to purchase today?                    │");
                    System.out.println(" \t│                                                                             │");
                    System.out.println(" \t│                                                                             │");
                    System.out.println(" \t│       ┌─────────────────────────────┐  ┌─────────────────────────────┐      │");
                    System.out.println(" \t│       |   [1] Small Health Potion   |  |   [4] Small Mana Potion     |      │");
                    System.out.println(" \t│       |   [Price: 450g]             |  |   [Price: 450g]             |      │");
                    System.out.println(" \t│       └─────────────────────────────┘  └─────────────────────────────┘      │");
                    System.out.println(" \t│       ┌─────────────────────────────┐  ┌─────────────────────────────┐      │");
                    System.out.println(" \t│       |   [2] Medium Health Potion  |  |   [5] Medium Mana Potion    |      │");
                    System.out.println(" \t│       |   [Price: 1,350g]           |  |   [Price: 1,350g]           |      │");
                    System.out.println(" \t│       └─────────────────────────────┘  └─────────────────────────────┘      │");
                    System.out.println(" \t│       ┌─────────────────────────────┐  ┌─────────────────────────────┐      │");
                    System.out.println(" \t│       |   [3] Large Health Potion   |  |   [6] Large Mana Potion     |      │");
                    System.out.println(" \t│       |   [Price: 2,750g]           |  |   [Price: 2,750g]           |      │");
                    System.out.println(" \t│       └─────────────────────────────┘  └─────────────────────────────┘      │");
                    System.out.println(" \t│                                ┌────────────┐                               │");
                    System.out.println(" \t│                                |  [7] EXIT  |                               │");
                    System.out.println(" \t│                                └────────────┘                               │");
                    System.out.println(" \t└─────────────────────────────────────────────────────────────────────────────┘");
                    System.out.println("  \t  ___________________________________________________________________________");
                    System.out.println("  \t \\ \\                                                                       / /");
                    System.out.println("  \t  \\_\\_____________________________________________________________________/_/");
                    System.out.println("  \t        | │                                                         │ |");
                    System.out.println("  \t        |_│_________________________________________________________│_|");
                    System.out.println("  \t         \\___________________________________________________________/");
                    System.out.print(">>> ");
                    choice = sc.nextInt();

                    if(choice < 1 || choice > 7){
                        System.out.println("\nInvalid choice. Please enter a number between 1 and 7.\n\n");
                        continue;
                    }

                    break;

                } catch (Exception e) {
                    System.out.println("\nInvalid input. Please enter a number corresponding to your choice.\n\n");
                    sc.nextLine(); // Clear the invalid input
                }
            }

            if(choice == 7){
                System.out.println();
                System.out.println();
                System.out.println("\nThank you for visiting Mystvale Academy Shop! See you again!\n\n");
                return;
            }

            boolean loop = true;
            while(loop) {    
                while(true){
                    try{
                        System.out.println();
                        System.out.println("You have selected: " + getItem(choice));
                        System.out.println("[1] Purchase Item");
                        System.out.println("[2] View Item Details");
                        System.out.println("[3] Cancel");
                        System.out.print(">>> ");
                        select = sc.nextInt();

                        if(select < 1 || select > 3){
                            System.out.println("\nInvalid choice. Please enter a number between 1 and 3.\n\n");
                            continue;
                        }

                        break;

                    } catch (Exception e) {
                        System.out.println("\nInvalid input. Please enter a number corresponding to your choice.\n\n");
                        sc.nextLine(); // Clear the invalid input
                    }
                }
                
                switch(select){
                    case 1:
                        purchaseItem(hero, choice);
                        loop = false;
                        break;
                    case 2:
                        itemDetails(choice);
                        break;
                    case 3:
                        System.out.println("\nTransaction cancelled.\n\n");
                        loop = false;
                        break;
                }
            }
        }
    }

    public void itemDetails(int choice) {
        System.out.println();

        switch (choice) {
            case 1 -> System.out.println("Small Health Potion: Restores 20% HP.");
            case 2 -> System.out.println("Medium Health Potion: Restores 45% HP.");
            case 3 -> System.out.println("Large Health Potion: Restores 70% HP.");
            case 4 -> System.out.println("Small Mana Potion: Restores 20% Mana.");
            case 5 -> System.out.println("Medium Mana Potion: Restores 45% Mana.");
            case 6 -> System.out.println("Large Mana Potion: Restores 70% Mana.");
            default -> System.out.println("Invalid choice.");
        }

        System.out.println();
    }

    public void purchaseItem(Hero hero, int choice) {
        int amount = 0;
        int price = getItemPrice(choice);
        String confirmation = "";

        Inventory inv = hero.getInventory();

        if(hero.getGold() < price) {
            System.out.println("\nYou do not have enough gold to purchase " + getItem(choice) + ".\n");
            return;
        }

        // Ask for amount
        while (true) {
            try {
                System.out.print("\n\nEnter Amount to Purchase: ");
                amount = sc.nextInt();

                if (amount <= 0) {
                    System.out.println("\nInvalid amount. Please enter a positive number.\n\n");
                    continue;
                }

                if (amount > 99) {
                    System.out.println("\nYou can only store up to 99 " + getItem(choice) + ".\n\n");
                    continue;
                }

                break;
            } catch (Exception e) {
                System.out.println("\nInvalid input. Please enter a valid amount.\n\n");
                sc.nextLine();
            }
        }

        // Check capacity depending on the item
        int current = switch (choice) {
            case 1 -> inv.getSmallHealthPotion();
            case 2 -> inv.getMediumHealthPotion();
            case 3 -> inv.getLargeHealthPotion();
            case 4 -> inv.getSmallManaPotion();
            case 5 -> inv.getMediumManaPotion();
            case 6 -> inv.getLargeManaPotion();
            default -> 0;
        };

        int capacity = inv.getCapacity();
        int availableCapacity = capacity - current;

        if (amount > availableCapacity) {
            System.out.println("\nYou can only purchase " + availableCapacity + " more " + getItem(choice) + "(s).\n");
            return;
        }

        // Check gold for total amount
        int totalCost = price * amount;

        if (hero.getGold() < totalCost) {
            System.out.println("\nYou do not have enough gold.\n");
            return;
        }

        // Confirm purchase
        while (true) {
            System.out.println("\nYou are about to purchase " + amount + " " + getItem(choice) + "(s) for " + df.format(totalCost) + "g.");
            System.out.print("Confirm Purchase? (Y/N): ");
            confirmation = sc.next().trim().toUpperCase();

            if (confirmation.equals("Y") || confirmation.equals("N"))
                break;

            System.out.println("Invalid input. Please enter Y or N.");
        }

        if (confirmation.equals("N")) {
            System.out.println("\nPurchase cancelled.\n\n");
            return;
        }

        // Deduct gold
        hero.setGold(hero.getGold() - totalCost);

        // Add items
        switch (choice) {
            case 1 -> inv.setSmallHealthPotion(current + amount);
            case 2 -> inv.setMediumHealthPotion(current + amount);
            case 3 -> inv.setLargeHealthPotion(current + amount);
            case 4 -> inv.setSmallManaPotion(current + amount);
            case 5 -> inv.setMediumManaPotion(current + amount);
            case 6 -> inv.setLargeManaPotion(current + amount);
        }

        System.out.println("\nPurchased " + amount + " " + getItem(choice) + "(s) for " + df.format(totalCost) + "g.");
    }

    public int getItemPrice(int choice) {
        return itemPrice[choice - 1];
    }

    public String getItem(int choice) {
        return item[choice - 1];
    }
}
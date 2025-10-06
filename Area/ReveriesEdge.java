package Area;
import BattleMechanics.BattleMechanic;
import java.util.Random;
import java.util.Scanner;

public class ReveriesEdge {
    static Random rand = new Random();
    static Scanner scan = new Scanner(System.in);

    public void enter() {
        System.out.println();
        System.out.println("┌────────────────────────────────────────────┐");
        System.out.println("│       You have entered Reverie's Edge      │");
        System.out.println("└────────────────────────────────────────────┘");
        System.out.println();

        exploreEntry();
    }

    public void exploreEntry() {
        System.out.print("\nDo you want to explore Reverie's Edge? (y/n): ");
        char choice = scan.next().toLowerCase().charAt(0);
        System.out.println();

        if (choice == 'y') {
            System.out.println("You step forward into the mysterious boundary of dreams and shadows...");
            exploreOutsideArea();
        } else if (choice == 'n') {
            System.out.println("You chose not to explore Reverie's Edge.");
            exit();
        } else {
            System.out.println("Invalid choice. Please enter 'y' or 'n'.");
            System.out.println();
            exploreEntry();
        }
    }

    public void exploreOutsideArea() {
        boolean valid = true;
        boolean explore = true;

        System.out.println();
        if (explore) {
            if (rand.nextBoolean()) {
                System.out.println("As you walk along the faintly glowing mist, a strange creature emerges from the fog!");
            } else {
                System.out.println("You wander along the shimmering horizon, the air quiet but heavy with tension.");
            }
        }
        System.out.println();

        while (valid) {
            System.out.print("Do you want to continue exploring? (y/n): ");
            char choice = scan.next().toLowerCase().charAt(0);

            if (choice == 'y') {
                exploreMiddleArea();
                valid = false;
            } else if (choice == 'n') {
                System.out.println("\nYou decide to step back toward the dream's entrance.");
                valid = false;
                exploreEntry();
            } else {
                System.out.println("Invalid choice. Please enter 'y' or 'n'.");
                System.out.println();
            }
        }
    }

    public void exploreMiddleArea() {
        boolean valid = true;
        boolean explore = true;

        System.out.println();
        if (explore) {
            if (rand.nextBoolean()) {
                System.out.println("You feel a ripple in the air — a shadowy entity materializes before you!");
            } else {
                System.out.println("The wind whispers faint voices; the path ahead is still, almost frozen in time.");
            }
        }
        System.out.println();

        while (valid) {
            System.out.print("Do you want to continue exploring? (y/n): ");
            char choice = scan.next().toLowerCase().charAt(0);

            if (choice == 'y') {
                exploreInnerArea();
                valid = false;
            } else if (choice == 'n') {
                System.out.println("\nYou choose to retreat and return to the calmer outskirts.");
                valid = false;
                exploreOutsideArea();
            } else {
                System.out.println("Invalid choice. Please enter 'y' or 'n'.");
                System.out.println();
            }
        }
    }

    public void exploreInnerArea() {
        boolean valid = true;
        boolean explore = true;
        BattleMechanic battle = new BattleMechanic();

        System.out.println();
        if (explore) {
            if (rand.nextBoolean()) {
                System.out.println("As you step onto the crystalline cliff of Reverie's Edge,\n"
                        + "a surge of dark energy bursts forth—an ELITE foe emerges from the rift!");
            } else {
                System.out.println("You gaze over the edge—beyond lies only darkness and fragments of dreams lost to time.");
            }
        }
        System.out.println();

        String[] morgrath = {
            "\nThe air begins to distort around you...",
            "You hear faint echoes of voices calling your name.",
            "A shape forms out of the swirling mist—it carries a blade woven from dreams themselves.",
            "The ground trembles as the creature steps forward.",
            "The Guardian of the Edge, Morgrath, reveals itself!"
        };

        playSection(morgrath);

        while (valid) {
            System.out.print("Do you want to fight the Guardian, Morgrath? (y/n): ");
            char choice = scan.next().toLowerCase().charAt(0);

            if (choice == 'y') {
                System.out.println();
                System.out.println("┌────────────────────┐");
                System.out.println("│       BATTLE       │");
                System.out.println("└────────────────────┘");
                battle.fight();
                valid = false;
            } else if (choice == 'n') {
                System.out.println("\nYou decide to step away from Morgrath and return to safer grounds.");
                valid = false;
                exploreMiddleArea();
            } else {
                System.out.println("Invalid choice. Please enter 'y' or 'n'.");
                System.out.println();
            }
        }
    }

    public static void playSection(String[] section) {
        System.out.println("Press ENTER to continue...");

        for (int i = 0; i < section.length; i++) {
            scan.nextLine();
            System.out.println(section[i]);
        }

        System.out.println();
    }

    public void exit() {
        System.out.println();
        System.out.println("┌────────────────────────────────────────────┐");
        System.out.println("│           <<< Location Exited >>>          │");
        System.out.println("│        You have left Reverie's Edge.       │");
        System.out.println("└────────────────────────────────────────────┘");
        System.out.println();
    }


}

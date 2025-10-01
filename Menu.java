//import java.util.Scanner;

// Things to polish: 
// Mechanism of the menu in terms of hopping from one menu to another // DONE
// Restriction on some functions
// Correct the repetition in narration restrictions DONE
// Other function needed:
// Shops
// Inventory
// Select Character Prompt DONE

/*public class Menu extends Narration {
    static Scanner scanner = new Scanner(System.in);

    //Change these variables to private once encasulation is implemented (i think)
    static boolean hasVisitedShop = false;
    static boolean hasOpenedInventory = false;
    //static boolean hasVisitedPrologue = false;
    static boolean hasVisitedAcademy = false;
    static boolean hasVisitedLibrary = false;
    static boolean hasVisitedCanteen = false;
    static boolean hasVisitedGym = false;
    static boolean hasVisitedOffice = false;
    static boolean hasVisitedArea1 = false;
    static boolean hasVisitedArea2 = false;
    static boolean hasVisitedArea3 = false;

    public void defaultMainMenu(){
        boolean runMainMenu = true;
        AcademyMenu handler = new AcademyMenu();
        ForestOfReverie forest = new ForestOfReverie();
        
        while(runMainMenu){
            System.out.println("+------------------------------------------+");
            System.out.println("|  --- MYSTVALE ACADEMY MAIN MENU ---      |");
            System.out.println("+------------------------------------------+");
            System.out.println("| 1. Go to Academy                         |");
            System.out.println("| 2. Shop                                  |");
            System.out.println("| 3. Inventory                             |");
            System.out.println("| 4. The Forest of Reverie                 |");
            System.out.println("| 5. The Reverie Edge                      |");
            System.out.println("| 6. The Forsaken Lands                    |");
            System.out.println("| 7. Exit Game                             |");
            System.out.println("+------------------------------------------+");
            System.out.println("      ┌──────────────────────────────┐");
            System.out.println("      │   Where do you want to go?   │");
            System.out.println("      └──────────────────────────────┘");
            System.out.print("      >>> ");

            
            String mainMenuChoice = scanner.nextLine();
            
            System.out.println();
            
            switch (mainMenuChoice){
                case "1":
                    if (!hasVisitedAcademy && !NarrationSkipper.askToSkipNarration()) {
                        academyNarration();
                    } else {
                        System.out.println();
                        System.out.println("┌──────────────────────────────────────────────┐");
                        System.out.println("│        You are now inside the Academy        │");
                        System.out.println("└──────────────────────────────────────────────┘");
                    }

                    hasVisitedAcademy = true;

                    handler.academyMapMenu();
                    
                    break;

                case "2":
                    if (!hasVisitedShop && !NarrationSkipper.askToSkipNarration()) {
                        shopNarration();
                    } else {
                        System.out.println();
                        System.out.println("┌──────────────────────────┐");
                        System.out.println("│    Welcome to the shop   │");
                        System.out.println("└──────────────────────────┘");
                    }

                    hasVisitedShop = true;
                    
                    //shopFunction();
                    break;

                case "3":
                    boolean isInventoryEmpty = false;

                    if (!hasOpenedInventory && !NarrationSkipper.askToSkipNarration()) {
                        inventoryNarration();
                    } else {
                        System.out.println();
                        System.out.println("┌────────────────────────────────────┐");
                        System.out.println("│       This is your invetory        │");
                        System.out.println("└────────────────────────────────────┘");
                    }
                    
                    if(!isInventoryEmpty){
                        System.out.println("┌───────────────────────────────────────┐");
                        System.out.println("│      Hmmm. Nothing to see here.       │");
                        System.out.println("│   Go shop if you want to own items.   │");
                        System.out.println("└───────────────────────────────────────┘");
                    } else{
                        //inventoryFunction();
                    }

                    hasOpenedInventory = true;
                    break;

                case "4":
                    
                    // add restriction

                    if (!hasVisitedArea1 && !NarrationSkipper.askToSkipNarration()) {
                        area1Narration();
                    } else {
                        System.out.println();
                        System.out.println("┌────────────────────────────────────┐");
                        System.out.println("│      Beware of forest entities     │");
                        System.out.println("└────────────────────────────────────┘");
                    }

                    hasVisitedArea1 = true;
                    forest.enter();
                    break;
                    
                case "5":
                    
                    // add restriction

                    if (!hasVisitedArea2 && !NarrationSkipper.askToSkipNarration()) {
                        area2Narration();
                    } else {
                        System.out.println();
                        System.out.println("┌────────────────────────────────┐");
                        System.out.println("│    Beware of swamp entities    │");
                        System.out.println("└────────────────────────────────┘");
                    }

                    hasVisitedArea2 = true;
                    break;
                    
                case "6":
                    
                    // add restriction
                    
                    if (!hasVisitedArea3 && !NarrationSkipper.askToSkipNarration()) {
                        area3Narration();
                    } else {
                        System.out.println();
                        System.out.println("┌──────────────────────────────────────────────────┐");
                        System.out.println("│    Warning! You may or may not come out alive    │");
                        System.out.println("└──────────────────────────────────────────────────┘");
                    }

                    hasVisitedArea3 = true;
                    
                    break;

                case "7":
                    System.out.println("┌──────────────────────────────────────────────────────────┐");
                    System.out.println("│       Are you sure you want to quit playing? (y/n)       │");
                    System.out.println("└──────────────────────────────────────────────────────────┘");
                    System.out.print(">>> ");
                    
                    String ifWantToQuit = scanner.nextLine();

                    switch (ifWantToQuit.toLowerCase()) {
                        case "y":
                            System.out.println();
                            System.out.println("┌────────────┐");
                            System.out.println("│ Good Game! │");
                            System.out.println("└────────────┘");
                            System.exit(0);
                            break;

                        case "n":
                            System.out.println();
                            System.out.println("┌────────────────────────────┐");
                            System.out.println("│  Returning to Main Menu... │");
                            System.out.println("└────────────────────────────┘");
                            break;

                        default:
                            System.out.println();
                            System.out.println("┌────────────────────────────┐");
                            System.out.println("│  Invalid input. Try again! │");
                            System.out.println("└────────────────────────────┘");
                            break;
                    }
                    break;

                default:
                    System.out.println();
                    System.out.println("┌─────────────────────────────┐");
                    System.out.println("│  Invalid choice. Try again! │");
                    System.out.println("└─────────────────────────────┘");
            }
        }
        
    }
    
}
*/

/* 
class StartMenu extends Narration { 
    
    static Scanner scan = new Scanner(System.in);
    static boolean hasVisitedPrologue = false;

    public void displayStartMenu(){
        CharacterMenu charHandler = new CharacterMenu();

        boolean play = true;

        while(play){
            System.out.println("+------------------------------+");
            System.out.println("|        Mystvale Academy      |");
            System.out.println("+------------------------------+");
            System.out.println("|    A Text-Based Adventure    |");
            System.out.println("|  in a World of Sorcery and   |");
            System.out.println("|         Shadowed Halls       |");
            System.out.println("+------------------------------+");
            System.out.println("|          1. Start Game       |");
            System.out.println("|          2. Exit Game        |");
            System.out.println("+------------------------------+");
            System.out.print(">>> ");

            String startMenuChoice = scan.nextLine();

            switch (startMenuChoice) {
                case "1":
                    System.out.println();
                    System.out.println("┌─────────────────────────┐");
                    System.out.println("│   Starting the game...  │");
                    System.out.println("└─────────────────────────┘");

                    if (!hasVisitedPrologue && !NarrationSkipper.askToSkipNarration()) {
                        prologueNarration();
                    } else {
                        System.out.println();
                        System.out.println("┌──────────────────────────────────────────────┐");
                        System.out.println("│          Choose a character to play          │");
                        System.out.println("└──────────────────────────────────────────────┘");
                    }

                    hasVisitedPrologue = true;

                    charHandler.chooseCharacterMenu();
                    //menuHandler.defaultMainMenu();
                    break;

                case "2":
                    System.out.println();
                    System.out.println("┌───────────┐");
                    System.out.println("│  Goodbye! │");
                    System.out.println("└───────────┘");
                    play = false;
                    break;

                default:
                    System.out.println();
                    System.out.println("┌─────────────────────────────┐");
                    System.out.println("│  Invalid choice. Try again! │");
                    System.out.println("└─────────────────────────────┘");
                    break;
            }
                
        }
    }
}
*/

/* 
class AcademyMenu extends Menu{
    public void academyMapMenu() {
        boolean academyMapMenu = true;

        while (academyMapMenu) {
            System.out.println("+-------------------------------------+");
            System.out.println("|  --- MYSTVALE ACADEMY MAP MENU ---  |");
            System.out.println("+-------------------------------------+");
            System.out.println("| 1. Library                          |");
            System.out.println("| 2. Canteen                          |");
            System.out.println("| 3. Gym                              |");
            System.out.println("| 4. Principal's Office               |");
            System.out.println("| 5. Exit Current Location            |");
            System.out.println("| 6. Main Menu                        |");
            System.out.println("+-------------------------------------+");
            System.out.print(">>> ");

            String academyMapMenuChoice = scanner.nextLine();

            switch (academyMapMenuChoice) {
                case "1":

                    if (!hasVisitedLibrary && !NarrationSkipper.askToSkipNarration()) {
                        libraryNarration();
                    } else {
                        System.out.println();
                        System.out.println("┌──────────────────────────────────────────────┐");
                        System.out.println("│        You are now inside the Library        │");
                        System.out.println("└──────────────────────────────────────────────┘");
                    }

                    System.out.println("┌──────────────────────────────────────────────┐");
                    System.out.println("│     Shh! Be mindful, others are studying     │");
                    System.out.println("└──────────────────────────────────────────────┘");
                    System.out.println();
                    
                    hasVisitedLibrary = true;
                    break;

                case "2":
                
                    if (!hasVisitedCanteen && !NarrationSkipper.askToSkipNarration()) {
                        canteenNarration();
                    } else {
                        System.out.println();
                        System.out.println("┌──────────────────────────────────────────────┐");
                        System.out.println("│        You are now inside the Canteen        │");
                        System.out.println("└──────────────────────────────────────────────┘");
                    }

                    System.out.println("┌────────────────────────────┐");
                    System.out.println("│    Buy at your own risk    │");
                    System.out.println("└────────────────────────────┘");
                    System.out.println();

                    hasVisitedCanteen = true;

                    break;

                case "3":
                    if (!hasVisitedGym && !NarrationSkipper.askToSkipNarration()) {
                        gymNarration();
                    } else {
                        System.out.println();
                        System.out.println("┌──────────────────────────────────────────────┐");
                        System.out.println("│    You are now inside the Training Ground    │");
                        System.out.println("└──────────────────────────────────────────────┘");
                    }

                    System.out.println("┌────────────────────────────────────────────┐");
                    System.out.println("│             Be ready to train              │");
                    System.out.println("└────────────────────────────────────────────┘");
                    System.out.println();

                    hasVisitedGym = true;

                    break;

                case "4":
                    
                    // add restrictions
                    
                    if (!hasVisitedOffice && !NarrationSkipper.askToSkipNarration()) {
                        principalOfficeNarration();
                    } else {
                        System.out.println();
                        System.out.println("┌──────────────────────────────────────────────┐");
                        System.out.println("│         You are now inside the Office        │");
                        System.out.println("└──────────────────────────────────────────────┘");
                    }

                    System.out.println("┌────────────────────────────────────────────┐");
                    System.out.println("│       May the odds be in your favor        │");
                    System.out.println("└────────────────────────────────────────────┘");
                    System.out.println();

                    hasVisitedOffice = true;
                    break;

                case "5":
                    System.out.println();
                    System.out.println("┌───────────────────────────────────────────┐");
                    System.out.println("│    You have left your current location    │");
                    System.out.println("└───────────────────────────────────────────┘");

                    academyMapMenu = false;
                    
                    // Polish this part
                    //defaultMainMenu();
                    //academyMapMenu();
                    break;
                    
                case "6":
                    academyMapMenu = false;
                    //defaultMainMenu();
                    break;

                default:
                    System.out.println();
                    System.out.println("┌─────────────────────────────┐");
                    System.out.println("│  Invalid choice. Try again! │");
                    System.out.println("└─────────────────────────────┘");
            }
        }    
    }
}
*/


/*class CharacterMenu extends Narration{
    public void chooseCharacterMenu(){
        Menu menuHandler = new Menu();

        System.out.println("+------------------------------+");
        System.out.println("|      Choose a character      |");
        System.out.println("|------------------------------|");
        System.out.println("|  1. Swordsman                |");
        System.out.println("|  2. Gunner                   |");
        System.out.println("|  3. Mage                     |");
        System.out.println("+------------------------------+");
        System.out.print(">>> ");

        char characterChoice = scanner.next().charAt(0);

        switch(characterChoice){
            case '1':            
                choiceSwordsman();
                menuHandler.defaultMainMenu();
                break;

            case '2':
                choiceGunner();
                menuHandler.defaultMainMenu();
                break;

            case '3':    
                choiceMage();
                menuHandler.defaultMainMenu();
                break;

            default:
                System.out.println();
                System.out.println("┌─────────────────────────────┐");
                System.out.println("│  Invalid choice. Try again! │");
                System.out.println("└─────────────────────────────┘");
                chooseCharacterMenu();
        }    
    }
}

class NarrationSkipper {

    static Scanner scanner = new Scanner(System.in);

    public static boolean askToSkipNarration() {
        boolean validInput = false;
        boolean skip = false;

        while (!validInput) {
            System.out.println();
            System.out.println("┌──────────────────────────────────────────────┐");
            System.out.println("│     Do you want to skip narration? (y/n):    │");
            System.out.println("└──────────────────────────────────────────────┘");
            System.out.print(">>> ");

            char skipChoice = scanner.next().charAt(0);

                switch (skipChoice) {
                    case 'y':
                        skip = true;
                        validInput = true;
                        break;
                    case 'n':
                        skip = false;
                        validInput = true;
                        break;
                    default:
                        System.out.println();
                        System.out.println("┌──────────────────────────────────────────────┐");
                        System.out.println("│   Invalid choice! Please enter 'y' or 'n'    │");
                        System.out.println("└──────────────────────────────────────────────┘");
                        break;
                }
        }

        return skip;
    }
}
*/
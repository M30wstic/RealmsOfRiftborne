package Menu;

public class AcademyMenu extends Menu{

    private boolean hasVisitedLibrary = false; // not used. was used in academy
    private boolean hasVisitedCanteen = false; // not used. was used in academy
    private boolean hasVisitedGym = false; // not used. was used in academy
    private boolean hasVisitedOffice = false; // not used. was used in academy

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

                    if(!hasVisitedLibrary){
                        libraryNarration();
                        hasVisitedLibrary = true;
                    }

                    System.out.println();
                    System.out.println("┌──────────────────────────────────────────────┐");
                    System.out.println("│        You are now inside the Library        │");
                    System.out.println("└──────────────────────────────────────────────┘");
                    System.out.println("┌──────────────────────────────────────────────┐");
                    System.out.println("│     Shh! Be mindful, others are studying     │");
                    System.out.println("└──────────────────────────────────────────────┘");
                    System.out.println();
                    break;
                 
                case "2":
                    if (!hasVisitedCanteen) {
                        canteenNarration();
                        hasVisitedCanteen = true;
                    } 

                    System.out.println();
                    System.out.println("┌──────────────────────────────────────────────┐");
                    System.out.println("│        You are now inside the Canteen        │");
                    System.out.println("└──────────────────────────────────────────────┘");
                    System.out.println("┌────────────────────────────┐");
                    System.out.println("│    Buy at your own risk    │");
                    System.out.println("└────────────────────────────┘");
                    System.out.println();

                    break;

                case "3":
                    if (!hasVisitedGym) {
                        gymNarration();
                        hasVisitedGym = true;
                    } 
                        
                    System.out.println();
                    System.out.println("┌──────────────────────────────────────────────┐");
                    System.out.println("│    You are now inside the Training Ground    │");
                    System.out.println("└──────────────────────────────────────────────┘");
                    System.out.println("┌────────────────────────────────────────────┐");
                    System.out.println("│             Be ready to train              │");
                    System.out.println("└────────────────────────────────────────────┘");
                    System.out.println();
                    break;

                case "4":
                    
                    // add restrictions
                    
                    if (!hasVisitedOffice) {
                        principalOfficeNarration();
                        hasVisitedOffice = true;
                    } 

                    System.out.println();
                    System.out.println("┌──────────────────────────────────────────────┐");
                    System.out.println("│         You are now inside the Office        │");
                    System.out.println("└──────────────────────────────────────────────┘");
                    System.out.println("┌────────────────────────────────────────────┐");
                    System.out.println("│       May the odds be in your favor        │");
                    System.out.println("└────────────────────────────────────────────┘");
                    System.out.println();
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
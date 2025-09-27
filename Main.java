import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StartMenu startMenu = new StartMenu();
        CharacterMenu characterMenuHandler = new CharacterMenu();
        Menu menu = new Menu();
        
        startMenu.displayStartMenu();
        characterMenuHandler.chooseCharacterMenu();
        menu.defaultMainMenu();

        scan.close();
        return;
    }
}
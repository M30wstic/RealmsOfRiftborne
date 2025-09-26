import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StartMenu startMenu = new StartMenu();
        
        startMenu.displayStartMenu();

        scan.close();
        return;
    }
}
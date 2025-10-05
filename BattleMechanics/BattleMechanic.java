package BattleMechanics;
import Hero.Swordsman;
import Boss.Elderthorn;
import java.util.Scanner;
import java.util.Random;

public class BattleMechanic {
    static Scanner scanner = new Scanner(System.in);
    static Random rand = new Random();
    static Swordsman player = new Swordsman();
    static Elderthorn enemy = new Elderthorn();
    static BattleMechanic cd = new BattleMechanic();
    private static int cooldown1 = 0;
    private static int cooldown2 = 0;
    private static int cooldownU = 0;
    private static int enemyCooldown1 = 0;
    private static int enemyCooldown2 = 0;
    private static int enemyCooldown3 = 0;
    private static int enemyCooldownU = 0;

    public void fight(){
        while(player.getHp() > 0 && enemy.getHp() > 0){
            // Player's turn
            System.out.println("\nPlayer HP: " + player.getHp() + " | Player Mana: " + player.getMana() + " || Enemy HP: " + enemy.getHp() + " | Enemy Mana: " + enemy.getMana());
            System.out.println("+-------------------------------------------------------------------+");
            System.out.println("Choose your attack:");
            System.out.println();
            System.out.println("1. Basic Attack");
            System.out.println("2. Skill 1 - "+ player.getSkill1() + " (Mana Cost: " + player.getManaCostSkill1() + ") (Cooldown: " + cd.getCooldown1() + ")");
            System.out.println("3. Skill 2 - "+ player.getSkill2() + " (Mana Cost: " + player.getManaCostSkill2() + ") (Cooldown: " + cd.getCooldown2() + ")");
            System.out.println("4. Ultimate - "+ player.getUltimate() + " (Mana Cost: " + player.getManaCostUltimate() + ") (Cooldown: " + cd.getCooldownU() + ")");
            System.out.println("+-------------------------------------------------------------------+");
            System.out.print(">>> ");
            int choice = scanner.nextInt();

            System.out.println();

            boolean valid = castAttack(choice);

            if (!valid) {
                // Skip enemy turn, let player retry instead
                continue;
            }
            
            // Check if enemy is defeated
            if(enemy.getHp() <= 0){
                System.out.println("Enemy has been defeated!");
                return;
            }

            System.out.println();

            // Enemy's turn
            enemyCastAttack();
            

            // Check if player is defeated
            if(player.getHp() <= 0){
                System.out.println("Player has been Defeated");
                return;
            }
        }
    }

    public static boolean castAttack (int choice) {
        int damage = 0;

        switch (choice) {
            case 1:
                damage = player.basicAttack();
                break;

            case 2:
                if (player.getMana() < player.getManaCostSkill1()) {
                    System.out.println("Not enough mana!");
                    return false;
                }
                if (cd.getCooldown1() == 0) {
                    damage = player.skill1();
                    cd.setCooldown1(2);
                } else {
                    System.out.println("Skill 1 is on cooldown for " + cd.getCooldown1() + " more turn(s).");
                    return false;
                }
                break;

            case 3:
                if (player.getMana() < player.getManaCostSkill2()) {
                    System.out.println("Not enough mana!");
                    return false;
                }
                if (cd.getCooldown2() == 0) {
                    damage = player.skill2();
                    cd.setCooldown2(3);
                } else {
                    System.out.println("Skill 2 is on cooldown for " + cd.getCooldown2() + " more turn(s).");
                    return false;
                }
                break;

            case 4:
                if (player.getMana() < player.getManaCostUltimate()) {
                    System.out.println("Not enough mana!");
                    return false;
                }
                if (cd.getCooldownU() == 0) {
                    damage = player.ultimate();
                    cd.setCooldownU(5);
                } else {
                    System.out.println("Ultimate is on cooldown for " + cd.getCooldownU() + " more turn(s).");
                    return false;
                }
                break;

            default:
                System.out.println("Invalid choice. Please select a valid attack.");
                return false;
        }

        // Reduce cooldowns
        if (cd.getCooldown1() > 0) cd.setCooldown1(cd.getCooldown1() - 1);
        if (cd.getCooldown2() > 0) cd.setCooldown2(cd.getCooldown2() - 1);
        if (cd.getCooldownU() > 0) cd.setCooldownU(cd.getCooldownU() - 1);

        // Apply damage
        enemy.setHp(enemy.getHp() - damage);

        return true; // valid attack
    }

    public static void enemyCastAttack() { 
        int damage = 0;

        System.out.println("Enemy's turn:");

        while (true) { // loop until enemy does a valid action
            int choice = rand.nextInt(1, 6); // Random choice between 1 and 5

            switch (choice) {
                case 1:
                    // Basic attack is always valid
                    damage = enemy.basicAttack();
                    break;

                case 2:
                    if (enemy.getMana() >= enemy.getManaCostSkill1() && cd.getEnemyCooldown1() == 0) {
                        damage = enemy.skill1();
                        cd.setEnemyCooldown1(2);
                    } else {
                        continue; // try another choice
                    }
                    break;

                case 3:
                    if (enemy.getMana() >= enemy.getManaCostSkill2() && cd.getEnemyCooldown2() == 0) {
                        damage = enemy.skill2();
                        cd.setEnemyCooldown2(5);
                    } else {
                        continue;
                    }
                    break;

                case 4:
                    if (enemy.getMana() >= enemy.getManaCostSkill3() && cd.getEnemyCooldown3() == 0) {
                        damage = enemy.skill3();
                        cd.setEnemyCooldown3(5);
                    } else {
                        continue;
                    }
                    break;

                case 5:
                    if (enemy.getMana() >= enemy.getManaCostUltimate() && cd.getEnemyCooldownU() == 0) {
                        damage = enemy.ultimate();
                        cd.setEnemyCooldownU(7);
                    } else {
                        continue;
                    }
                    break;
            }

            // If we reached here → attack was valid
            break;
        }

        // Reduce cooldowns after enemy's action
        if (cd.getEnemyCooldown1() > 0) cd.setEnemyCooldown1(cd.getEnemyCooldown1() - 1);
        if (cd.getEnemyCooldown2() > 0) cd.setEnemyCooldown2(cd.getEnemyCooldown2() - 1);
        if (cd.getEnemyCooldown3() > 0) cd.setEnemyCooldown3(cd.getEnemyCooldown3() - 1);
        if (cd.getEnemyCooldownU() > 0) cd.setEnemyCooldownU(cd.getEnemyCooldownU() - 1);

        // Apply damage to player
        player.setHp(player.getHp() - damage);
    }


    //setters and getters for cooldowns
    public void setCooldown1(int cd1) {
        cooldown1 = cd1;
    }

    public void setCooldown2(int cd2) {
        cooldown2 = cd2;
    }

    public void setCooldownU(int cdU) {
        cooldownU = cdU;
    }

    public void setEnemyCooldown1(int cd1) {
        enemyCooldown1 = cd1;
    }

    public void setEnemyCooldown2(int cd2) {
        enemyCooldown2 = cd2;
    }

    public void setEnemyCooldown3(int cd3) {
        enemyCooldown3 = cd3;
    }

    public void setEnemyCooldownU(int cdU) {
        enemyCooldownU = cdU;
    }

    public int getCooldown1() {
        return cooldown1;
    }

    public int getCooldown2() {
        return cooldown2;
    }

    public int getCooldownU() {
        return cooldownU;
    }

    public int getEnemyCooldown1(){
        return enemyCooldown1;
    }

    public int getEnemyCooldown2(){
        return enemyCooldown2;
    }

    public int getEnemyCooldown3(){
        return enemyCooldown3;
    }

    public int getEnemyCooldownU(){
        return enemyCooldownU;
    }
}
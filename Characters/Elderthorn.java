import java.util.Random;

public class Elderthorn {
    static Random rand = new Random();
    private int hp;
    private int attack;
    private int mana;
    private int defense;
    private int speed;
    private String name;


    private int thornSlashCd = 0;
    private int eternalWildstormCd = 0;

    public Elderthorn() {
        this.hp = 10000;
        this.attack = 450;
        this.mana = 1000;
        this.defense = 150;
        this.speed = 20;
        this.name = "Elderthorn";
    }


    public void reduceCooldownsElderthorn() {
        if (thornSlashCd > 0) thornSlashCd--;
        if (eternalWildstormCd > 0) eternalWildstormCd--;
    }


    public int thornSlash() {
        int min = attack;          
        int max = attack + 100;    

        if (thornSlashCd > 0) {
            System.out.println(name + " tried Thorn Slash, but it's on cooldown for " + thornSlashCd + " more rounds!");
            return 0;
        }

        if (mana >= 300) { 
            mana -= 300;
            int damage = rand.nextInt(max - min + 1) + min;
            System.out.println(name + " used Thorn Slash! Damage: " + damage);
            thornSlashCd = 3; 
            return damage;
        } else {
            System.out.println(name + " does not have enough mana! ");
            return 0;
        }
    }


    public int eternalWildstorm() {
        int min = attack * 2;      
        int max = attack * 3;

        if (eternalWildstormCd > 0) {
            System.out.println(name + " tried Eternal Wildstorm, but it's on cooldown for " + eternalWildstormCd + " more rounds!");
            return 0;
        }

        if (mana >= 600) {
            mana -= 600;
            int damage = rand.nextInt(max - min + 1) + min;
            System.out.println(name + " unleashed Eternal Wildstorm! Damage: " + damage);
            eternalWildstormCd = 5;
            return damage;
        } else {
            System.out.println(name + " does not have enough mana! ");
            return 0;
        }
    }
}

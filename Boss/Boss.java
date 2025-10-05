package Boss;

public class Boss {
    private int hp;
    private int attack;
    private int mana;
    private int defense;
    private int speed;
    private String name;

    public Boss() {

    }

    public Boss(int hp, int attack, int mana, int defense, int speed, String name) {
        this.hp = hp;
        this.attack = attack;
        this.mana = mana;
        this.defense = defense;
        this.speed = speed;
        this.name = name;
    }

    public int basicAttack() {
        int damage = attack * (int) 1.2;
        System.out.println(name + " used Basic Attack!");
        System.out.println("Basic Attack deals " + damage + " damage!");
        return damage;
    }

    public int skill1(){
        int damage = attack * (int) 1.5;
        System.out.println(name + " used (Skill 1 Name)!");
        System.out.println("(Skill 1 Name) deals " + damage + " damage!");
        return damage;
    }

    public int skill2(){
        int damage = attack * (int) 1.8;
        System.out.println(name + " used (Skill 2 Name)!");
        System.out.println("(Skill 2 Name) deals " + damage + " damage!");
        return damage;
    }

    public int skill3(){
        int damage = attack * (int) 1.9;
        System.out.println(name + " used (Skill 3 Name)!");
        System.out.println("(Skill 3 Name) deals " + damage + " damage!");
        return damage;
    }

    public int ultimate(){
        int damage = attack * (int) 2.0;
        System.out.println(name + " used (Ultimate Name)!");
        System.out.println("(Ultimate Name) deals " + damage + " damage!");
        return damage;
    }


    // Setters
    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // Getters
    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getMana() {
        return mana;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }
}
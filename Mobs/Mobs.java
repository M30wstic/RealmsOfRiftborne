package Mobs;

public class Mobs {
    private String name;
    private int hp;
    private int attack;
    private int defense;
    private int speed;
    private int level;

    public Mobs() {
        
    }

    public Mobs(String name, int hp, int attack, int defense, int speed, int level) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.level = level;
    }

    //setters
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void setLevel(int level) {
        this.level = level;
    }

    //getters
    public String getName() {
        return name;
    }
    public int getHp() {
        return hp;
    }
    public int getAttack() {
        return attack;
    }
    public int getDefense() {
        return defense;
    }
    public int getSpeed() {
        return speed;
    }
    public int getLevel() {
        return level;
    }
}

package Hero;

public class Hero {
    private int hp;
    private int attack;
    private int mana;
    private int defense;
    private int speed;
    private int level;
    private int experience;
    private String name;
    private String charClass;
    private String weapon;
    private String skill1;
    private String skill2;
    private String ultimate;

    public Hero(){

    }

    public Hero(int hp, int attack, int mana, int defense, int speed, int level, int experience, String name, String charClass, String weapon, String skill1, String skill2, String ultimate) {
        this.hp = hp;
        this.attack = attack;
        this.mana = mana;
        this.defense = defense;
        this.speed = speed;
        this.level = level;
        this.experience = experience;
        this.name = name;
        this.charClass = charClass;
        this.weapon = weapon;
        this.skill1 = skill1;
        this.skill2 = skill2;
        this.ultimate = ultimate;
    }

    public int basicAttack() {
        int damage = multiplierB(attack, level);
        System.out.println(name + " used Basic Attack!");
        System.out.println("Basic Attack deals " + damage + " damage!");
        return damage;
    }

    public int skill1(){
        int damage = multiplier1(attack, level);
        System.out.println(name + " used (Skill 1 Name)!");
        System.out.println("(Skill 1 Name) deals " + damage + " damage!");
        return damage;
    }

    public int skill2(){
        int damage = multiplier2(attack, level);
        System.out.println(name + " used (Skill 2 Name)!");
        System.out.println("(Skill 2 Name) deals " + damage + " damage!");
        return damage;
    }

    public int ultimate(){
        int damage = multiplierU(attack, level);
        System.out.println(name + " used (Ultimate Name)!");
        System.out.println("(Ultimate Name) deals " + damage + " damage!");
        return damage;
    }

    //damage multiplier methods
    public static int multiplierB(int atk, int L) {
        double multiplier = 1.0 + Math.pow((L - 1) / 59.0, 2);
        double damageDealt = atk * multiplier;
        return (int) Math.round(damageDealt);
    }

    public static int multiplier1(int atk, int L) {
        double multiplier = 1.0 + 1.5 * Math.pow((L - 1) / 59.0, 2);
        double damageDealt = atk * multiplier;
        return (int) Math.round(damageDealt);
    }

    public static int multiplier2(int atk, int L) {
        double multiplier = 1.0 + 2.0 * Math.pow((L - 1) / 59.0, 2);
        double damageDealt = atk * multiplier;
        return (int) Math.round(damageDealt);
    }

    public static int multiplierU(int atk, int L) {
        double multiplier = 1.0 + 2.5 * Math.pow((L - 1) / 59.0, 2);
        double damageDealt = atk * multiplier;
        return (int) Math.round(damageDealt);
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

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public String getName() {
        return name;
    }

    public String getCharClass() {
        return charClass;
    }

    public String getWeapon() {
        return weapon;
    }

    public String getSkill1() {
        return skill1;
    }

    public String getSkill2() {
        return skill2;
    }

    public String getUltimate() {
        return ultimate;
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

    public void setLevel(int level) {
        this.level = level;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCharClass(String charClass) {
        this.charClass = charClass;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }
}
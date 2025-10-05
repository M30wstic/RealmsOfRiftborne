package Boss;

public class Elderthorn extends Boss {
    private String skill1 = "Thorn Slash";
    private String skill2 = "Thorn Cage";
    private String skill3 = "Ancient Renewal";
    private String ultimate = "Eternal Wildstorm";
    private int manaCostSkill1 = 50;
    private int manaCostSkill2 = 250;
    private int manaCostSkill3 = 350;
    private int manaCostUltimate = 500; 
    private int manaCapacity = getMana();

    public Elderthorn(){
        super(10000, 450, 1000, 150, 20, "Elderthorn");
    }

    @Override
    public int basicAttack() {
        double damage = getAttack() * (int) 1.2;
        System.out.println(getName() + " used Basic Attack!");
        System.out.println("Basic Attack deals " + damage + " damage!");
        double manaRecovery = manaCapacity * 0.2;

        if(manaRecovery+getMana() > manaCapacity){
            setMana(manaCapacity);
        } else {
            int addMana = (int) manaRecovery + getMana();
            setMana(addMana);
        }

        return (int) damage;
    }

    @Override
    public int skill1(){
        double damage = getAttack() * (int) 1.5;
        System.out.println(getName() + " used " + skill1 + "!");
        System.out.println(skill1 + " deals " + damage + " damage!");

        int manaReduce = getMana() - manaCostSkill1;
        setMana(manaReduce);

        return (int) Math.round(damage);
    }

    @Override
    public int skill2(){
        double damage = getAttack() * (int) 1.8;
        System.out.println(getName() + " used " + skill2 + "!");
        System.out.println(skill2 + " deals " + damage + " damage!");

        int manaReduce = getMana() - manaCostSkill2;
        setMana(manaReduce);
        
        return (int) Math.round(damage);
    }

    @Override
    public int skill3(){
        double damage = getAttack() * (int) 1.9;
        System.out.println(getName() + " used " + skill3 + "!");
        System.out.println(skill3 + " deals " + damage + " damage!");

        int manaReduce = getMana() - manaCostSkill3;
        setMana(manaReduce);

        return (int) Math.round(damage);
    }

    @Override
    public int ultimate(){
        double damage = getAttack() * (int) 2.0;
        System.out.println(getName() + " used " + ultimate + "!");
        System.out.println(ultimate + " deals " + damage + " damage!");

        int manaReduce = getMana() - manaCostUltimate;
        setMana(manaReduce);

        return (int) Math.round(damage);
    }

    // Getters
    public int getManaCostSkill1(){
        return manaCostSkill1;
    }

    public int getManaCostSkill2(){
        return manaCostSkill2;
    }

    public int getManaCostSkill3(){
        return manaCostSkill3;
    }

    public int getManaCostUltimate(){
        return manaCostUltimate;
    }
}
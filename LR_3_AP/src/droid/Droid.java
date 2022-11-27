package droid;

public class Droid {
    protected String name;
    protected double health;
    protected double damage;
    protected double armor;
    protected String weapon;
    protected int numberOfHealPotion;
    protected double superPower;
    protected int blockPercentage;
    protected  boolean isBlocked;




    public Droid(String name, double health, double damage, double armor, int numberOfHealPotion, double superPower) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.armor = armor;
        this.numberOfHealPotion = numberOfHealPotion;
        this.superPower = superPower;
    }
    public boolean superPowerIsReady()
    {
        if (this.getSuperPower() >=100.0) {
            return true;
        }
        else {
            return false;
        }
    }

    public void heal() {
        this.health += 200;
    }

    public void hit(Droid dr) {
        if (dr.isBlocked())
        {
            dr.health -= this.damage - (dr.armor*(1+dr.getBlockPercentage()/100.0));
        }
        else {
            dr.health -= this.damage-dr.armor;
        }

    }
    public void useSuperPower(Droid dr)
    {
        dr.health-=this.damage * 2.5;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public boolean isBlocked() {
        return isBlocked;
    }
    public boolean isAlive(){return this.health<=0 ? false:true;}

    public void setBlockPercentage(int blockPercentage) {
        this.blockPercentage = blockPercentage;
    }

    public int getBlockPercentage() {
        return blockPercentage;
    }

    public void setArmor(double armor) {
        this.armor = armor;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public double getDamage() {
        return damage;
    }

    public double getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public String getWeapon() {
        return weapon;
    }

    public double getArmor() {
        return armor;
    }

    public void setNumberOfHealPotion(int numberOfHealPotion) {
        this.numberOfHealPotion = numberOfHealPotion;
    }

    public int getNumberOfHealPotion() {
        return numberOfHealPotion;
    }

    public void setSuperPower(double superPower) {
        this.superPower = superPower;
    }

    public double getSuperPower() {
        return superPower;
    }
}




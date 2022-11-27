package droid;

import droid.Droid;

public class ShieldDroid extends Droid{
    private String shield;
    public ShieldDroid(String name, double health, double damage, double armor, int numberOfHealPotion, double superPower, String shield) {
        super(name, health, damage, armor, numberOfHealPotion, superPower);
        this.shield = shield;
        this.setWeapon("shield");
        this.setBlockPercentage(80);
    }
    public void useSuperPower(Droid dr)
    {
        this.armor*=2;
    }
    public boolean block(boolean temp)
    {
        return temp;
    }


    public void setShield(String shield) {
        this.shield = shield;
    }

    public String getShield() {
        return shield;
    }
}

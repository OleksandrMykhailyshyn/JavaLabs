package droid;

import droid.Droid;

public class SwordDroid extends Droid{
    private String sword;
    public SwordDroid(String name, double health, double damage, double armor, int numberOfHealPotion, double superPower, String sword) {
        super(name, health, damage, armor, numberOfHealPotion, superPower);
        this.sword = sword;
        this.setWeapon("sword");
        this.setBlockPercentage(40);
    }
    public void useSuperPower(Droid dr)
    {
        dr.health-=this.damage * 2.5;
    }
}

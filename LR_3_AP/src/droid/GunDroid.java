package droid;

import droid.Droid;

public class GunDroid extends Droid {
    private String gun;
    public GunDroid(String name, double health, double damage, double armor, int numberOfHealPotion, double superPower, String gun) {
        super(name, health, damage, armor, numberOfHealPotion, superPower);
        this.gun = gun;
        this.setWeapon("gun");
        this.setBlockPercentage(20);
    }
    public void useSuperPower(Droid dr)
    {
        dr.armor*=0.5;
    }

    public void setGun(String gun) {
        this.gun = gun;
    }

    public String getGun() {
        return gun;
    }
}

package AdventureGame;

public class Mine extends BattleLoc{

    public Mine(Player player){
        super(player, "Mine", new Snake(), null, 1 );
    }
    public void mineAwards(){
        int chance = BattleLoc.r.nextInt(101);
        if(chance<=15){
            int weaponChance = BattleLoc.r.nextInt(101);
            if(weaponChance<=20){
                //set Weapon rifle
                System.out.println("You get Rifle");
                getPlayer().getInventory().setWeapon(Weapon.weapons()[2]);
            }
            if(weaponChance>20 && weaponChance<=50){ // try else if without >20
                //set Weapon sword
                System.out.println("You get Sword");
                getPlayer().getInventory().setWeapon(Weapon.weapons()[1]);
            }
            else {
                //set Weapon pistol
                System.out.println("You get Pistol");
                getPlayer().getInventory().setWeapon(Weapon.weapons()[0]);
            }
        }

        if(chance>15 && chance<=30){
            int armorChance = BattleLoc.r.nextInt(101);

            if(armorChance<=20){
                //set Armor heavy
            }
            if(armorChance>20 && armorChance<=50){
                //set Armor medium
            }
            else{
                //set Armor light
            }
        }

        if(chance>30 && chance<=55){
            int coinChance = BattleLoc.r.nextInt(101);
            if(coinChance<=20){
                // add 10 coin
            }
            if(coinChance>20 && coinChance<=50){
                // add 5 coin
            }
            else{
                // add 10 coin
            }
        }

        else {
            System.out.println("You get nothing. Next time !");
        }

    }

}


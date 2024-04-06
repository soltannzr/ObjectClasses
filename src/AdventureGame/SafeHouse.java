package AdventureGame;

public class SafeHouse extends NormalLoc{

    public SafeHouse(Player player){
        super(player, "SafeHouse");
    }

    @Override
    public boolean onLocation(){
        System.out.println("You are in Safe House" +
                "\nYour health renewed");
        this.getPlayer().setHealth(getPlayer().getDefHealth());
        return true;
    }
}
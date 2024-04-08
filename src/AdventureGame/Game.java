package AdventureGame;
import java.util.Scanner;

public class Game {
    private Cave cave;
    private Forest forest;
    private River river;
    private Mine mine;
    private Inventory inventory = new Inventory();
    public static boolean mineLoc = false;

    public void start() {

        Scanner sc = new Scanner(System.in);
        System.out.println("This is adventure game!");
        System.out.print("Please enter your name: ");
        //String name = sc.next();

        Player player = new Player("Soltan");
        cave = new Cave(player);
        forest = new Forest(player);
        river = new River(player);
        mine = new Mine(player);

        System.out.println();
        System.out.println("Welcome to the adventure " + player.getName() + "!");
        System.out.println();
        player.selectChar();

        Location location = null;
        while(true){
            if(BattleLoc.getInventory().getItemList().size()>=3){
                System.out.println("CONGRATS!!! You won the game !!!");
                break;
            }
            System.out.println();
            mineLoc = false;
            System.out.println("Your player info: ");
            player.printInfo();
            System.out.println("----------------------------------------");
            System.out.print(
                    """
                        Locations:
                        
                        1 - Safe House
                        2 - Tool Store
                        3 - Cave
                        4 - Forest
                        5 - River
                        6 - Mine
                        0 - Exit
                        
                        Select Location:\s""");

            byte selectLoc = sc.nextByte();

            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = cave;
                    break;
                case 4:
                    location = forest;
                    break;
                case 5:
                    location = river;
                    break;
                case 6:
                    mineLoc = true;
                    location = mine;
                    break;
                default:
                    System.out.println("Please enter valid number!");
            }
            if(location == null){
                System.out.println("You left the game !!!");
                break;
            }
            if(!location.isCompleted()){
                if(!location.onLocation()){
                    System.out.println("GAME OVER!");
                    break;
                }
            }
            else {
                System.out.println("You completed this location. Choose another");
                location = null;
            }
        }
    }

    public Cave getCave() {
        return cave;
    }
    public void setCave(Cave cave) {
        this.cave = cave;
    }
    public Forest getForest() {
        return forest;
    }
    public void setForest(Forest forest) {
        this.forest = forest;
    }
    public River getRiver() {
        return river;
    }
    public void setRiver(River river) {
        this.river = river;
    }
    public Mine getMine() {
        return mine;
    }
    public void setMine(Mine mine) {
        this.mine = mine;
    }

    public Inventory getInventory() {
        return inventory;
    }
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
package AdventureGame;
import java.util.Random;

public abstract class BattleLoc extends Location {
    private int maxEnemy;
    private String item;
    private Enemy enemy;
    private static Inventory inventory = new Inventory();
    public static Random r = new Random();

    public BattleLoc(Player player, String name, Enemy enemy, String item, int maxEnemy){
        super(player, name);
        this.item = item;
        this.enemy = enemy;
        this.maxEnemy = maxEnemy;
    }
    @Override
    public boolean onLocation(){
        int enemyNumber = this.randomNumber();
        System.out.println("You are in " + this.getName());
        System.out.println("There are " + enemyNumber + " " + this.enemy.getName() + " here");
        System.out.print("Fight (F) or Leave (L): ");
        String battleCase = sc.nextLine();
        battleCase = battleCase.toUpperCase();

        if(battleCase.equals("F")){
            System.out.println("There will be fights");
            if (combat(enemyNumber)){
                System.out.println("You killed all the enemies!");
                if (Game.mineLoc){
                    // call mineAwards method
                    System.out.println("Special location awards! ");
                }
                else {
                    // BattleLOc is not Mine
                    System.out.println("You got " + this.getItem());
                    this.setCompleted(true);
                    getInventory().addItem(this.getItem()); // Add item to the location's inventory
                    getInventory().printItems();
                    return true;
                }
            }
        }
        else {
            System.out.println("You left the " + this.getName());
            System.out.println();
        }
        if(this.getPlayer().getHealth()<=0){
            System.out.println("You died!");
            return false;
        }
        return true;
    }

    public boolean combat(int enemyNumber) {
        int starter = r.nextInt(2);
        System.out.println("STARTER IS +++++++++++ " + starter);
        for(int i=1; i<=enemyNumber; i++){
            this.getEnemy().setHealth(this.getEnemy().getDefHealth());
            playerStats();
            enemyStats(i);
            if(starter==0) {
                while(this.getPlayer().getHealth() > 0 && this.getEnemy().getHealth() > 0){
                    if(!playerHit()){
                        return false;
                    }
                    enemyHit();
                }
            }
            else {
                while(this.getPlayer().getHealth() > 0 && this.getEnemy().getHealth() > 0){
                    enemyHit();
                    if(!playerHit()){
                        return false;
                    }
                }
            }
        }
        if(this.getPlayer().getHealth()>0) {
            return true;
        }
        return false;
    }

    public boolean playerHit() {
        if(this.getPlayer().getHealth()>0) {
            System.out.print("<H>it or <R>un : ");
            String selectCase = sc.nextLine().toUpperCase();
            if (selectCase.equals("H")) {
                System.out.println("YOU hit the enemy!");
                this.getEnemy().setHealth(this.getEnemy().getHealth() - this.getPlayer().getTotalDamage());
                afterHit();
            } else {
                System.out.println("You left the " + this.getName());
                return false;
            }
        }
        return true;
    }

    public void enemyHit(){
        if (this.getEnemy().getHealth() > 0) {
            System.out.println();
            System.out.println(this.getEnemy().getName().toUpperCase() + " hit you");
            int enemyDamage = this.getEnemy().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();

            if (enemyDamage < 0) {
                enemyDamage = 0;
            }
            this.getPlayer().setHealth(this.getPlayer().getHealth() - enemyDamage);
            afterHit();
        }
        else {
            System.out.println();
            System.out.println("You get " + this.getEnemy().getAward() + " coins");
            this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getEnemy().getAward());
            System.out.println("Your balance is : " + this.getPlayer().getMoney());
        }
    }

    public void afterHit(){
        System.out.println("Your health: " + this.getPlayer().getHealth());
        System.out.println(this.getEnemy().getName() + " health: " + this.getEnemy().getHealth());
    }

    public void playerStats(){
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("*** Player stats ***");
        System.out.println();
        System.out.println("Health -> " + this.getPlayer().getHealth());
        System.out.println("Weapon -> " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Damage -> " + this.getPlayer().getTotalDamage());
        System.out.println("Armor -> " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Blocking -> " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("----------------------------------------");
    }

    public void enemyStats(int i){
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println(i + ". " + this.getEnemy().getName() + " stats !!!");
        System.out.println("Health -> " + this.getEnemy().getHealth());
        System.out.println("Damage -> " + this.getEnemy().getDamage());
        System.out.println("Award -> " + this.getEnemy().getAward());
        System.out.println("----------------------------------------");
    }

    public int randomNumber(){
        return r.nextInt(this.getMaxEnemy()) + 1;
    }

    //Getters and setters
    public int getMaxEnemy() {
        return this.maxEnemy;
    }
    public void setMaxEnemy(int maxEnemy) {
        this.maxEnemy = maxEnemy;
    }
    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public Enemy getEnemy() {
        return enemy;
    }
    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }
    public static Inventory getInventory() {
        return inventory;
    }

    public static void setInventory(Inventory inventory) {
        BattleLoc.inventory = inventory;
    }
}
package AdventureGame;

public abstract class GameCharacter {
    private String name;
    private int health, damage, money, id;

    public GameCharacter(int id, String name, int damage, int health, int money){
        this.id = id;
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.money = money;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public int getDamage(){
        return this.damage;
    }
    public int getHealth(){
        return this.health;
    }
    public int getMoney(){
        return this.money;
    }
}
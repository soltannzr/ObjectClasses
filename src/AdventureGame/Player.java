package AdventureGame;

import java.util.Scanner;

public class Player {

    private String name, charName;
    private int damage, defHealth, health, money;
    private Inventory inventory;

    Scanner sc = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {
        GameCharacter[] charList = { new Samurai(), new Archer(), new Knight() };
        System.out.println("Here is the characters:");
        System.out.println();

        for (int i = 0; i<=charList.length-1; i++) {
            System.out.println("Character name: " + charList[i].getName() + "\t\tCharacter ID: " + (i + 1) + "\t\tDamage: " +
                    charList[i].getDamage() + "\t\tHealth: " + charList[i].getHealth() + "\t\tBudget: " + charList[i].getMoney());
        }

        System.out.println();
        System.out.print("Select your character: ");
        byte choice = sc.nextByte();
        while (choice < 1 || choice> charList.length){
            System.out.print("Invalid choice, try again: ");
            choice = sc.nextByte();
        }

        switch (choice){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                System.out.println("Wrong choice");
        }

        System.out.println("Your character is: " + this.getCharName() +
                "\t\tDamage: " + this.getDamage() +
                "\tHealth: " + this.getHealth() +
                "\tBudget: " + this.getMoney());
    }

    public void printInfo() {
        System.out.println("Weapon: " + this.getInventory().getWeapon().getName() +
                "\tArmor: "+ this.getInventory().getArmor().getName() +
                "\t\tTotal Damage: " + this.getTotalDamage() +
                "\t\tTotal Blocking: " + this.getInventory().getArmor().getBlock() +
                "\t\tTotal Health: " + this.getHealth() +
                "\t\tTotal Budget: " + this.getMoney());
    }

    public void initPlayer(GameCharacter gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
        this.setDefHealth(gameChar.getHealth());
        this.setHealth(gameChar.getHealth());
    }

    //Getters and Setters
    public int getTotalDamage(){
        return this.damage + this.getInventory().getWeapon().getDamage();
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCharName() {
        return this.charName;
    }
    public void setCharName(String charName) {
        this.charName = charName;
    }
    public int getDamage() {
        return this.damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getHealth() {
        return this.health;
    }
    public int getDefHealth() {
        return defHealth;
    }
    public void setDefHealth(int defHealth) {
        this.defHealth = defHealth;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getMoney() {
        return this.money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public Inventory getInventory() {
        return this.inventory;
    }
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
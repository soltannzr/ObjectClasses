package AdventureGame;

import java.util.ArrayList;

public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private ArrayList<String> itemList = new ArrayList<>();

    public Inventory(){
        this.weapon = new Weapon(-1,"Fist", 0, 0);
        this.armor = new Armor (-1, "Suit", 0, 0);
    }

    public void printItems() {
        System.out.println("Items in your inventory: ");
        for (String s : itemList) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public void addItem(String item) {
        itemList.add(item);
    }

    //Getters and Setters
    public Weapon getWeapon(){
        return weapon;
    }
    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }
    public Armor getArmor(){
        return this.armor;
    }
    public void setArmor(Armor armor){
        this.armor = armor;
    }

    public ArrayList<String> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<String> itemList) {
        this.itemList = itemList;
    }
}
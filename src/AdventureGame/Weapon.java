package AdventureGame;

public class Weapon {
    private String name;
    private int id, damage, price;

    Weapon(int id, String name, int damage, int price){
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.price = price;
    }

    public static Weapon[] weapons(){
        Weapon[] weaponList = new Weapon[3];
        weaponList[0] = new Weapon(1, "Pistol", 2, 5);
        weaponList[1] = new Weapon(2, "Sword", 3, 35);
        weaponList[2] = new Weapon(3, "Rifle", 7, 45);
        return weaponList;
    }

    public static Weapon getWeaponByID(int id){
        for(Weapon w : weapons()){
            if(id == w.getId()){
                return w;
            }
        }
        return null;
    }

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getDamage(){
        return this.damage;
    }
    public void setDamage(int damage){
        this.damage = damage;
    }
    public int getPrice (){
        return this.price;
    }
    public void setPrice(int price){
        this.price = price;
    }
}
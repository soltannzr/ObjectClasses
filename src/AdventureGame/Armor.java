package AdventureGame;

public class Armor {
    private int id, block, price;
    private String name;

    public Armor(int id, String name, int block, int price){
        this.id = id;
        this.name = name;
        this.block = block;
        this.price = price;
    }

    public static Armor[] armors(){
        Armor[] armorList = new Armor[3];
        armorList[0] = new Armor(1, "Light", 1, 15);
        armorList[1] = new Armor(2, "Medium", 3, 25);
        armorList[2] = new Armor(3, "Heavy", 5, 40);

        return armorList;
    }

    public static Armor getArmorById(int id){
        for (Armor a: armors()){
            if(a.getId() == id){
                return a;
            }
        }
        return null;
    }

    public int getId(){
        return this.id;
    }
    public int getBlock(){
        return this.block;
    }
    public int getPrice(){
        return this.price;
    }
    public String getName(){
        return this.name;
    }
}
package AdventureGame;
public class ToolStore extends NormalLoc{

    public ToolStore(Player player){
        super(player, "Tool Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in Tool Store!");

        boolean showMenu = true;
        while (showMenu) {
            System.out.println();
            System.out.print(
                    """
                            1 - Weapon
                            2 - Armors
                            0 - Exit\s
                            Select one to shop:\s""");
            int selectCase = sc.nextByte();
            System.out.println();

            while (selectCase < 0 || selectCase > 3) {
                System.out.println("Invalid Choice. Try again!");
                selectCase = sc.nextByte();
            }

            switch (selectCase) {
                case 0: {
                    showMenu = false;
                    System.out.println("You left the menu");
                    break;
                }
                case 1:
                    System.out.println("Your budget: " + player.getMoney());
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    System.out.println("Your budget: " + player.getMoney());
                    printArmor();
                    buyArmor();
                    break;
                default:
                    System.out.println("Wrong choice!");
            }
            player.printInfo();
        }
        return true;
    }

    public void printWeapon(){
        for (Weapon w: Weapon.weapons()) {
            System.out.println(w.getId() + ": " + w.getName() + " , Damage: " + w.getDamage() + " , Price: " + w.getPrice());
        }
        System.out.println("0 - Exit");
        System.out.println();
    }

    public void buyWeapon() {
        System.out.print("Select one (weapon) : ");
        int selectWeaponID = sc.nextByte();

        while ((selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length)) {
            System.out.println("Invalid choice. Try again!");
            selectWeaponID = sc.nextByte();
        }

        Weapon selectedWeapon = Weapon.getWeaponByID(selectWeaponID);

        if (selectedWeapon != null) {
            if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("Insufficient funds");
            } else {
                System.out.println();
                System.out.println("You bought -> " + selectedWeapon.getName());
                int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Available balance: " + this.getPlayer().getMoney());
                System.out.println();
                System.out.println("Previous weapon: " + this.getPlayer().getInventory().getWeapon().getName());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
                System.out.println("New weapon: " + this.getPlayer().getInventory().getWeapon().getName());
            }
        }
        if(selectWeaponID == 0){
            System.out.println("You left the weapon menu");
        }
    }

    public void printArmor(){
        System.out.println("Armors: ");
        for (Armor a : Armor.armors()){
            System.out.println("ID: " + a.getId() + "   Name: " + a.getName() +
                    "   Block: " + a.getBlock() + "  Price: " + a.getPrice());
        }
        System.out.println("0 - Exit");
    }

    public void buyArmor() {
        System.out.println();
        System.out.print("Select one (armor): ");
        int selectArmorID = sc.nextByte();
        while (selectArmorID < 0 || selectArmorID > Armor.armors().length) {
            System.out.println("Invalid choice \nTry again");
        }

        Armor selectedArmor = Armor.getArmorById(selectArmorID);
        if (selectedArmor != null) {
            if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("Insufficient funds");
            } else {
                System.out.println();
                System.out.println("You bought -> " + selectedArmor.getName());
                int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Available balance: " + this.getPlayer().getMoney());
                System.out.println();
                System.out.println("Previous armor: " + this.getPlayer().getInventory().getArmor().getName());
                this.getPlayer().getInventory().setArmor(selectedArmor);
                System.out.println("New armor: " + this.getPlayer().getInventory().getArmor().getName());
            }
        }
        if(selectArmorID == 0) {
            System.out.println("You left the armor menu");
        }
    }
}
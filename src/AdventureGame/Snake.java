package AdventureGame;
public class Snake extends Enemy{
    int minDamage = 3;
    int maxDamage = 6;
    int snakeDamage = (int) (Math.random() * (maxDamage - minDamage + 1)) + minDamage;
    int snakeDamage2 = BattleLoc.r.nextInt(maxDamage- minDamage +1) + minDamage;
    public Snake(){
        super(4, "Snake", 0, 12, 0);
        this.setDamage(snakeDamage);
    }

}

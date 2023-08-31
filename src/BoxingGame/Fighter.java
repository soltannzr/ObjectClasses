package BoxingGame;

public class Fighter {
    String name;
    int damage;
    int health;
    int weight;
    int dodge;

    Fighter(String name, int damage, int health, int weight, int dodge){
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.weight = weight;
        this.dodge = dodge;
    }

    int hit(Fighter opponent){
        if (opponent.dodge()) {
            System.out.println(opponent.name + " dodge damage");
            return opponent.health;
        }
        if (opponent.health <= 0) {
            System.out.println(this.name + " won");
            return 0;
        }
            System.out.println(this.name + " hits " + this.damage + " => " + opponent.name + " ");
        return opponent.health - this.damage;

    }

    boolean dodge(){
        double randomNum = Math.random() * 100;
        return randomNum <= this.dodge;
    }
}
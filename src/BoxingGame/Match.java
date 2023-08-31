package BoxingGame;

public class Match {
    Fighter f1;
    Fighter f2;
    Fighter first;
    Fighter second;
    int minWeight;
    int maxWeight;

    Match(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    void run() {
        if (checkWeight()) {

            if(f1.health <= 0){
                System.out.println(f2.name + " won");
            }
            if (f2.health <= 0){
                System.out.println(f1.name + " won");
            }

            int round = 1;
            while (f1.health > 0 && f2.health>0) {
                System.out.println("-----------------------");
                System.out.println("ROUND " + round + "!");
                round++;
                starter();

                if(!isWin()){
                    second.health = first.hit(second);

                if (second.health != 0) {
                    first.health = second.hit(first);
                }
                else {
                    System.out.println(first.name + " won");
                    break;
                }
                if (first.health <= 0) {
                        System.out.println(second.name + " won");
                        break;
                    }
                }
                printHealth();
            }
        }
        else
            System.out.println("Incompatible weights!");
    }

    boolean checkWeight() {
        return (f1.weight <= maxWeight && f1.weight >= minWeight &&
                f2.weight <= maxWeight && f2.weight >= minWeight);
    }

    void starter() {
        double prob = Math.random() * 100;
        if (prob <= 50.0) {
            first = this.f1;
           second = this.f2;
        } else {
            first = this.f2;
            second = this.f1;
        }
    }

    void printHealth(){
        System.out.println(f1.name + " health is: " + this.f1.health);
        System.out.println(f2.name + " health is: " + this.f2.health);
    }

    boolean isWin(){
        return (f1.health <=0 || f2.health <=0);
    }
}
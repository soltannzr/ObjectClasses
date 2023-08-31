package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int rights = 5;
        int num = (int) (Math.random()*100);
        boolean isWin = false;
        int mistake = 0;
        int[] wrongArray = new int[rights];
        //If you want to see correct number, uncomment the following line
        //System.out.println(num);

        for(int i = 0; i< rights; ++i){
            System.out.print("Guess the number: ");
            int select = inp.nextInt();

            if(mistake<1 && (select<0 || select>100)) {

                System.out.println("Number must be between 0 and 100. You will lose 1 right in your next wrong entries.");
                ++mistake;
                --i;
                continue;
            }
            else if(mistake>=1&& (select<0 || select>100)){
                System.out.println("Too many invalid number. Your remaining right: " + (rights - i - 1));
                wrongArray[i] = select;
                continue;
                }

            if(select == num) {
                System.out.println("Congrats! You guessed the number correctly! ");
                isWin = true;
                break;
            }
                System.out.print("Wrong number. ");

            if(select<num){
                System.out.println("Your number is less than the secret number. Try again");
            }
            else {
                System.out.println("Your number is greater than the secret number. Try again");
            }

            System.out.println("Remaining right: " + (rights-i-1));
            wrongArray[i] = select;
        }

        if(!isWin){
            System.out.println("You lose");
            System.out.println("Your choices are: " + Arrays.toString(wrongArray));
        }

    }
}
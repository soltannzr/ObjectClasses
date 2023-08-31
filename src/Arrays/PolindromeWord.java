package Arrays;

import java.util.Scanner;

public class PolindromeWord {

    static boolean isPalindrome (String s){
        String reverse = "";
        for (int i=s.length()-1; i>=0 ; i--){
            reverse += s.charAt(i);
        }
        return reverse.equals(s);
    }
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter the word: ");
        String str = inp.next();

        if(isPalindrome(str)){
            System.out.println(str + " is palindrome word");
        }
        else {
            System.out.println(str + " is not palindrome word");
        }
    }
}

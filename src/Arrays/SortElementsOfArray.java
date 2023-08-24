package Arrays;
import java.util.Arrays;
import java.util.Scanner;

public class SortElementsOfArray {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter the size of an array n : ");
        int n=inp.nextInt();
        int[] arr = new int[n];
        int counter = 1;
        System.out.println("Enter the elements of the array :");
        for (int i = 0; i<arr.length; i++){
            System.out.print("Enter " + counter + ". element : " );
            counter++;
            arr[i]=inp.nextInt();
        }

        Arrays.sort(arr);
        System.out.print("Order of numbers : " );
        for(int i: arr){
            System.out.print(i + " ");
        }

    }
}

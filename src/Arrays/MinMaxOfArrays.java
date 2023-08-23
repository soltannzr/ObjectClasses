package Arrays;

import java.util.Scanner;
import java.util.Arrays;

public class MinMaxOfArrays {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = inp.nextInt();
        int[] arr ={15, 10, 1, 2, 5};
        Arrays.sort(arr);

        int max=n, min = n;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>n){
                max = arr[i];
                break;
            }
        }

        for(int i = arr.length - 1; i >= 0; i--){
            if(arr[i]<n){
                min = arr[i];
                break;
            }
        }

        if (arr[arr.length -1]<n) {
            System.out.println("There is no greater number than " + n + " in this array.");
        }
        else {
            System.out.println("The nearest number greater than the entered number: " + max);
        }

        if (arr[0]>n){
            System.out.println("There is no smaller number than " + n + " in this array.");
        }
        else
            System.out.println("The nearest number smaller than the entered number: " + min);

    }
}

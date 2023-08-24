package Arrays;
import java.util.Arrays;
public class RepeatedNumbersFinder {
    public static void main(String[] args) {
        int[] arr = {1,5,10,1,20,5,8,1,4,10,8,1};
        Arrays.sort(arr);

        for(int i =1; i<arr.length; i++){
            if((arr[i]==arr[i-1]) && arr[i]!=arr[i+1] && (arr[i]%2==0)){
                System.out.print(arr[i]+ " ");
            }
        }
    }
}
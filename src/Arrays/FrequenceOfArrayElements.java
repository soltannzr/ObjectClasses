package Arrays;


import java.util.Arrays;
public class FrequenceOfArrayElements {
    public static void main(String[] args) {
        int[] array = { 5, 9, 9, 10, 10, 10, 11};
        Arrays.sort(array);
        // Find the maximum value in the array
        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }

        // Choose a marker value greater than the maximum value
        int marker = max + 1;

        // Loop through the array
        for (int i = 0; i < array.length; i++) {
            int count = 1; // Initialize the count to 1 for the current element

            // Check for duplicates
            if (array[i] != marker) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[i] == array[j]) {
                        count++; // Increment the count if a match is found
                        array[j] = marker; // Mark the duplicate element as the marker
                    }
                    else break;
                }
                // Print the count
                System.out.println(array[i] + " appears " + count + " times");
            }
        }
    }
}


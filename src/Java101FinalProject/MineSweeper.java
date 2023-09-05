package Java101FinalProject;

import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    int rowNumber, colNumber;
    String[][] map;

    MineSweeper(int rowNumber, int colNumber) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
        this.map = new String[rowNumber][colNumber];  // Initialize the matrix here.
    }

    //creating game map
    public void createMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = "-";
            }
        }

        Random rand = new Random();
        for (int i = 0; i < (rowNumber * colNumber) / 4; i++) {
            int x, y;
            do {
                x = rand.nextInt(rowNumber);  // Generate a random index for row.
                y = rand.nextInt(colNumber);  // Generate a random index for column.
            } while (map[x][y].equals("*")); // Keep generating new coordinates if a mine already exists.
            map[x][y] = "*";  // Place the mine.
        }
    }

    //method that print matrices
    void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    boolean isWin (String[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j].equals("-") && !map[i][j].equals("*")) {
                    // If a non-mine cell has not been revealed yet, the game is not won.
                    return false;
                }
            }
        }
        return true;
    }

    //game algorithm
    void run() {

        int count;

        createMap();
        printMatrix(map);
        System.out.println("-----------------------");

        Scanner inp = new Scanner(System.in);

        String[][] fakeMap = new String[rowNumber][colNumber];
        for (int i = 0; i < fakeMap.length; i++) {
            for (int j = 0; j < fakeMap[i].length; j++) {
                fakeMap[i][j] = "-";
            }
        }

        printMatrix(fakeMap);
        int rowIndex;
        int colIndex;

        while (!isWin(fakeMap)) {
            count = 0;
            System.out.print("Enter row index: ");
            rowIndex = inp.nextInt();
            System.out.print("Enter column index: ");
            colIndex = inp.nextInt();

            if (colIndex<0 || colIndex>fakeMap[0].length-1 || rowIndex<0 || rowIndex>fakeMap.length -1){
                System.out.println("Enter correct indexes");
                continue;
            }
            if (map[rowIndex][colIndex].equals("*")) {
                System.out.println("You lose");
                break;
            }

            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    // Skip the current cell
                    if (dx == 0 && dy == 0) continue;

                    // Calculate the indices of the neighboring cell
                    int nx = rowIndex + dx;
                    int ny = colIndex + dy;

                    // Check if the indices are valid
                    if (nx >= 0 && nx < rowNumber && ny >= 0 && ny < colNumber) {
                        // If the neighboring cell is a mine, increment the count
                        if (map[nx][ny].equals("*")) {
                            count++;
                        }
                    }
                }
            }

            fakeMap[rowIndex][colIndex] = String.valueOf(count) ;
            printMatrix(fakeMap);
        }
        if(isWin(fakeMap)){
            System.out.println("Congratulations, you won the game!");
        }
    }
}

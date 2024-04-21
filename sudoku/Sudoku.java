import java.util.Scanner;

public class Sudoku {
    public static void main(String[] args) {
        int arr[][]=input();
        solveSudoku(arr);
        print(arr);
    }
    public static int[][] input(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the size");
        int n=scanner.nextInt();
        int arr[][]=new int[n][n];
        System.out.println("Enter '0' for empty spaces");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++){
                arr[i][j]=scanner.nextInt();
            }
        }
        return arr;
    }

    public static void print(int [][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }

    public static boolean solveSudoku(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (input[i][j] == 0) {
                    for (int c = 1; c <= input.length; c++) {
                        if (isValid(input, i, j, c)) {
                            input[i][j] = c;

                            if (solveSudoku(input))
                                return true;
                            else
                                input[i][j] = 0;
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(int[][] input, int row, int col, int c) {
        int k=(int)Math.sqrt(input.length);
        for (int i = 0; i < input.length; i++) {
            if (input[i][col] == c)
                return false;

            if (input[row][i] == c)
                return false;

            if (input[k * (row / k) + i / k][k * (col / k) + i % k] == c)
                return false;
        }
        return true;
    }
}
package lesson150223;

import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int max = Integer.MIN_VALUE;
        int maxLine = 0;
        int maxRow = 0;

        int[][] matrix = new int[n][m];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = sc.nextInt();
                if (max < matrix[i][j]) {
                    max = matrix[i][j];
                    maxLine = i;
                    maxRow = j;
                }
            }
        }
        System.out.println(maxLine + " " + maxRow);
    }
}
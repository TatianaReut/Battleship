package lesson160223;

import java.util.Arrays;
import java.util.Scanner;

class FixingExceptions {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arrayStr = sc.nextLine().split(" ");
        int arrayLength = arrayStr.length;
        int[] array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            int number = Integer.parseInt(arrayStr[i]);
            array[i] = number;
        }
        int index = sc.nextInt();

        calculateSquare(array, index);
    }

    public static void calculateSquare(int[] array, int index) {
        // write your code here
        try {
            int square = array[index] * array[index];
            System.out.println(square);
        } catch (Exception e) {
            System.out.println("Exception!");
        }
    }
}

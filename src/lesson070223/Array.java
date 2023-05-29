package lesson070223;

// need to calculate the sum of the numbers in the array.

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] array = new int[length];
        int sum = 0;

        for (int i = 0; i < length; i++) {    // filling the array using a for loop
            array[i] = sc.nextInt();
            sum += array[i];
        }

//        for (int number : array) {     // filling the array using a for-each loop
//            number = sc.nextInt();     // the array is not filled with elements
//            sum += number;
//        }
//        System.out.println(sum);

        // string conversion to array of numbers

//        String lengthString = sc.nextLine();
//        int length = Integer.parseInt(lengthString);
//        String[] array = sc.nextLine().split(" ");
//        int[] intArray = new int[length];
//        int sum = 0;
//
//        for (int i = 0; i < length; i++) {
//            int number = Integer.parseInt(array[i]);
//            intArray[i] = number;
//            sum += intArray[i];
//        }
//        System.out.println(sum);
    }
}

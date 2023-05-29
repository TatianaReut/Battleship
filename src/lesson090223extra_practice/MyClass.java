package lesson090223extra_practice;

import java.util.Arrays;
import java.util.Scanner;

public class MyClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] numbers = new int[length];

        for (int i = 0; i < length; i++) {
            numbers[i] = sc.nextInt();
        }

        int n = sc.nextInt();
        int m = sc.nextInt();

        boolean occur = false;

//        for (int j = 1; j < length; j++) {
//            occur = numbers[j] == n && numbers[j - 1] == m || numbers[j] == m && numbers[j - 1] == n;
//        }
//        System.out.println(occur);

        int j = 1;
        while (j < length) {
            if (numbers[j] == n && numbers[j - 1] == m || numbers[j] == m && numbers[j - 1] == n) {
                occur = true;
                break;
            }
                j++;

        } System.out.println(occur);
    }
}

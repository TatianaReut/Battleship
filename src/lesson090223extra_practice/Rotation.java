package lesson090223extra_practice;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;

public class Rotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        int numbersLength = line.length;
        int[] numbers = new int[numbersLength];

        for (int i = 0; i < numbersLength; i++) {
            int number = Integer.parseInt(line[i]);
            numbers[i] = number;
        }
        int rotation = sc.nextInt();
        rotate(numbers, rotation);
    }

    static void rotate(int[] numbers, int rotation) {
        for (int i = 0; i < rotation; i++) {
            int lastNumber = numbers[numbers.length - 1];
            for (int j = numbers.length - 1; j > 0; j--) {
                numbers[j] = numbers[j - 1];
            }
            numbers[0] = lastNumber;
        }
        System.out.println(Arrays.toString(numbers).replaceAll("\\[|]", "").replaceAll(",", ""));
    }
}

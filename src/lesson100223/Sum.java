package lesson100223;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        File f = new File("C:\\Users\\User\\Desktop\\TANIA\\dataset_91033.txt");
        try {
            Scanner sc = new Scanner(f);
            int sum = 0;
            while (sc.hasNextLine()) {
                int number = sc.nextInt();
                sum += number;
            }
            System.out.println(sum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}


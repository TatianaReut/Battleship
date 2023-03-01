package lesson060223;

// need to print the word "odd" after an odd number and the word "even" after an even number.
// 0 is not included in the sequence, after it the program ends.

import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        while (true) { // on the assignment on branching statements (break, continue)
//            int number = sc.nextInt();
//            if (number == 0) {
//                break;
//            }
//            if (number % 2 != 0) {
//                System.out.println("odd");
//            }
//            if (number % 2 == 0) {
//                System.out.println("even");
//            }
//        }

        // optimally complete the task using a do-while loop

        int number = 0;
        do {
            number = sc.nextInt();

            if (number % 2 != 0) {
                System.out.println("odd");
            }
            if (number != 0 && number % 2 == 0) {
                System.out.println("even");
            }
        } while (number != 0); {
        }
    }
}

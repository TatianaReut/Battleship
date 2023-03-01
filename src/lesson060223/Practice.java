package lesson060223;

public class Practice {
    public static void main(String[] args) {

        // 1
//        for (int i = 0; i < 5; i++) {
//            System.out.println(i);
//            for (int j = 0; j < 5; j++) {
//                System.out.println(j);
//                break;
//            }
//        }

        // 2
//        for (int i = 0; i < 11; i++) {
//            if (i % 2 != 0) {
//                continue;
//            }
//            System.out.print(i + " ");
//        }

        //3
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.print(i);
//                break;
//            }
//        }

        // 4
//        int n = 10;
//        for (int i = 0; i < n; i++) {
//            if (i * i < 36) {
//                continue;
//            }
//            System.out.print(i + " ");
//        }

        //5
//        int i = 0;
//        while (i < 10) {
////            System.out.print(i);
//            if (i == 5) {
//                break;
//            }
//            i++;
//        }
//
//        int j = 0;
//        while (j < 10) {
//            j++;
//            if (j == 5) {
//                continue;
//            }
////            System.out.print(j);
//        }
//
//        for (int k = 0; k < 10; k++) {
//            if (k > 5) {
//                continue;
//            }
//            System.out.print(k);
//        }

        //6
//        for (int i = 0; i < 5; i++) {
//            for (char letter = 'a'; letter <= 'f'; letter++) {
//                if (letter < 'f') {
//                    continue;
//                }
//                System.out.println(letter);
//            }
//        }

        //7
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            if (i < 3) {
                continue;
            } else {
                for (int j = 0; j < 5; j++) {
                    System.out.println(j);
                }
            }
        }
    }
}

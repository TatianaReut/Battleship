package lesson100223;

import java.io.File;

class Siblings {

    public static boolean areSiblings(File f1, File f2) {
        // implement me
//        boolean areSiblings;
//        areSiblings = f1.getParent().equals(f2.getParent());
//        return areSiblings;
        return f1.getParent().equals(f2.getParent());
    }

    public static void main(String[] args) {
        File f1 = new File("dir/file1.txt");
        File f2 = new File("dir/file2.txt");

        System.out.println(areSiblings(f1, f2));
    }
}

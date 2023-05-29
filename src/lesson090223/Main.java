package lesson090223;

import java.util.*;

public class Main {

    public static void method() {
        // write your code here
        throw new RuntimeException("Unchecked exception");
    }

    /* Do not change code below */
    public static void main(String[] args) {
        try {
            method();
        } catch (RuntimeException e) {
            System.out.println("RuntimeException");
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }
}


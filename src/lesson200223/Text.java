package lesson200223;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Text {
    public static void main(String[] args) {
        char[] chars = new char[50];

        try (Reader reader = new InputStreamReader(System.in);) {
            reader.read(chars);
            String string = String.valueOf(chars);
            System.out.println(string);
            int counter = 0;
            if (string.length() == 0 || string.equals(" ")) {            // !!!!!!!!!!!!
                System.out.println(0);
            } else {
                for (int i = 0; i < string.length(); i++) {
                    if (string.charAt(i) == ' ') {                 // !!!!!!!!!
                        counter++;
                    }
                }
            }
            System.out.println(counter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

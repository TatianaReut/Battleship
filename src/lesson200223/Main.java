package lesson200223;

import java.io.CharArrayReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {
    public static void main(String[] args) {
        char[] buf = new char[50];
        Reader reader = new InputStreamReader(System.in);
        try {
            reader.read(buf);
            StringBuilder str = new StringBuilder(String.valueOf(buf).trim()).reverse();
            System.out.println(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

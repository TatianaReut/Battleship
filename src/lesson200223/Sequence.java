package lesson200223;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class Sequence {
    public static void main(String[] args) {
        InputStream stream = System.in;
        byte[] bytes;
        try {
            bytes = stream.readAllBytes();
            for (byte b : bytes) {
                System.out.print(b);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

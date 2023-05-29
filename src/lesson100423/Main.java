package lesson100423;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Publication("The new era").getDetails());
        System.out.println(new Newspaper("Football results", "Sport news").getDetails());
        System.out.println(new Article("Why the Sun is hot", "Dr James Smith").getDetails());
        System.out.println(new Announcement("Will sell a house", 30).getDetails());
    }
}

package battleShip;

import java.util.Scanner;

public class Game {
    public static final char EMPTY_AREA = '~';
    public static final char PLACE_OF_SHIP = 'O';
    private final Player player1 = new Player();
    private final Player player2 = new Player();

    public void startGame() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Player 1, place your ships on the game field");
        System.out.println();
        printGameField(player1.emptyGameField);
        player1.createAircraftCarrier(Ship.AIRCRAFT_CARRIER_FIRST_PLAYER);
        printGameField(player1.gameField);
        player1.createBattleShip(Ship.BATTLE_SHIP_FIRST_PLAYER);
        printGameField(player1.gameField);
        player1.createSubmarine(Ship.SUBMARINE_FIRST_PLAYER);
        printGameField(player1.gameField);
        player1.createCruiser(Ship.CRUISER_FIRST_PLAYER);
        printGameField(player1.gameField);
        player1.createDestroyer(Ship.DESTROYER_FIRST_PLAYER);
        printGameField(player1.gameField);
        System.out.println("Press Enter and pass the move to another player");
        sc.nextLine();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("Player 2, place your ships on the game field");
        System.out.println();
        printGameField(player2.emptyGameField);
        player2.createAircraftCarrier(Ship.AIRCRAFT_CARRIER_SECOND_PLAYER);
        printGameField(player2.gameField);
        player2.createBattleShip(Ship.BATTLE_SHIP_SECOND_PLAYER);
        printGameField(player2.gameField);
        player2.createSubmarine(Ship.SUBMARINE_SECOND_PLAYER);
        printGameField(player2.gameField);
        player2.createCruiser(Ship.CRUISER_SECOND_PLAYER);
        printGameField(player2.gameField);
        player2.createDestroyer(Ship.DESTROYER_SECOND_PLAYER);
        printGameField(player2.gameField);
        System.out.println("Press Enter and pass the move to another player");
        sc.nextLine();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        while (player1.shipCounter > 0 && player2.shipCounter > 0) {
            printGameField(player2.emptyGameField, false);
            System.out.println("-------------");
            printGameField(player1.gameField, false);
            System.out.println();
            System.out.println("Player 1, it's your turn");
            System.out.println();

            player1.takeShot(player2.gameField, player2.emptyGameField,"Second");
            System.out.println();

            if (player1.shipCounter > 0) {
                printGameField(player1.emptyGameField, false);
                System.out.println("-------------");
                printGameField(player2.gameField, false);
                System.out.println();
                System.out.println("Player 2, it's your turn");
                System.out.println();

                player2.takeShot(player1.gameField, player1.emptyGameField, "First");
                System.out.println();
            }
        }
    }
    public static char[][] makeGameField() {
        char[][] field = new char[10][10];

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = EMPTY_AREA;
            }
        }
        return field;
    }

    public static void printGameField(char[][] gameField) {
        printGameField(gameField, true);
    }

    public static void printGameField(char[][] gameField, boolean appendNewLine) {
        System.out.print(" ");
        for (int i = 1; i <= 10; i++) {
            System.out.print(" " + i);
        }
        System.out.println();

        char c = 'A';
        for (int i = 0; i < gameField.length; i++) {
            System.out.print(c);
            c++;
            for (int j = 0; j < gameField[i].length; j++) {
                System.out.print(" " + gameField[i][j]);
            }
            System.out.println();
        }
        if (appendNewLine) {
            System.out.println();
        }
    }

    public static int mapCharToInt(char character) {
        return switch (character) {
            case 'A' -> 0;
            case 'B' -> 1;
            case 'C' -> 2;
            case 'D' -> 3;
            case 'E' -> 4;
            case 'F' -> 5;
            case 'G' -> 6;
            case 'H' -> 7;
            case 'I' -> 8;
            case 'J' -> 9;
            default -> -1;
        };
    }

    public static boolean checkSpace (int rowStartIndex, int columnStartIndex, int rowEndIndex, int columnEndIndex, char[][] gameField) {
        if (rowStartIndex != 0) {
            rowStartIndex--;
        }
        if (columnStartIndex != 0) {
            columnStartIndex--;
        }
        if (rowEndIndex != 9) {
            rowEndIndex++;
        }
        if (columnEndIndex != 9) {
            columnEndIndex++;
        }

        boolean empty = true;

        for (int i = rowStartIndex; i <= rowEndIndex; i++) {
            for (int j = columnStartIndex; j <= columnEndIndex; j++) {
                if (gameField[i][j] != EMPTY_AREA) {
                    empty = false;
                    break;
                }
            }
        }
        return empty;
    }
}

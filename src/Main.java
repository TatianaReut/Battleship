import java.util.Scanner;

public class Main {
    static char[][] gameField = new char[10][10];
    static char emptyArea = '~';
    static char placeOfShip = 'O';
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        makeGameField();
        printGameField();
        createAircraftCarrier();
        printGameField();
        createBattleShip();
        printGameField();
        createSubmarine();
        printGameField();
        createCruiser();
        printGameField();
        createDestroyer();
        printGameField();
        System.out.println("The game starts!");
        printGameField();
        System.out.println("Take a shot!");
        takeShot();
    }

    public static void makeGameField() {

        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                gameField[i][j] = emptyArea;
            }
        }
    }

    public static void printGameField() {
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

    private static boolean checkSpace (int rowStartIndex, int columnStartIndex, int rowEndIndex, int columnEndIndex) {
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
                if (gameField[i][j] != emptyArea) {
                    empty = false;
                    break;
                }
            }
        }
        return empty;
    }

    private static void createShip(int lengthOfShip, String nameOfShip) {
        try {
            String[] inputShip = sc.nextLine().split(" ");

            int start = mapCharToInt(inputShip[0].charAt(0));
            int finish = mapCharToInt(inputShip[1].charAt(0));

            int rowStartIndex = Math.min(start, finish);
            int rowEndIndex = Math.max(start, finish);

            start = (Integer.parseInt(inputShip[0].substring(1)) - 1);
            finish = (Integer.parseInt(inputShip[1].substring(1)) - 1);

            int columnStartIndex = Math.min(start, finish);
            int columnEndIndex = Math.max(start, finish);

            int inputLength1 = rowEndIndex - rowStartIndex + 1;
            int inputLength2 = columnEndIndex - columnStartIndex + 1;

            if (!checkSpace(rowStartIndex, columnStartIndex, rowEndIndex, columnEndIndex)) {
                System.out.println("Error! You placed it too close to another one. Try again:");
                createShip(lengthOfShip, nameOfShip);
            } else if (rowStartIndex != rowEndIndex && columnStartIndex != columnEndIndex) {
                System.out.println("Error! Wrong ship location! Try again:");
                createShip(lengthOfShip, nameOfShip);
            } else if (inputLength1 != lengthOfShip && inputLength2 != lengthOfShip) {
                System.out.println("Error! Wrong length of the " + nameOfShip + "! Try again:");
                createShip(lengthOfShip, nameOfShip);
            } else {
                if (rowStartIndex == rowEndIndex) {
                    for (int i = columnStartIndex; i <= columnEndIndex; i++) {
                        gameField[rowStartIndex][i] = placeOfShip;
                    }
                } else {
                    for (int i = rowStartIndex; i <= rowEndIndex; i++) {
                        gameField[i][columnStartIndex] = placeOfShip;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error. The coordinates are incorrect. Try again:");
            createShip(lengthOfShip, nameOfShip);
        }
    }

    public static void createAircraftCarrier() {
        System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):");
        createShip(5, "Aircraft Carrier");
    }

    public static void createBattleShip() {
        System.out.println("Enter the coordinates of the Battleship (4 cells):");
        createShip(4, "Battleship");
    }

    public static void createSubmarine() {
        System.out.println("Enter the coordinates of the Submarine (3 cells):");
        createShip(3, "Submarine");
    }

    public static void createCruiser() {
        System.out.println("Enter the coordinates of the Cruiser (3 cells):");
        createShip(3, "Cruiser");
    }

    public static void createDestroyer() {
        System.out.println("Enter the coordinates of the Destroyer (2 cells):");
        createShip(2, "Destroyer");
    }

    private static void takeShot () {
        try {
            String[] inputShot = sc.nextLine().split("");

            int rowShotIndex = mapCharToInt(inputShot[0].charAt(0));

            int columnShotIndex = Integer.parseInt(inputShot[1]) - 1;

            if (gameField[rowShotIndex][columnShotIndex] == placeOfShip) {
                gameField[rowShotIndex][columnShotIndex] = 'X';
                System.out.println("You hit a ship!");
                printGameField();
            } else {
                gameField[rowShotIndex][columnShotIndex] = 'M';
                System.out.println("You missed!");
                printGameField();
            }
        } catch (Exception e) {
            System.out.println("Error! You entered the wrong coordinates! Try again:");
            takeShot();
        }
    }
}
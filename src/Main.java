import java.util.Scanner;

public class Main {
    static final char EMPTY_AREA = '~';
    static char[][] emptyGameField = makeGameField();
    static char[][] gameField = makeGameField();

    static final char PLACE_OF_SHIP = 'O';
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        printGameField(emptyGameField);
        createAircraftCarrier();
        printGameField(gameField);
        createBattleShip();
        printGameField(gameField);
        createSubmarine();
        printGameField(gameField);
        createCruiser();
        printGameField(gameField);
        createDestroyer();
        printGameField(gameField);
        System.out.println("The game starts!");
        System.out.println();
        printGameField(emptyGameField);
        System.out.println("Take a shot!");
        System.out.println();
        takeShot();
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
        System.out.println();
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
                if (gameField[i][j] != EMPTY_AREA) {
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
                System.out.println();
                createShip(lengthOfShip, nameOfShip);
            } else if (rowStartIndex != rowEndIndex && columnStartIndex != columnEndIndex) {
                System.out.println("Error! Wrong ship location! Try again:");
                System.out.println();
                createShip(lengthOfShip, nameOfShip);
            } else if (inputLength1 != lengthOfShip && inputLength2 != lengthOfShip) {
                System.out.println("Error! Wrong length of the " + nameOfShip + "! Try again:");
                System.out.println();
                createShip(lengthOfShip, nameOfShip);
            } else {
                if (rowStartIndex == rowEndIndex) {
                    for (int i = columnStartIndex; i <= columnEndIndex; i++) {
                        gameField[rowStartIndex][i] = PLACE_OF_SHIP;
                    }
                } else {
                    for (int i = rowStartIndex; i <= rowEndIndex; i++) {
                        gameField[i][columnStartIndex] = PLACE_OF_SHIP;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error. The coordinates are incorrect. Try again:");
            System.out.println();
            createShip(lengthOfShip, nameOfShip);
        }
    }

    public static void createAircraftCarrier() {
        System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):");
        System.out.println();
        createShip(5, "Aircraft Carrier");
        System.out.println();
    }

    public static void createBattleShip() {
        System.out.println("Enter the coordinates of the Battleship (4 cells):");
        System.out.println();
        createShip(4, "Battleship");
        System.out.println();
    }

    public static void createSubmarine() {
        System.out.println("Enter the coordinates of the Submarine (3 cells):");
        System.out.println();
        createShip(3, "Submarine");
        System.out.println();
    }

    public static void createCruiser() {
        System.out.println("Enter the coordinates of the Cruiser (3 cells):");
        System.out.println();
        createShip(3, "Cruiser");
        System.out.println();
    }

    public static void createDestroyer() {
        System.out.println("Enter the coordinates of the Destroyer (2 cells):");
        System.out.println();
        createShip(2, "Destroyer");
        System.out.println();
    }

    private static void takeShot () {
        try {
            String[] inputShot = sc.nextLine().split("");

            int rowShotIndex = mapCharToInt(inputShot[0].charAt(0));

            int columnShotIndex = Integer.parseInt(inputShot[1]) - 1;

            if (gameField[rowShotIndex][columnShotIndex] == PLACE_OF_SHIP) {
                gameField[rowShotIndex][columnShotIndex] = 'X';
                emptyGameField[rowShotIndex][columnShotIndex] = 'X';
                printGameField(emptyGameField);
                System.out.println("You hit a ship!");
                System.out.println();
            } else {
                gameField[rowShotIndex][columnShotIndex] = 'M';
                emptyGameField[rowShotIndex][columnShotIndex] = 'M';
                printGameField(emptyGameField);
                System.out.println("You missed!");
                System.out.println();
            }
            printGameField(gameField);
        } catch (Exception e) {
            System.out.println("Error! You entered the wrong coordinates! Try again:");
            System.out.println();
            takeShot();
            System.out.println();
        }
    }
}
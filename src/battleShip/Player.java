package battleShip;

import java.util.Scanner;

import static battleShip.Game.*;

class Player {
    char[][] emptyGameField = makeGameField();
    char[][] gameField = makeGameField();
    static Scanner sc = new Scanner(System.in);
    int shipCounter = 5;


    private void createShip(int lengthOfShip, String nameOfShip, Ship ship) {
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

            if (!checkSpace(rowStartIndex, columnStartIndex, rowEndIndex, columnEndIndex, gameField)) {
                System.out.println("Error! You placed it too close to another one. Try again:");
                System.out.println();
                createShip(lengthOfShip, nameOfShip, ship);
            } else if (rowStartIndex != rowEndIndex && columnStartIndex != columnEndIndex) {
                System.out.println("Error! Wrong ship location! Try again:");
                System.out.println();
                createShip(lengthOfShip, nameOfShip, ship);
            } else if (inputLength1 != lengthOfShip && inputLength2 != lengthOfShip) {
                System.out.println("Error! Wrong length of the " + nameOfShip + "! Try again:");
                System.out.println();
                createShip(lengthOfShip, nameOfShip, ship);
            } else {
                Coordinate coordinate = new Coordinate();
                coordinate.startRowIndex = rowStartIndex;
                coordinate.endRowIndex = rowEndIndex;
                coordinate.startColumnIndex = columnStartIndex;
                coordinate.endColumnIndex = columnEndIndex;
                ship.coordinate = coordinate;
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
            createShip(lengthOfShip, nameOfShip, ship);
        }
    }

    public void createAircraftCarrier(Ship ship) {
        System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):");
        System.out.println();
        createShip(5, "Aircraft Carrier", ship);
        System.out.println();
    }

    public void createBattleShip(Ship ship) {
        System.out.println("Enter the coordinates of the Battleship (4 cells):");
        System.out.println();
        createShip(4, "Battleship", ship);
        System.out.println();
    }

    public void createSubmarine(Ship ship) {
        System.out.println("Enter the coordinates of the Submarine (3 cells):");
        System.out.println();
        createShip(3, "Submarine", ship);
        System.out.println();
    }

    public void createCruiser(Ship ship) {
        System.out.println("Enter the coordinates of the Cruiser (3 cells):");
        System.out.println();
        createShip(3, "Cruiser", ship);
        System.out.println();
    }

    public void createDestroyer(Ship ship) {
        System.out.println("Enter the coordinates of the Destroyer (2 cells):");
        System.out.println();
        createShip(2, "Destroyer", ship);
        System.out.println();
    }

    public void takeShot (char[][] gameField, char[][] emptyGameField, String owner) {
        try {
            String[] inputShot = sc.nextLine().split("");

            int rowShotIndex = mapCharToInt(inputShot[0].charAt(0));

            int columnShotIndex = 0;
            if (inputShot.length == 2) {
                columnShotIndex = Integer.parseInt(inputShot[1]) - 1;
            } else if (inputShot.length == 3) {
                columnShotIndex = Integer.parseInt(inputShot[1] + inputShot[2]) - 1;
            }

            do {
                if (gameField[rowShotIndex][columnShotIndex] == PLACE_OF_SHIP) {
                    gameField[rowShotIndex][columnShotIndex] = 'X';
                    emptyGameField[rowShotIndex][columnShotIndex] = 'X';
                    System.out.println();
                    printGameField(emptyGameField);
                    Ship hittedShip = null;
                    for (Ship ship : Ship.values()) {
                        if ((rowShotIndex >= ship.coordinate.startRowIndex && rowShotIndex <= ship.coordinate.endRowIndex)
                                && (columnShotIndex >= ship.coordinate.startColumnIndex && columnShotIndex <= ship.coordinate.endColumnIndex) && owner.equals(ship.owner)) {
                            ship.decreaseHealth();
                            hittedShip = ship;
                            break;
                        }
                    }
                    if (hittedShip.health == 0) {
                        shipCounter--;
                        if (shipCounter != 0) {
                            System.out.println("You sank a ship! Specify a new target:");
                        } else {
                            System.out.println("You sank the last ship. You won. Congratulations!");
                            break;
                        }
                    } else {
                        System.out.println("You hit a ship!");
                    }
                    System.out.println();
                } else {
                    gameField[rowShotIndex][columnShotIndex] = 'M';
                    emptyGameField[rowShotIndex][columnShotIndex] = 'M';
                    System.out.println();
                    printGameField(emptyGameField);
                    System.out.println("You missed!");
                }
                System.out.println("Press Enter and pass the move to another player");
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
            } while (emptyGameField[rowShotIndex][columnShotIndex] == PLACE_OF_SHIP);
        } catch (Exception e) {
            System.out.println("Error! You entered the wrong coordinates! Try again:");
            System.out.println();
            takeShot(gameField, emptyGameField, owner);
            System.out.println();
        }
    }
}

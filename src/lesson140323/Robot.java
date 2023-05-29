package lesson140323;

import java.util.Scanner;

class Move {
    public static void main(String[] args) {
        Robot robot = new Robot(5, 2, Direction.UP);
        moveRobot(robot, 5, -9);
        System.out.println(robot.getX());
        System.out.println(robot.getY());
    }
    public static void moveRobot(Robot robot, int toX, int toY) {
        int x = robot.getX();
        int y = robot.getY();
        Direction direction = robot.getDirection();

        if (direction == Direction.UP && x < toX || direction == Direction.DOWN && x > toX) {
            robot.turnRight();
        } else if (direction == Direction.UP && x > toX || direction == Direction.DOWN && x < toX) {
            robot.turnLeft();
        } else if (direction == Direction.LEFT && x < toX) {
            robot.turnRight();
            robot.turnRight();
        } else if (direction == Direction.RIGHT && x > toX) {
            robot.turnLeft();
            robot.turnLeft();
        }

        while (x != toX) {
            robot.stepForward();
            x = robot.getX();
        }

        direction = robot.getDirection();

        if (direction == Direction.LEFT && y < toY || direction == Direction.RIGHT && y > toY) {
            robot.turnRight();
        } else if (direction == Direction.LEFT && y > toY || direction == Direction.RIGHT && y < toY) {
            robot.turnLeft();
        } else if (direction == Direction.DOWN && y < toY) {
            robot.turnRight();
            robot.turnRight();
        } else if (direction == Direction.UP && y > toY) {
            robot.turnRight();
            robot.turnRight();
        }

        while (y != toY) {
            robot.stepForward();
            y = robot.getY();
        }

//your implementation here
    }
}

//Don't change code below

enum Direction {
    UP(0, 1),
    DOWN(0, -1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public Direction turnLeft() {
        switch (this) {
            case UP:
                return LEFT;
            case DOWN:
                return RIGHT;
            case LEFT:
                return DOWN;
            case RIGHT:
                return UP;
            default:
                throw new IllegalStateException();
        }
    }

    public Direction turnRight() {
        switch (this) {
            case UP:
                return RIGHT;
            case DOWN:
                return LEFT;
            case LEFT:
                return UP;
            case RIGHT:
                return DOWN;
            default:
                throw new IllegalStateException();
        }
    }

    public int dx() {
        return dx;
    }

    public int dy() {
        return dy;
    }
}

class Robot {
    private int x;
    private int y;
    private Direction direction; // ?

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void stepForward() {
        x += direction.dx(); // ?
        y += direction.dy();
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}



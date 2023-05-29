package lesson140323;


enum DanderLevel {
    HIGH(3),
    MEDIUM(2),
    LOW(1);

    public static void main(String[] args) {
        DanderLevel high = DanderLevel.HIGH;
        DanderLevel medium = DanderLevel.MEDIUM;

        System.out.println(high.getLevel() > medium.getLevel());
    }

    private int level;
    DanderLevel (int dangerLevel) {
        this.level = dangerLevel;
    }

    int getLevel() {
        return level;
    }
}
package battleShip;

enum Ship {
    AIRCRAFT_CARRIER_FIRST_PLAYER(5, "First"),
    BATTLE_SHIP_FIRST_PLAYER(4, "First"),
    SUBMARINE_FIRST_PLAYER(3,"First"),
    CRUISER_FIRST_PLAYER(3, "First"),
    DESTROYER_FIRST_PLAYER(2, "First"),
    AIRCRAFT_CARRIER_SECOND_PLAYER(5, "Second"),
    BATTLE_SHIP_SECOND_PLAYER(4, "Second"),
    SUBMARINE_SECOND_PLAYER(3, "Second"),
    CRUISER_SECOND_PLAYER(3, "Second"),
    DESTROYER_SECOND_PLAYER(2, "Second");

    int health;
    String owner;
    Coordinate coordinate;

    Ship(int health, String owner) {
        this.health = health;
        this.owner = owner;
    }

    int decreaseHealth() {
        return --health;
    }
}

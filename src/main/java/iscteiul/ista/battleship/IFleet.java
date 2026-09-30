package iscteiul.ista.battleship;

import java.util.List;

/**
 * Defines the collection of ships and fleet operations used by the game.
 */
public interface IFleet {
    /**
     * The width and height of the square game board.
     */
    Integer BOARD_SIZE = 10;

    /**
     * The maximum number of ships in a fleet.
     */
    Integer FLEET_SIZE = 10;

    /**
     * Returns all ships currently in the fleet.
     *
     * @return the fleet's ships
     */
    List<IShip> getShips();

    /**
     * Adds a ship when its placement is valid and does not conflict with
     * another ship.
     *
     * @param s the ship to add
     * @return {@code true} if the ship was added
     */
    boolean addShip(IShip s);

    /**
     * Returns all ships belonging to a category.
     *
     * @param category the category to search for
     * @return the ships matching the category
     */
    List<IShip> getShipsLike(String category);

    /**
     * Returns all ships that have not been sunk.
     *
     * @return the fleet's floating ships
     */
    List<IShip> getFloatingShips();

    /**
     * Finds the ship occupying a position.
     *
     * @param pos the position to search for
     * @return the occupying ship, or {@code null} if no ship occupies it
     */
    IShip shipAt(IPosition pos);

    /**
     * Prints the current status of the fleet.
     */
    void printStatus();
}

package iscteiul.ista.battleship;

import java.util.List;

/**
 * Defines the operations and statistics for a battleship game in progress.
 */
public interface IGame {
    /**
     * Fires a shot at a position.
     *
     * @param pos the position targeted by the shot
     * @return the ship sunk by the shot, or {@code null} if no ship was sunk
     */
    IShip fire(IPosition pos);

    /**
     * Returns the positions of valid shots already fired.
     *
     * @return the fired shot positions
     */
    List<IPosition> getShots();

    /**
     * Returns the number of shots repeated by the player.
     *
     * @return the number of repeated shots
     */
    int getRepeatedShots();

    /**
     * Returns the number of shots outside the board.
     *
     * @return the number of invalid shots
     */
    int getInvalidShots();

    /**
     * Returns the number of shots that hit a ship.
     *
     * @return the number of hits
     */
    int getHits();

    /**
     * Returns the number of ships sunk in the game.
     *
     * @return the number of sunk ships
     */
    int getSunkShips();

    /**
     * Returns the number of ships that remain afloat.
     *
     * @return the number of remaining ships
     */
    int getRemainingShips();

    /**
     * Prints a board showing valid shots that have been fired.
     */
    void printValidShots();

    /**
     * Prints the current fleet board.
     */
    void printFleet();
}

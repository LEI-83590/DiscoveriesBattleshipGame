package iscteiul.ista.battleship;

import java.util.List;

/**
 * Defines the behavior and state exposed by a ship in the battleship game.
 */
public interface IShip {
    /**
     * Returns the ship's category.
     *
     * @return the ship category
     */
    String getCategory();

    /**
     * Returns the number of positions occupied by the ship.
     *
     * @return the ship size
     */
    Integer getSize();

    /**
     * Returns the positions occupied by the ship.
     *
     * @return the ship's occupied positions
     */
    List<IPosition> getPositions();

    /**
     * Returns the ship's starting position.
     *
     * @return the starting position
     */
    IPosition getPosition();

    /**
     * Returns the ship's orientation.
     *
     * @return the ship's bearing
     */
    Compass getBearing();

    /**
     * Determines whether at least one position of the ship has not been hit.
     *
     * @return {@code true} if the ship is still floating
     */
    boolean stillFloating();

    /**
     * Returns the smallest row occupied by the ship.
     *
     * @return the topmost row
     */
    int getTopMostPos();

    /**
     * Returns the largest row occupied by the ship.
     *
     * @return the bottommost row
     */
    int getBottomMostPos();

    /**
     * Returns the smallest column occupied by the ship.
     *
     * @return the leftmost column
     */
    int getLeftMostPos();

    /**
     * Returns the largest column occupied by the ship.
     *
     * @return the rightmost column
     */
    int getRightMostPos();

    /**
     * Determines whether the ship occupies a position.
     *
     * @param pos the position to check
     * @return {@code true} if the ship occupies the position
     */
    boolean occupies(IPosition pos);

    /**
     * Determines whether this ship is adjacent to another ship.
     *
     * @param other the other ship
     * @return {@code true} if the ships are too close to one another
     */
    boolean tooCloseTo(IShip other);

    /**
     * Determines whether this ship is adjacent to a position.
     *
     * @param pos the position to check
     * @return {@code true} if the ship is too close to the position
     */
    boolean tooCloseTo(IPosition pos);

    /**
     * Applies a shot to the matching position occupied by the ship.
     *
     * @param pos the position that was shot
     */
    void shoot(IPosition pos);
}

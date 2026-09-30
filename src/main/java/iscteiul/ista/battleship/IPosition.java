package iscteiul.ista.battleship;

/**
 * Defines a coordinate on the battleship game board and its state.
 */
public interface IPosition {
    /**
     * Returns the row coordinate.
     *
     * @return the row coordinate
     */
    int getRow();

    /**
     * Returns the column coordinate.
     *
     * @return the column coordinate
     */
    int getColumn();

    /**
     * Compares this position with another object.
     *
     * @param other the object to compare with
     * @return {@code true} if the objects represent the same position
     */
    boolean equals(Object other);

    /**
     * Determines whether another position is adjacent to this position.
     *
     * @param other the position to compare with
     * @return {@code true} if the positions are adjacent
     */
    boolean isAdjacentTo(IPosition other);

    /**
     * Marks this position as occupied by a ship.
     */
    void occupy();

    /**
     * Marks this position as hit by a shot.
     */
    void shoot();

    /**
     * Indicates whether this position is occupied.
     *
     * @return {@code true} if a ship occupies this position
     */
    boolean isOccupied();

    /**
     * Indicates whether this position has been hit.
     *
     * @return {@code true} if this position has been hit
     */
    boolean isHit();
}

package iscteiul.ista.battleship;

import java.util.Objects;

/**
 * Represents a coordinate on the game board and tracks whether that coordinate
 * is occupied by a ship and whether it has been hit.
 */
public class Position implements IPosition {
    private int row;
    private int column;
    private boolean isOccupied;
    private boolean isHit;

    /**
     * Creates an unoccupied and unharmed position.
     *
     * @param row the row coordinate
     * @param column the column coordinate
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
        this.isOccupied = false;
        this.isHit = false;
    }

    /**
     * Returns the row coordinate.
     *
     * @return the row coordinate
     */
    @Override
    public int getRow() {
        return row;
    }

    /**
     * Returns the column coordinate.
     *
     * @return the column coordinate
     */
    @Override
    public int getColumn() {
        return column;
    }

    /**
     * Returns a hash code based on this position's coordinates and state.
     *
     * @return the hash code for this position
     */
    @Override
    public int hashCode() {
        return Objects.hash(column, isHit, isOccupied, row);
    }

    /**
     * Compares this position with another position by row and column.
     *
     * @param otherPosition the object to compare with
     * @return {@code true} if both objects represent the same coordinates
     */
    @Override
    public boolean equals(Object otherPosition) {
        if (this == otherPosition)
            return true;
        if (otherPosition instanceof IPosition) {
            IPosition other = (IPosition) otherPosition;
            return (this.getRow() == other.getRow() && this.getColumn() == other.getColumn());
        } else {
            return false;
        }
    }

    /**
     * Determines whether another position is at most one row and one column
     * away from this position.
     *
     * @param other the position to compare with
     * @return {@code true} when the positions are adjacent or equal
     */
    @Override
    public boolean isAdjacentTo(IPosition other) {
        return (Math.abs(this.getRow() - other.getRow()) <= 1 && Math.abs(this.getColumn() - other.getColumn()) <= 1);
    }

    /**
     * Marks this position as occupied by a ship.
     */
    @Override
    public void occupy() {
        isOccupied = true;
    }

    /**
     * Marks this position as hit by a shot.
     */
    @Override
    public void shoot() {
        isHit = true;
    }

    /**
     * Indicates whether a ship occupies this position.
     *
     * @return {@code true} if the position is occupied
     */
    @Override
    public boolean isOccupied() {
        return isOccupied;
    }

    /**
     * Indicates whether this position has been hit.
     *
     * @return {@code true} if the position has been hit
     */
    @Override
    public boolean isHit() {
        return isHit;
    }

    /**
     * Returns a human-readable representation of this position.
     *
     * @return the row and column coordinates
     */
    @Override
    public String toString() {
        return ("Linha = " + row + " Coluna = " + column);
    }

}

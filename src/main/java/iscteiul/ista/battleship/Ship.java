package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Base implementation shared by all ship types in the game.
 */
public abstract class Ship implements IShip {

    private static final String GALEAO = "galeao";
    private static final String FRAGATA = "fragata";
    private static final String NAU = "nau";
    private static final String CARAVELA = "caravela";
    private static final String BARCA = "barca";

    /**
     * Creates a concrete ship for the supplied kind, bearing, and starting
     * position.
     *
     * @param shipKind the ship kind to create
     * @param bearing the ship's orientation
     * @param pos the ship's starting position
     * @return the created ship, or {@code null} when the kind is unknown
     */
    static Ship buildShip(String shipKind, Compass bearing, Position pos) {
        Ship s;
        switch (shipKind) {
            case BARCA:
                s = new Barge(bearing, pos);
                break;
            case CARAVELA:
                s = new Caravel(bearing, pos);
                break;
            case NAU:
                s = new Carrack(bearing, pos);
                break;
            case FRAGATA:
                s = new Frigate(bearing, pos);
                break;
            case GALEAO:
                s = new Galleon(bearing, pos);
                break;
            default:
                s = null;
        }
        return s;
    }


    private String category;
    private Compass bearing;
    private IPosition pos;
    protected List<IPosition> positions;


    /**
     * Creates a ship with the supplied category, orientation, and starting
     * position.
     *
     * @param category the ship category
     * @param bearing the ship's orientation
     * @param pos the ship's starting position
     */
    public Ship(String category, Compass bearing, IPosition pos) {
        assert bearing != null;
        assert pos != null;

        this.category = category;
        this.bearing = bearing;
        this.pos = pos;
        positions = new ArrayList<>();
    }

    /**
     * Returns this ship's category.
     *
     * @return the ship category
     */
    @Override
    public String getCategory() {
        return category;
    }

    /**
     * Returns the positions occupied by this ship.
     *
     * @return the ship's occupied positions
     */
    public List<IPosition> getPositions() {
        return positions;
    }

    /**
     * Returns this ship's starting position.
     *
     * @return the starting position
     */
    @Override
    public IPosition getPosition() {
        return pos;
    }

    /**
     * Returns this ship's orientation.
     *
     * @return the ship's bearing
     */
    @Override
    public Compass getBearing() {
        return bearing;
    }

    /**
     * Determines whether at least one position occupied by this ship has not
     * been hit.
     *
     * @return {@code true} if the ship is still afloat
     */
    @Override
    public boolean stillFloating() {
        for (int i = 0; i < getSize(); i++)
            if (!getPositions().get(i).isHit())
                return true;
        return false;
    }

    /**
     * Returns the smallest row occupied by this ship.
     *
     * @return the topmost row
     */
    @Override
    public int getTopMostPos() {
        int top = getPositions().get(0).getRow();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getRow() < top)
                top = getPositions().get(i).getRow();
        return top;
    }

    /**
     * Returns the largest row occupied by this ship.
     *
     * @return the bottommost row
     */
    @Override
    public int getBottomMostPos() {
        int bottom = getPositions().get(0).getRow();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getRow() > bottom)
                bottom = getPositions().get(i).getRow();
        return bottom;
    }

    /**
     * Returns the smallest column occupied by this ship.
     *
     * @return the leftmost column
     */
    @Override
    public int getLeftMostPos() {
        int left = getPositions().get(0).getColumn();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getColumn() < left)
                left = getPositions().get(i).getColumn();
        return left;
    }

    /**
     * Returns the largest column occupied by this ship.
     *
     * @return the rightmost column
     */
    @Override
    public int getRightMostPos() {
        int right = getPositions().get(0).getColumn();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getColumn() > right)
                right = getPositions().get(i).getColumn();
        return right;
    }

    /**
     * Determines whether this ship occupies a given position.
     *
     * @param pos the position to check
     * @return {@code true} if the ship occupies the position
     */
    @Override
    public boolean occupies(IPosition pos) {
        assert pos != null;

        for (int i = 0; i < getSize(); i++)
            if (getPositions().get(i).equals(pos))
                return true;
        return false;
    }

    /**
     * Determines whether this ship is adjacent to another ship.
     *
     * @param other the other ship
     * @return {@code true} if any positions of the ships are adjacent
     */
    @Override
    public boolean tooCloseTo(IShip other) {
        assert other != null;

        Iterator<IPosition> otherPos = other.getPositions().iterator();
        while (otherPos.hasNext())
            if (tooCloseTo(otherPos.next()))
                return true;

        return false;
    }

    /**
     * Determines whether this ship is adjacent to a given position.
     *
     * @param pos the position to check
     * @return {@code true} if any position of this ship is adjacent to the
     *         supplied position
     */
    @Override
    public boolean tooCloseTo(IPosition pos) {
        for (int i = 0; i < this.getSize(); i++)
            if (getPositions().get(i).isAdjacentTo(pos))
                return true;
        return false;
    }
    /**
     * Marks the ship's matching position as hit by a shot.
     *
     * @param pos the position that was shot
     */
    @Override
    public void shoot(IPosition pos) {
        assert pos != null;

        for (IPosition position : getPositions()) {
            if (position.equals(pos))
                position.shoot();
        }
    }
    /**
     * Returns a human-readable representation of this ship.
     *
     * @return the category, bearing, and starting position
     */
    @Override
    public String toString() {
        return "[" + category + " " + bearing + " " + pos + "]";
    }

}

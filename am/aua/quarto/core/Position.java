package am.aua.quarto.core;

/**
 * This is a class for storing and representing a position on a am.aua.quarto.core.figures.Quarto board.
 * It contains two int instance variables representing the position,
 * and constructor, accessor and mutator methods. Constructors create new objects using mutators, which create a new
 * object only if the arguments are valid
 */

public class Position {


    /*
     * am.aua.quarto.core.figures.Position row on the board, starting from the bottom.
     * Classic quarto board squares are ranked from 1 to 4. The value 0
     * corresponds with the 1st row and
     * a value of 3 corresponds with the 4th row.
     */
    private int row;

    /*
     * am.aua.quarto.core.figures.Position column on the board, starting from the left.
     * Classic quarto board squares have columns numbered from 1 to 4.
     * The value 0 corresponds with the 1st column and
     * a value of 3 corresponds with the 4th column.
     */

    private int column;

    /**
     * A no-arg constructor, initializes with 0's, corresponds with the lowest cell on the board.
     */

    public Position(){
        this.row = 0;
        this.column = 0;
    }

    /**
     * A copy constructor that initializes the instance variable based on the corresponding values of
     * <code>am.aua.quarto.core.figures.Position</code> object.
     *
     * @param position     the original position, according to which the new object
     *                     is created
     */
    public Position (Position position) {
        this(position.getRow(), position.getColumn());
    }

    /**
     * A parameterized constructor, initializes the fields with given values as arguments.
     *
     * @param row         an integer representing the row
     * @param column      an integer representing the column
     */
    Position(int row, int column) {
        this.setRow(row);
        this.setColumn(column);
    }

    /**
     * Accessor method for the row of the position.
     *
     * @return          the row of the position
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Accessor method for the column of the position.
     *
     * @return          the column of the position
     */
    public int getColumn() {
        return this.column;
    }

    /**
     * Mutator method for the row of the position.
     *
     * @param row      the new row value
     */
    public void setRow(int row) {
        if (row >= 0 && row < 4)
            this.row = row;
    }

    /**
     * Mutator method for the column of the position.
     *
     * @param column      the new column value
     */
    private void setColumn(int column) {
        if (column >= 0 && column < 4)
            this.column = column;
    }

    /**
     * Returns a <code>String</code> representation of this
     * <code>am.aua.quarto.core.figures.Position</code> with a format like "C2".
     *
     * @return          the <code>String</code> representation
     */
    public String toString() { return "" + this.row + this.column; }

    /**
     * Returns a <code>am.aua.quarto.core.figures.Position</code> object based on the provided
     * arguments for row and column
     *
     * @return          the <code>am.aua.quarto.core.figures.Position</code> object
     */

    public static Position generatePosition(int row, int column){
        return new Position(row, column);
    }

}
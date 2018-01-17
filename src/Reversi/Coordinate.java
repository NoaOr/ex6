package Reversi;

public class Coordinate {
    private int row;
    private int col;

    /**
     * Constructor.
     * @param row - the row.
     * @param col - the col.
     */
    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * getter of the col.
     * @return column.
     */
    public int getCol() {
        return this.col;
    }

    /**
     * getter of the row.
     * @return - row.
     */
    public int getRow() {
        return this.row;
    }
}

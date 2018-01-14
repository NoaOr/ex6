package Reversi;

public class Coordinate {
    private int row;
    private int col;


    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public int getCol() {
        return this.col;
    }
    public int getRow() {
        return this.row;
    }
}

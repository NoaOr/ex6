package Reversi;

public class Coordinate {
    private int row;
    private int col;


    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }
    int getCol() {
        return this.col;
    }
    int getRow() {
        return this.row;
    }
}

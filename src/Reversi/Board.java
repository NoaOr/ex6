package Reversi;

import java.util.List;

public class Board {

    private Cell boardTable[][];
    private int rowSize;
    private int colSize;
    private GameLogic gameLogic;


    /**
     * constructor
     * @param rowSize - number of rows.
     * @param colSize - number od columns.
     * @param logic - the logic of the game.
     */
    public Board(int rowSize, int colSize, GameLogic logic){
        this.gameLogic = logic;
        this.rowSize = rowSize;
        this.colSize = colSize;
        this.boardTable = new Cell[rowSize][rowSize];

        int midRow = rowSize / 2 - 1;
        int midCol = colSize / 2 - 1;
        this.boardTable[midRow][midCol].setValue(Cell.Value.O);
        this.boardTable[midRow + 1][midCol + 1].setValue(Cell.Value.O);
        this.boardTable[midRow][midCol + 1].setValue(Cell.Value.X);
        this.boardTable[midRow + 1][midCol].setValue(Cell.Value.X);

    }
    /**
     * this function needs to flip all the cells in the
     * list and show the board again.
     * @param coordinate - the player's choice.
     * @param changedTo - the player's value.
     */
    public void updateBoard(Coordinate coordinate, Cell.Value changedTo) {
        int row = coordinate.getRow()-1;
        int col = coordinate.getCol()-1;
        this.boardTable[row][col].setValue(changedTo);
        Coordinate coor = new Coordinate(row, col);
        List<Coordinate> cellsToFlip;
        cellsToFlip =
                this.gameLogic.findOptions(coor, changedTo, this);
        //list<Coordinate> ::iterator iter;
//        for (iter = cellsToFlip.begin(); iter != cellsToFlip.end(); ++iter) {
        for (int i = 0; i < cellsToFlip.size(); i++) {
            int x = cellsToFlip.get(i).getRow(), y = cellsToFlip.get(i).getCol();
            this.boardTable[x][y].setValue(changedTo);
        }
    }
    /**
     *
     * @return number of columns.
     */
    public int getColSize() {
        return this.colSize;
    }
    /**
     *
     * @return number of rows.
     */
    public int getRowSize() {
        return this.rowSize;
    }
/**
 *
 * @param coor - the coordinate.
 * @return the board in the requested
 */
    public Cell getCellAt(Coordinate coor) {
        int x = coor.getRow();
        int y = coor.getCol();
        Cell c = this.boardTable[x][y];
        return c;
    }
}

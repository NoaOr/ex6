package Reversi;

public class Board {


    private Cell*** boardTable;
    private int rowSize;
    private int colSize;
    private GameLogic gameLogic;

    public Board(int rowSize, int colSize, GameLogic logic){
        this.gameLogic = logic;
        this.rowSize = rowSize;
        this.colSize = colSize;
        this.boardTable = new Cell**[rowSize];
    }
}

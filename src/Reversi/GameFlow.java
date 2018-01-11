package Reversi;

//#define BOARD_SIZE 8


import javafx.stage.Stage;

public class GameFlow {

    private Board board;
    private GameLogic logic;
    private Player player1;
    private Player player2;
    private Screen screen;
    private boolean isPlayer1Turn;


    public GameFlow(GameLogic logic, Player player1, Player player2, Board board) {
//        this.board = new Board(boardSize, boardSize, logic);
        this.logic = logic;
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        this.isPlayer1Turn = true;
//        this.screen = screen;
    }

    public void run() {
//        this.screen.showBoard(this.board);

        isPlayer1Turn = true;
        while (player1.hasMoreMoves() || player2.hasMoreMoves()) {
            if (this.isBoardFull()) {
                break;
            }
            //   Coordinate coor = player1.doYourTurn(this.board, this.screen);
            // if (player1.hasMoreMoves()) {
            //   this.board.updateBoard(coor, player1.getVal());
            // player1.showChoice(coor, screen);
//            this.screen.showBoard(this.board);
            //  }
            if (this.isBoardFull()) {
                break;
            }
            this.isPlayer1Turn = false;
            // coor = player2.doYourTurn(this.board, this.screen);
            //if (player2.hasMoreMoves()) {
            //  this.board.updateBoard(coor, player2.getVal());
            //player2.showChoice(coor, screen);
//            this.screen.showBoard(this.board);
        }
        //this.screen.gameOverScreen(board);
    }


    public boolean isBoardFull() {
        boolean isFull = true;
        for (int i = 0; i < this.board.getRowSize(); i++) {
            for (int j = 0; j < this.board.getColSize(); j++) {
                if (this.board.getCellAt(new Coordinate(i,j)).getValue() == Cell.Value.Empty) {
                    isFull = false;
                }
            }
        }
        return isFull;
    }


    public void aKeyWasPressed(Coordinate coor) {
        if (isPlayer1Turn) {
            this.board.updateBoard(coor, player1.getVal());
        } else {
            this.board.updateBoard(coor, player2.getVal());
        }
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }
    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }
}


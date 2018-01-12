package Reversi;

//#define BOARD_SIZE 8


import javafx.stage.Stage;

import java.net.HttpURLConnection;
import java.util.List;

public class GameFlow {

    private Board board;
    private GameLogic logic;
    private HumanPlayer player1;
    private HumanPlayer player2;
    private Screen screen;
    private boolean isPlayer1Turn;
    private String player1Color;
    private String player2Color;
    private GameController controller;

    public GameFlow(GameController controller, GameLogic logic, HumanPlayer player1, HumanPlayer player2,
                    Board board, String player1Color, String player2Color) {
        this.logic = logic;
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        this.player1Color = player1Color;
        this.player2Color = player2Color;
        this.isPlayer1Turn = true;
        this.controller = controller;
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
//            if (this.isBoardFull()) {
//                break;
//            }
//            this.isPlayer1Turn = false;
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


    public boolean aKeyWasPressed(Coordinate coor) {
        /// לבדוק שהקוארדיננטה תקינה
        List<Coordinate> options;
        if (isPlayer1Turn) {
            options =  player1.getOptionsList(this.board);
            if (isValidCoordinate(options,coor)) {
                this.board.updateBoard(coor, player1.getVal());
                if (isBoardFull()) {
                    return false;
                }
                // if player 2 has move
                if (!this.player2.getOptionsList(board).isEmpty()) {
                     isPlayer1Turn = false;
                } else {
                    if (this.player1.getOptionsList(board).isEmpty()) {
                        return false;
                    }
                }
            }
        } else {
            options =  player2.getOptionsList(this.board);
            if (isValidCoordinate(options,coor)) {
                this.board.updateBoard(coor, player2.getVal());
                if (isBoardFull()) {
                    return false;
                }
                if (!this.player1.getOptionsList(board).isEmpty()) {
                    isPlayer1Turn = true;
                } else {
                    if (player2.getOptionsList(board).isEmpty()) {
                        return false;
                    }
                }
            }
        }
        return true;

    }

    public boolean isValidCoordinate(List<Coordinate> options, Coordinate coor) {
        boolean isInList = false;
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).getRow() == coor.getRow() -1 &&
                    options.get(i).getCol() == coor.getCol() -1) {
                isInList = true;
                break;
            }
        }
        return isInList;
    }


    public List<Coordinate> getCurrentOptionList() {
        if (isPlayer1Turn) {
            return player1.getOptionsList(this.board);
        } else {
            return player2.getOptionsList(this.board);
        }
    }

    public void setGameInformation() {
        String currentPlayer;
        if(isPlayer1Turn) {
            currentPlayer = this.player1Color;
        } else {
            currentPlayer = this.player2Color;
        }
        String player1Score = this.board.getPlayerScore(this.player1.getVal());
        String player2Score = this.board.getPlayerScore(this.player2.getVal());
        String information = "Current player: " + currentPlayer + "\n" +
                                this.player1Color + " player score: " + player1Score + "\n" +
                                this.player2Color + " player score: " + player2Score + "\n";
        this.controller.setInformation(information);
    }



}


package Reversi;

//#define BOARD_SIZE 8


import sample.GameController;

import java.util.List;

public class GameFlow {

    private Board board;
    private GameLogic logic;
    private HumanPlayer player1;
    private HumanPlayer player2;
    private boolean isPlayer1Turn;
    private String player1Color;
    private String player2Color;
    private GameController controller;
    private boolean isGameOver;

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
        this.isGameOver = false;
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
        List<Coordinate> options;
        if (isPlayer1Turn) {
            options =  player1.getOptionsList(this.board);
            if (isValidCoordinate(options,coor)) {
                this.board.updateBoard(coor, player1.getVal());
                if (isBoardFull()) {
                    this.endGame();
                    return;
                }
                // if player 2 has move
                if (!this.player2.getOptionsList(board).isEmpty()) {
                     isPlayer1Turn = false;
                } else {
                    if (this.player1.getOptionsList(board).isEmpty()) {
                        this.endGame();
                        return;
                    }
                }
            }
        } else {
            options =  player2.getOptionsList(this.board);
            if (isValidCoordinate(options,coor)) {
                this.board.updateBoard(coor, player2.getVal());
                if (isBoardFull()) {
                    this.endGame();
                    return;
                }
                if (!this.player1.getOptionsList(board).isEmpty()) {
                    isPlayer1Turn = true;
                } else {
                    if (player2.getOptionsList(board).isEmpty()) {
                        this.endGame();
                        return;
                    }
                }
            }
        }
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
        if (isGameOver) {
            return;
        }
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

    public void endGame() {
        this.isGameOver = true;
        String message = "The game is over!\n\n";
        String player1Score = this.board.getPlayerScore(this.player1.getVal());
        String player2Score = this.board.getPlayerScore(this.player2.getVal());
        int score1 = Integer.parseInt(player1Score);
        int score2 = Integer.parseInt(player2Score);

        if (score1 > score2) {
            message = message + "The winner is " + player1Color + "!\n";
        } else if (score2 > score1) {
            message = message +"The winner is " + player2Color + "!\n";
        } else {
            message = message +"It's a Tie!\n";
        }

        message = message +this.player1Color + " player score: " + player1Score + "\n" +
                this.player2Color + " player score: " + player2Score + "\n";
        this.controller.setInformation("Game Over!");
        this.controller.showAlert(message);




    }




}


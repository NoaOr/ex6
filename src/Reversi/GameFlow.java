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

    /**
     * constructor.
     * @param controller - the game controller.
     * @param logic - the game logic.
     * @param player1 - a human player.
     * @param player2 - a human player.
     * @param board - the board of the game.
     * @param player1Color - string of the player 1 color.
     * @param player2Color - string of the player 2 color.
     */
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

    /**
     * The function checks if the board is full.
     * @return true if full, and false otherwise.
     */
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

    /**
     * The function checks the coordinate that the user pressed on.
     * it checks all the terms of the game and runs the game.
     * @param coor - the coordinate that has been pressed.
     */
    public void aKeyWasPressed(Coordinate coor) {
        List<Coordinate> options;
        String noMove = "No Move!";
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
                    //player 2 has no move
                    this.controller.showAlert(noMove,
                            player2Color + " player has no move!\n" +
                                    "It's " + player1Color + " player turn.");
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
                    //player 1 has no move
                    this.controller.showAlert(noMove,
                            player1Color + " player has no move!\n" +
                                    "It's " + player2Color + " player turn.");
                    if (player2.getOptionsList(board).isEmpty()) {
                        this.endGame();
                        return;
                    }
                }
            }
        }
    }

    /**
     * the function checks if the coordinate that was pressed is valid.
     * @param options - the list of valid coordinates.
     * @param coor - the coordinate.
     * @return true if valid and false otherwise.
     */
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
        this.controller.showAlert("Game Over!", message);

    }




}


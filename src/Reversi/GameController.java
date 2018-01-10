package Reversi;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    private Game game;
    @FXML
    private HBox root;
    private Cell[][] board;

    public GameController() {

    }
    public void initGame(Game game) {
        this.game = game;
        int rowSize = game.getBoardSize();
        board = new Cell[rowSize][rowSize];

        int midRow = rowSize / 2 - 1;
        int midCol = rowSize / 2 - 1;
        board[midRow][midCol].setValue(Cell.Value.Player2Val);
        board[midRow + 1][midCol + 1].setValue(Cell.Value.Player2Val);
        board[midRow][midCol + 1].setValue(Cell.Value.Player1Val);
        board[midRow + 1][midCol].setValue(Cell.Value.Player1Val);
    }
@Override
public void initialize(URL location, ResourceBundle resources) {
        BoardController boardController = new BoardController(this.board, game.getPlayer1Color(),
                game.getPlayer2Color());
        boardController.setPrefWidth(400);
        boardController.setPrefHeight(400);
        root.getChildren().add(0, boardController);
        boardController.draw();
        }
}

package Reversi;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class BoardController extends GridPane{
    private Cell[][] board;
    private String player1Color;
    private String player2Color;

    public BoardController(Cell[][] board, String player1Color,
            String player2Color) {
        this.board = board;
        this.player1Color = player1Color;
        this.player2Color = player2Color;
        FXMLLoader fxmlLoader = new
                FXMLLoader(getClass().getResource("BoardController.fxml"));
//        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }


    public void draw() {
        this.getChildren().clear();

        int height = (int)this.getPrefHeight();
        int width = (int)this.getPrefWidth();

        int cellHeight = height / board.length;
        int cellWidth = width / board[0].length;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].getValue() == Cell.Value.Empty) {
                    this.add(new Rectangle(cellWidth, cellHeight,
                            Color.YELLOW), j, i);
                }
                else if (board[i][j].getValue() == Cell.Value.Player1Val) {
                    this.add(new Rectangle(cellWidth, cellHeight,
                            parseColor(player1Color)), j, i);
                }
                else if (board[i][j].getValue() == Cell.Value.Player2Val) {
                    this.add(new Rectangle(cellWidth, cellHeight,
                            parseColor(player2Color)), j, i);
                }
            }
        }
    }

    public Color parseColor(String color) {
        if (color.equals("Black")) {
            return Color.BLACK;
        }
        else if (color.equals("White")) {
            return Color.WHITE;
        }
        else if (color.equals("Yellow")) {
            return Color.YELLOW;
        }
        else if (color.equals("Green")) {
            return Color.GREEN;
        }
        else if (color.equals("Blue")) {
            return Color.BLUE;
        }
        else if (color.equals("Red")) {
            return Color.RED;
        }
        return Color.BLACK;
    }
}
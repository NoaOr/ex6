package Reversi;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class GuiBoard extends GridPane{
    private Board board;
    private GuiPlayer player1;
    private GuiPlayer player2;
    private final int prefHeight = 450;
    private final int prefWidth = 600;

    public GuiBoard(Board board, String player1Color,
                    String player2Color,
                    final GameFlow gameFlow, HumanPlayer humanPlayer1, HumanPlayer humanPlayer2) {
        this.board = board;
        this.player1 = new GuiPlayer(humanPlayer1, player1Color);
        this.player2 = new GuiPlayer(humanPlayer2, player2Color);

        FXMLLoader fxmlLoader = new
                FXMLLoader(getClass().getResource("GuiBoard.fxml"));
   ///     fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
            final int cellHeight = prefHeight / board.getRowSize();
            final int cellWidth = prefWidth / board.getColSize();
            this.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    int x = (int)event.getX();
                    int y = (int)event.getY();
                    x = (x / cellHeight) + 1;
                    y = (y / cellWidth) + 1;
                    gameFlow.aKeyWasPressed(new Coordinate(y, x));
                    List<Coordinate> options = gameFlow.getCurrentOptionList();
                    GuiBoard.this.draw();
                    gameFlow.setGameInformation();
                    GuiBoard.this.drawOptionList(options);

                }
            });
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }


    public void draw() {
        this.getChildren().clear();
        int height = (int)this.getPrefHeight();
        int width = (int)this.getPrefWidth();
        int cellHeight = height / board.getRowSize();
        int cellWidth = width / board.getColSize();


        for (int i = 0; i < board.getRowSize(); i++) {
            for (int j = 0; j < board.getColSize(); j++) {
                    Rectangle r = new Rectangle(cellWidth, cellHeight, Color.TRANSPARENT);
                    r.setStroke(Color.BLACK);
                    this.add(r, j, i);
            }
        }

        for (int i = 0; i < board.getRowSize(); i++) {
            for (int j = 0; j < board.getColSize(); j++) {
                if (board.getCellAt(new Coordinate(i, j)).getValue() == Cell.Value.Player1Val) {
                    player1.draw(cellWidth, cellHeight, i, j, this);
                }
                else if (board.getCellAt(new Coordinate(i, j)).getValue() == Cell.Value.Player2Val) {
                    player2.draw(cellWidth, cellHeight, i, j, this);
                }
            }
        }
    }

    public void drawOptionList(List<Coordinate> options) {
        int height = (int)this.getPrefHeight();
        int width = (int)this.getPrefWidth();
        int cellHeight = height / board.getRowSize();
        int cellWidth = width / board.getColSize();
        for (int i = 0; i < options.size(); i++) {
//            Rectangle r = new Rectangle(cellWidth, cellHeight, Color.TRANSPARENT);
//            r.setStroke(Color.rgb(37, 187, 200));
            Circle c = new Circle(5, Color.rgb(37, 187, 200));
            c.setStroke(Color.BLACK);
//            c.setStrokeWidth(2);


//            c.setCenterX(options.get(i).getCol() + 25);
//            c.setCenterY(options.get(i).getCol() + 25);
            this.add(c, options.get(i).getCol(), options.get(i).getRow());
        }
    }

}
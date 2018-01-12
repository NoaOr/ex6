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
    private final int prefHeight = 400;
    private final int prefWidth = 400;

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
                    boolean isGameContinue = gameFlow.aKeyWasPressed(new Coordinate(y, x));
                    if (!isGameContinue) {
                        GuiBoard.this.showEndOfGame();
                        return;
                    }
                    List<Coordinate> options = gameFlow.getCurrentOptionList();
                    GuiBoard.this.draw();
                    gameFlow.setGameInformation();
                    GuiBoard.this.drawOptionList(options);
                    //GuiBoard.this.showEndOfGame();

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
                    Rectangle r = new Rectangle(cellWidth, cellHeight, Color.YELLOW);
                    r.setStroke(Color.BLACK);
                    this.add(r, j, i);
            }
        }

        for (int i = 0; i < board.getRowSize(); i++) {
            for (int j = 0; j < board.getColSize(); j++) {
                if (board.getCellAt(new Coordinate(i, j)).getValue() == Cell.Value.Player1Val) {
//                    this.add(new Rectangle(cellWidth, cellHeight,
//                            parseColor(player1Color)), j, i);
                    player1.draw(cellWidth, cellHeight, i, j, this);
                }
                else if (board.getCellAt(new Coordinate(i, j)).getValue() == Cell.Value.Player2Val) {
//                    this.add(new Rectangle(cellWidth, cellHeight,
//                            parseColor(player2Color)), j, i);
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
            Rectangle r = new Rectangle(cellWidth, cellHeight, Color.YELLOW);
            r.setStroke(Color.RED);
            Circle c = new Circle(5, Color.RED);
            c.setStroke(Color.BLACK);
//            c.setCenterX(options.get(i).getCol() + 25);
//            c.setCenterY(options.get(i).getCol() + 25);
            this.add(c, options.get(i).getCol(), options.get(i).getRow());
        }
    }

    public void showEndOfGame() {
        this.getChildren().clear();
        Text text1 = new Text(25, 25, "Game Over!");
        text1.setFill(Color.CHOCOLATE);
        text1.setFont(Font.font(java.awt.Font.SERIF, 25));
        this.getChildren().add(text1);
    }
}
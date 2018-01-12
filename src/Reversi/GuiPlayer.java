package Reversi;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class GuiPlayer {
    private HumanPlayer humanPlayer;
    private String colorStr;

    public GuiPlayer(HumanPlayer humanPlayer, String colorStr) {
        this.humanPlayer = humanPlayer;
        this.colorStr = colorStr;


        // Load the player's image
//        iv = new
//                ImageView(getClass().getResource("minion.png").toExternalForm());

    }
    public void draw(int cellWidth, int cellHeight,
                     int currentRow, int currentCol, GridPane gridPane) {
        Color color = parseColor(colorStr);
//        iv.setFitWidth(cellWidth);
//        iv.setFitHeight(cellHeight);
//        grid.getChildren().remove(iv);
        int i = currentCol + 25;
        int j = currentRow + 25;
        int radius = (cellHeight / 2);
        Rectangle r = new Rectangle(cellWidth, cellHeight, color);
        r.setStroke(Color.BLACK);
        Circle c = new Circle(radius, i, j);
//        c.setStroke(Color.BLACK);
        gridPane.add(r, currentCol, currentRow);
        //  grid.add(iv, currentCol, currentRow);
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

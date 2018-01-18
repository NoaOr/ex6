package sample;

import Reversi.HumanPlayer;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class GuiPlayer {
    private HumanPlayer humanPlayer;
    private String colorStr;

    /**
     * constructor.
     * @param humanPlayer - human player
     * @param colorStr - string of the player color.
     */
    public GuiPlayer(HumanPlayer humanPlayer, String colorStr) {
        this.humanPlayer = humanPlayer;
        this.colorStr = colorStr;
    }

    /**
     * the function draws rectangle in specific coordinate.
     * @param cellWidth - cell width
     * @param cellHeight - cell height
     * @param currentRow - row
     * @param currentCol - column
     * @param gridPane - grid pane
     */
    public void draw(int cellWidth, int cellHeight,
                     int currentRow, int currentCol, GridPane gridPane) {
        Color color = parseColor(colorStr);
        Rectangle r = new Rectangle(cellWidth, cellHeight, color);
        r.setStroke(Color.BLACK);
        gridPane.add(r, currentCol, currentRow);
    }

    /**
     * the function parses string of color to color object.
     * @param color - string color
     * @return color object according to the string.
     */

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

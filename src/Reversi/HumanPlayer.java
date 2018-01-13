package Reversi;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class HumanPlayer {


    private Cell.Value value;
    private GameLogic logic;
    private boolean hasMove;


    public HumanPlayer(Cell.Value value, GameLogic logic) {

        this.value = value;
        this.logic = logic;
        this.hasMove = true;
    }


    /**
     * gets he choice.
     *
     * @return the chosen coordinate.
     */

    public Cell.Value getVal() {
        return this.value;
    }

    /**
     * checks if the player has more moves.
     *
     * @return boolean
     */



    public List<Coordinate> getOptionsList(Board board) {
        List<Coordinate> optionsList = new ArrayList<Coordinate>();
        int row = board.getRowSize(), col = board.getColSize();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Coordinate coor = new Coordinate(i, j);

                if (!this.logic.findOptions(coor, this.value, board).isEmpty()
                        && board.getCellAt(coor).getValue() == Cell.Value.Empty) {
                    optionsList.add(coor);
                }
            }
        }
        return optionsList;
    }
}

package Reversi;

import java.util.List;
import java.util.ArrayList;

public class GameLogic {
    private boolean isRegular;

    public GameLogic() {
        this.isRegular = true;
    }
    /**
     *
     * @param coor
     * @param value
     * @param board
     * @return the list of cells that need to be fliped
     */
    public List<Coordinate> findOptions(Coordinate coor,
                                        Cell.Value value, Board board) {

        Cell.Value otherVal;
        Cell.Value myVal = value;
        List<Coordinate> cellsToFlip = new ArrayList<Coordinate>();
        if (myVal == Cell.Value.Player1Val) {
            otherVal = Cell.Value.Player2Val;
        } else {
            otherVal = Cell.Value.Player1Val;
        }
        // if the point is not on the board return empty list.
        if(!this.isOnBoard(coor, board)) {
            //return nullptr;
            return new ArrayList<Coordinate>();
        }
        int startX = coor.getRow();
        int startY = coor.getCol();
        List<Coordinate> directions = new ArrayList<Coordinate>();
        directions.add(new Coordinate(0,1));
        directions.add(new Coordinate(0,-1));
        directions.add(new Coordinate(1,1));
        directions.add(new Coordinate(1,-1));
        directions.add(new Coordinate(1,0));
        directions.add(new Coordinate(-1,-1));
        directions.add(new Coordinate(-1,0));
        directions.add(new Coordinate(-1,1));
        //List<Coordinate> ::const_iterator iter;

        for (int i = 0; i < directions.size(); i++) {

        //for (iter = directions.begin(); iter != directions.end(); ++iter) {
            int x = startX, y = startY;
            // advance the coordinate to the direction that in the list:
            x += directions.get(i).getRow();
            y += directions.get(i).getCol();
            Coordinate c = new Coordinate(x, y);

            // if the cell on the board and the value is not my value:
            // advance the cell in the same direction
            if (isOnBoard(c, board) && board.getCellAt(c).getValue() == otherVal) {
                x += directions.get(i).getRow();
                y += directions.get(i).getCol();
                c = new Coordinate(x, y);

                if (!isOnBoard(c, board)) {
                    continue;
                }

                if (board.getCellAt(c).getValue() == myVal) {
                    x -= directions.get(i).getRow();
                    y -= directions.get(i).getCol();
                    Coordinate coordinate = new Coordinate(x, y);
                    cellsToFlip.add(coordinate);
                    x += directions.get(i).getRow();
                    y += directions.get(i).getCol();
                }
                while (board.getCellAt(c).getValue() == otherVal) {
                    x += directions.get(i).getRow();
                    y += directions.get(i).getCol();
                    c = new Coordinate(x, y);
                    if (!isOnBoard(c, board)) {
                        break;
                    }
                }

                if (isOnBoard(c, board)) {
                    if (board.getCellAt(c).getValue() == myVal) {
                        while (x != startX || y != startY) {
                            x -= directions.get(i).getRow();
                            y -= directions.get(i).getCol();
                            c = new Coordinate(x, y);
                            cellsToFlip.add(c);
                        }
                    }
                }
            }

        }
        if (cellsToFlip.size() == 0) {
            return new ArrayList<Coordinate>();
        }
        return cellsToFlip;


    }
    public boolean isRegular(){
        return this.isRegular;
    }


    boolean isOnBoard(Coordinate coor, Board board) {
        int y = coor.getCol(), x = coor.getRow();
        int colSize = board.getColSize() - 1, rowSize = board.getRowSize() - 1;
        return (x >= 0 && x <= rowSize && y >= 0 && y <= colSize);
    }

}

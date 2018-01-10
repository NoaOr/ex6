package Reversi;

public interface Player {
    /**
     * the player chooses cell.
     * @param board - the board.
     * @return - the chosen coordinate.
     */
    Coordinate doYourTurn(Board board, Screen screen);
    /**
     * gets he choice.
     * @param optionsList - list of option cells.
     * @return the chosen coordinate.
     */
    Cell.Value getVal();
    /**
     * checks if the player has more moves.
     * @return boolean
     */
    boolean hasMoreMoves();
    /**
     * The function handles the case that the player had no moves.
     * @param screen - the screen to show that he has no moves.
     */
    void movePasses(Screen screen, char value);
    /**
     * The function shows what the player chose.
     * @param c - the chosen coordinate.
     * @param screen - the screen.
     */
    void showChoice(Coordinate c, Screen screen);

    char valueToChar(Cell.Value val);

}

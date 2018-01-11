package Reversi;

import java.util.List;

public interface Screen {
/**
 * Noa Or 208385534
 * Amit Hadas 315968263
 */
        /**
         * the function shows the screen.
         * @param board - the board.
         */
        public void showBoard(Board board);
/**
 * prints the winner value.
 * @param board - the board.
 */
    public void gameOverScreen(Board board);
        /**
         * The function shows what was the player's choice.
         * @param val - the player's value.
         * @param c - the player's choice.
         */
        public void showPlayersChoice(Cell.Value val, Coordinate c);
        /**
         * The function shows that the move passes to the other player.
         * @param val - The player's value.
         */
        public void showMovePasses(Cell.Value val);
        /**
         * The function handles the case that the player chose un valid coordinate.
         */
        public void showUnValidMove();

    public void showOptions(List<Coordinate> optionsList, char value);
        /**
         * The function shows the menu and gets choice from the player.
         * @return player choice
         */
        public int menu();
        /**
         * The function puts the message on the screen.
         * @param msg - the message.
         */
        public void showMessage(String msg);
        /**
         * The function puts the message on the screen.
         * @param msg - the message.
         * @param msgSize - the message's size.
         */
        public void showMessage(char msg[], int msgSize);
        /**
         * This function shows that the opponent has no move.
         */
        public void opponentHasNoMove();
        /**
         *
         * @param i
         * @return
         */
        public String scanFromUser(int i);
        public void showList(List<String> namesList);

}

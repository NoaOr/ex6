//package Reversi;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class HumanPlayer implements Player{
//
//
//    private Cell.Value value;
//    private GameLogic logic;
//    private boolean hasMove;
//
//    public HumanPlayer(Cell.Value value, GameLogic logic) {
//        this.value = value;
//        this.logic = logic;
//        this.hasMove = true;
//    }
//    /**
//     * the player chooses cell.
//     *
//     * @param board  - the board.
//     * @param screen
//     * @return - the chosen coordinate.
//     */
//    @Override
//    public Coordinate doYourTurn(Board board, Screen screen) {
//        List<Coordinate> optionsList = new ArrayList<Coordinate>();
//        int row = board.getRowSize(), col = board.getColSize();
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                Coordinate coor = new Coordinate(i, j);
//
//                if (!this.logic.findOptions(coor, this.value, board).isEmpty()
//                        && board.getCellAt(coor).getValue() == Cell.Value.Empty) {
//                    optionsList.add(coor);
//                }
//            }
//        }
//        char stringVal;
//        if (this.value == Cell.Value.Player1Val) {
//            stringVal = 'Player1Val';
//        } else {
//            stringVal = 'Player2Val';
//        }
//
//
//
//        if (!optionsList.isEmpty()) {
//            this.hasMove = true;
//            screen.showOptions(optionsList, stringVal);
////
//            Coordinate choice = this.getChoice(optionsList, screen);
//            return choice;
//        } else {
//            movePasses(screen, stringVal);
//        }
//        return new Coordinate(-1,-1);
//    }
//
//
////
////    Coordinate HumanPlayer ::getChoice(list<Coordinate> optionsList, Screen *screen) const {
////        list<Coordinate> ::const_iterator listIterator;
////        bool isInList = false;
////        int num1 = -1, num2 = -1;
////        cin >> num1 >> num2;
////        if (!num1 || !num2) {
////            cin.clear();
////            cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
////        }
////
////        Coordinate choice = Coordinate(num1, num2);
////        for (listIterator = optionsList.begin();
////             listIterator != optionsList.end(); ++listIterator) {
////            if (num1 == listIterator->getRow() + 1
////                    && num2 == listIterator ->getCol() + 1) {
////                isInList = true;
////                choice = Coordinate(num1, num2);
////                break;
////            }
////        }
////        if (!isInList) {
////            screen->showUnValidMove();
////            choice = this ->getChoice(optionsList, screen);
////        }
////
////        return choice;
////    }
//
//    /**
//     * gets he choice.
//     *
//     * @return the chosen coordinate.
//     */
//    @Override
//    public Cell.Value getVal() {
//        return this.value;
//    }
//
//    /**
//     * checks if the player has more moves.
//     *
//     * @return boolean
//     */
//    @Override
//    public boolean hasMoreMoves() {
//        return this.hasMove;
//    }
//
//    /**
//     * The function handles the case that the player had no moves.
//     *
//     * @param screen - the screen to show that he has no moves.
//     * @param value
//     */
//    @Override
//    public void movePasses(Screen screen, char value) {
//        this.hasMove = false;
//        screen.showMovePasses(this.getVal());
//    }
//
//    /**
//     * The function shows what the player chose.
//     *
//     * @param c      - the chosen coordinate.
//     * @param screen - the screen.
//     */
//    @Override
//    public void showChoice(Coordinate c, Screen screen) {
//
//    }
//
//    @Override
//    public char valueToChar(Cell.Value val) {
//        if (val == Cell.Value.Player2Val) {
//            return 'Player2Val';
//        } else if (val == Cell.Value.Player1Val){
//            return 'Player1Val';
//        }
//        return ' ';    }
//}

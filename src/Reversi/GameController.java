package Reversi;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    @FXML
    private HBox root;
    private Board board;
    private int boardSize;
    private String player1Color;
    private String player2Color;
    private String openPlayer;
    private HumanPlayer player1;
    private HumanPlayer player2;

    public void createBoardFromFile() {

        String fileName = "settings.txt";
        BufferedReader br = null;
        FileReader fr = null;
        Map<String, String> settingsMap = new HashMap<String, String>();
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                String[] parts = sCurrentLine.split(" : ");
                settingsMap.put(parts[0], parts[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        openPlayer = settingsMap.get("open player");
        player1Color = settingsMap.get("player 1 color");
        player2Color = settingsMap.get("player 2 color");
        String size = settingsMap.get("board size");
        String[] parts = size.split("x");
        boardSize = Integer.parseInt(parts[0]);
        this.board = new Board(boardSize, boardSize, new GameLogic());

//        int rowSize = boardSize;
//        this.board = new Cell[rowSize][rowSize];
//
//        for (int i = 0; i < boardSize; i++) {
//            for (int j = 0; j < boardSize; j++) {
//                this.board[i][j] = new Cell(Cell.Value.Empty);
//            }
//        }
//
//        int midRow = rowSize / 2 - 1;
//        int midCol = rowSize / 2 - 1;
//        this.board[midRow][midCol].setValue(Cell.Value.Player2Val);
//        this.board[midRow + 1][midCol + 1].setValue(Cell.Value.Player2Val);
//        this.board[midRow][midCol + 1].setValue(Cell.Value.Player1Val);
//        this.board[midRow + 1][midCol].setValue(Cell.Value.Player1Val);
    }
@Override
public void initialize(URL location, ResourceBundle resources) {
        this.createBoardFromFile();
        GameLogic gameLogic = new GameLogic();
        BoardController boardController = new BoardController(this.board, player1Color,
                player2Color);
        this.player1 = new HumanPlayer(Cell.Value.Player1Val, gameLogic,
                boardController, boardController.parseColor(this.player1Color));
        this.player2 = new HumanPlayer(Cell.Value.Player2Val, gameLogic,
                boardController, boardController.parseColor(this.player2Color));
        boardController.setPlayer1(player1);
        boardController.setPlayer2(player2);
        boardController.setPrefWidth(400);
        boardController.setPrefHeight(400);
        root.getChildren().add(0, boardController);
        boardController.draw();
        GameFlow gameFlow = new GameFlow(gameLogic, player1, player2, board);
        gameFlow.run();
    }
}

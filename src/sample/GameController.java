package sample;

import Reversi.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    @FXML
    private HBox root;
    @FXML
    private Label info;
    @FXML
    private Button endGame;
    private Board board;
    private int boardSize;
    private String player1Color;
    private String player2Color;
    private String openPlayer;
    private static final int defaultSize = 8;
    private final int prefHeight = 400;
    private final int prefWidth = 400;

    /**
     * the functions reads information from the setting file,
     * creates board accordingly and save it as a member.
     * @param gameLogic -game logic, for the board constructor.
     */
    public void createBoardFromFile(GameLogic gameLogic) {

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
            this.board = new Board(defaultSize, defaultSize, gameLogic);
            this.openPlayer = "Player 1";
            this.player1Color = "Black";
            this.player2Color = "White";
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
        this.board = new Board(boardSize, boardSize, gameLogic);

    }

    /**
     * the function all of the objects for the game,
     * shows the board and make the game to run.
     * @param location - location
     * @param resources - resources
     */
    @Override
public void initialize(URL location, ResourceBundle resources) {
    GameLogic gameLogic = new GameLogic();
    this.createBoardFromFile(gameLogic);
    HumanPlayer humanPlayer1, humanPlayer2;
    GameFlow gameFlow;
    GuiBoard guiBoard;

    if (openPlayer.equals("Player 1")) {
        humanPlayer1 = new HumanPlayer(Cell.Value.Player1Val, gameLogic);
        humanPlayer2 = new HumanPlayer(Cell.Value.Player2Val, gameLogic);
        gameFlow = new GameFlow(this, gameLogic, humanPlayer1,
                humanPlayer2, board, player1Color, player2Color);
        guiBoard = new GuiBoard(this.board, this.player1Color,
                this.player2Color, gameFlow, humanPlayer1, humanPlayer2);

    } else {
        humanPlayer1 = new HumanPlayer(Cell.Value.Player2Val, gameLogic);
        humanPlayer2 = new HumanPlayer(Cell.Value.Player1Val, gameLogic);
        gameFlow = new GameFlow(this, gameLogic, humanPlayer1,
                humanPlayer2, board, player2Color, player1Color);
        guiBoard = new GuiBoard(this.board, this.player2Color,
                this.player1Color, gameFlow, humanPlayer1, humanPlayer2);

    }
        guiBoard.setPrefWidth(prefWidth);
        guiBoard.setPrefHeight(prefHeight);
        root.getChildren().add(0, guiBoard);
        guiBoard.draw();
        gameFlow.setGameInformation();
        List<Coordinate> options = gameFlow.getCurrentOptionList();
        guiBoard.drawOptionList(options);
    }

    /**
     * the function set the information label in the screen.
     * @param information - information to write.
     */
    public void setInformation (String information) {
        this.info.setText(information);
    }

    /**
     * end game Button's function.
     * go back to menu.
     */
    public void endGame() {
        Menu menu = new Menu();
        try {
            menu.start((Stage) this.endGame.getScene().getWindow());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * the function shows alert.
     * @param title - title for alert
     * @param message - message for alert
     */
    public void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }
}

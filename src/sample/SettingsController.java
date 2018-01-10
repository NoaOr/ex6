package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.*;

public class SettingsController {

    @FXML
    private Button ok;

    @FXML
    private ComboBox openPlayer;

    @FXML
    private ComboBox player1Color;

    @FXML
    private ComboBox player2Color;

    @FXML
    private ComboBox boardSize;



    ObservableList<String> openPlayerList =
            FXCollections.observableArrayList("Player 1", "Player 2");


    ObservableList<String> playersColorList =
            FXCollections.observableArrayList
                    ("Black", "White", "Yellow", "Blue", "Green", "Red");


    ObservableList<String> boardSizeList =
            FXCollections.observableArrayList("4x4", "5x5", "6x6",
                    "7x7", "8x8","9x9", "10x10", "11x11",
                    "12x12", "13x13", "14x14", "15x15", "16x16");


    @FXML
    private void initialize() {
        openPlayer.setValue("Player 1");
        openPlayer.setItems(openPlayerList);

        player1Color.setValue("Black");
        player1Color.setItems(playersColorList);

        player2Color.setValue("White");
        player2Color.setItems(playersColorList);

        boardSize.setValue("8x8");
        boardSize.setItems(boardSizeList);

    }
    @FXML
    protected void finish() {
        String openPlayerStr = openPlayer.getValue().toString();
        String player1ColorStr = player1Color.getValue().toString();
        String player2ColorStr = player2Color.getValue().toString();
        String boardSizeStr = boardSize.getValue().toString();

        writeSettingsToFile(openPlayerStr, player1ColorStr, player2ColorStr, boardSizeStr);

        Menu menu = new Menu();
        try {
            menu.start((Stage)ok.getScene().getWindow());
        } catch (Exception e) {

        }

    }

    @FXML
    private void writeSettingsToFile
            (String openPlayer, String player1Color, String player2Color, String boardSize) {

        Writer writer = null;

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("settings.txt"), "utf-8"));
            writer.write("open player : " + openPlayer + "\n");
            writer.write("player 1 color : " + player1Color + "\n");
            writer.write("player 2 color : " + player2Color + "\n");
            writer.write("board size : " + boardSize + "\n");

        } catch (IOException ex) {
            // report
        } finally {
            try {writer.close();} catch (Exception ex) {/*ignore*/}
        }
    }
}

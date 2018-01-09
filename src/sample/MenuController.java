package sample;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.awt.*;

public class MenuController {

    @FXML
    private Button startButton;

    @FXML
    private Button settingsButton;

    @FXML
    private void startGame(Stage primaryStage) {

    }

    @FXML
    protected void settings() {
        Settings settings = new Settings();
        Stage stage = (Stage) settingsButton.getScene().getWindow();
        try {
            settings.start(stage);
        } catch (Exception e) {

        }
    }
}

package Graphic;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class MenuController {

    @FXML
    private Button startButton;

    @FXML
    private Button settingsButton;

    @FXML
    /**
     * the function creates game main when the startButton is pressed.
     */
    protected void startGame() {
        GameMain gameMain = new GameMain();
        Stage stage = (Stage) startButton.getScene().getWindow();
        gameMain.start(stage);
    }

    @FXML
    /**
     * the function creates settings screen when the settingsButton is pressed.
     */
    protected void settings() {
        Settings settings = new Settings();
        Stage stage = (Stage) settingsButton.getScene().getWindow();
        try {
            settings.start(stage);
        } catch (Exception e) {

        }
    }
}

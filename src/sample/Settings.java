package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Settings extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        try {
            GridPane root = (GridPane) FXMLLoader.load(getClass().getResource("settingsFxml.fxml"));
            Scene scene = new Scene(root,400,350);
            scene.getStylesheets().add(getClass().getResource("SettingsCss.css").toExternalForm());
            primaryStage.setTitle("Settings");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Settings extends Application {

//    public static void main(String[] args) {
//        launch(args);
//    }

    @Override
    public void start(Stage primaryStage) {

        try {

            FXMLLoader loader = new FXMLLoader(
                    (ClassLoader.getSystemClassLoader().getResource("settingsFxml.fxml")));
            GridPane root = (GridPane) loader.load();
            Scene scene = new Scene(root,600,450);
            scene.getStylesheets().add(getClass().getResource("SettingsCss.css").toExternalForm());
            primaryStage.setTitle("Settings");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

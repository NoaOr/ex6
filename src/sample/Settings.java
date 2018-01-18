package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Settings extends Application {
    private final int height = 450;
    private final int width = 600;
    @Override
    /**
     * the function starts the settings application.
     */
    public void start(Stage primaryStage) {

        try {

            FXMLLoader loader = new FXMLLoader(
                    (ClassLoader.getSystemClassLoader().getResource("settingsFxml.fxml")));
            GridPane root = (GridPane) loader.load();
            Scene scene = new Scene(root,width,height);
            scene.getStylesheets().add(getClass().getResource("SettingsCss.css").toExternalForm());
            primaryStage.setTitle("Settings");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

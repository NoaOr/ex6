package Graphic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Menu extends Application {
    private final int height = 450;
    private final int width = 600;
    @Override
    /**
     * the function starts the menu application.
     */
    public void start(Stage primaryStage) throws Exception{
        try {
            GridPane root = (GridPane) FXMLLoader.load(getClass().getResource("MenuFxml.fxml"));
//            scene.getStylesheets().add(getClass().getResource("res../../SettingsCss.css").toExternalForm());
//            FXMLLoader loader = new FXMLLoader(
//                    (ClassLoader.getSystemClassLoader().getResource("res../../MenuFxml.fxml")));
//            GridPane root = (GridPane) loader.load();
            Scene scene = new Scene(root,width,height);
            scene.getStylesheets().add(getClass().getResource("MenuCss.css").toExternalForm());
//            scene.getStylesheets().add(getClass().getResource("res../../MenuCss.css").toExternalForm());
            primaryStage.setTitle("Reversi");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * main function - shows menu.
     * @param args - ignore
     */
    public static void main(String[] args) {
        launch(args);
    }
}

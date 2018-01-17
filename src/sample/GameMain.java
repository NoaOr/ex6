package sample;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class GameMain extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {

            FXMLLoader loader = new FXMLLoader(
                    (ClassLoader.getSystemClassLoader().getResource("GameFxml.fxml")));
            HBox root = loader.load();
            Scene scene = new Scene(root,600,450);
            scene.getStylesheets().add(getClass().getResource("GameCss.css").toExternalForm());
            primaryStage.setTitle("Reversi game");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
//    public static void main(String[] args) {
//        launch(args);
//    }
}

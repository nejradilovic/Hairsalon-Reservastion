package ba.unsa.etf.rpr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;
/**
 * class that extends Application
 * @author Nejra Adilovic
 */
public class AppFX extends Application{
    /**
     * Opens LogIn window
     * @param primaryStage Stage
     * @throws Exception in case of an error
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        primaryStage.setTitle("LogIn");
        primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("/img/loginlogo.png"));
        primaryStage.show();
    }
    /**
     * Main runnable method
     * @param args String[]
     */
    public static void main(String[] args) {
        launch(args);
    }
}

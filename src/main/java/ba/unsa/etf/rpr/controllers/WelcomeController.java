package ba.unsa.etf.rpr.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ba.unsa.etf.rpr.controllers.OpenNewStage;

import java.io.IOException;
import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;
public class WelcomeController {
    public ImageView appointmentId;
    public AnchorPane anchorPaneId;
    OpenNewStage o=new OpenNewStage();

    public void mainWindowOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        o.openWindow(anchorPaneId, "mainWindow" );
    }

}

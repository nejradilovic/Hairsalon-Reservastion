package ba.unsa.etf.rpr.controllers;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
public class WelcomeController {
    public ImageView appointmentId;
    public AnchorPane anchorPaneId;
    public ImageView aboutId;
    OpenNewStage o=new OpenNewStage();
    /**
     * Opens a dialog window with the provided FXML file path when you press on a certain part of the screen
     *@throws IOException when there is a problem with loading the FXML file.
     */
    public void mainWindowOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        o.openWindow(anchorPaneId, "mainWindow" );
    }
    /**
     * Opens a dialog window with the provided FXML file path when you press on a certain part of the screen
     *@throws IOException when there is a problem with loading the FXML file.
     */
    public void aboutOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        o.openWindow(anchorPaneId,"aboutUs");
    }
}

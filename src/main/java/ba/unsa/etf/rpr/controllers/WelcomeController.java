package ba.unsa.etf.rpr.controllers;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
public class WelcomeController {
    public ImageView appointmentId;
    public AnchorPane anchorPaneId;
    OpenNewStage o=new OpenNewStage();

    public void mainWindowOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        o.openWindow(anchorPaneId, "mainWindow" );
    }

}

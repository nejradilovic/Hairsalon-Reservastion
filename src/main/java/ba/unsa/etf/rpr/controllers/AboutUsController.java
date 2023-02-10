package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
/**
 * AboutUsController gives you information about the app
 * @author Nejra Adilovic
 */
public class AboutUsController {
    public BorderPane borderPaneId;
    public ImageView logoutIcon;
    public Button logoutId;
    public Button appointmentId;
    public ImageView appointmentImageId;
    OpenNewStage o= new OpenNewStage();
    /**
     * Opens the login window when you press on the logout icon
     * @throws IOException when there is a problem with loading the FXML file.
     */
    public void logoutOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        o.openWindow(borderPaneId,"login");
    }
    /**
     * Opens the login window when you press on logout button
     * @throws IOException when there is a problem with loading the FXML file.
     */
    public void logoutOnAction(ActionEvent actionEvent) throws IOException {
        o.openWindow(borderPaneId,"login");
    }
    /**
     * Opens the my appointments window when you press on the text that says "My appointments"
     * @throws IOException when there is a problem with loading the FXML file.
     */
    public void appointmentOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        o.openWindow(borderPaneId,"mainWindow");
    }
    /**
     * Opens the my appointments window when you press on the icon calendar
     * @throws IOException when there is a problem with loading the FXML file.
     */
    public void appointmentImageOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        o.openWindow(borderPaneId,"mainWindow");
    }
}

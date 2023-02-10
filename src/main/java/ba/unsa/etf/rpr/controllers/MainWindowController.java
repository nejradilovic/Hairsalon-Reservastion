package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
/**
 * MainWindowController class methods open a dialog window with the provided FXML file path depending on which hairsalon service you chose
 * @throws IOException when there is a problem with loading the FXML file.
 */
public class MainWindowController {
    public Button logoutId;
    public BorderPane borderPaneId;
    public ImageView logoutIcon;
    public HBox stylingHBoxId;
    public Label stylingTextId;
    public ImageView stylingImageId;
    public Button aboutTextId;
    public ImageView aboutImageId;
    OpenNewStage o=new OpenNewStage();
    /**
     * Opens the login window when you press on logout button
     * @throws IOException when there is a problem with loading the FXML file.
     */
    public void logoutOnAction(ActionEvent actionEvent) throws IOException {
        o.openWindow(borderPaneId,"login");
    }
    /**
     * Opens the login window when you press on the logout icon
     * @throws IOException when there is a problem with loading the FXML file.
     */
    public void logoutOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        o.openWindow(borderPaneId,"login");
    }
    public void stylingHBoxIdOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        o.openWindow(borderPaneId,"styling");
    }
    public void coloringHBoxIdOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        o.openWindow(borderPaneId,"coloring");
    }
    public void treatmentHBoxIdOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        o.openWindow(borderPaneId,"treatment");
    }
    public void extensionsHBoxIdOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        o.openWindow(borderPaneId,"extensions");
    }
    /**
     * Opens the about us window when you press on the text that says "About us"
     * @throws IOException when there is a problem with loading the FXML file.
     */
    public void aboutTextOnMouseClicked(MouseEvent mouseEvent) throws  IOException{
        o.openWindow(borderPaneId,"aboutUs");
    }
    /**
     * Opens the about us window when you press on the icon "About us"
     * @throws IOException when there is a problem with loading the FXML file.
     */
    public void aboutImageOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        o.openWindow(borderPaneId,"aboutUs");
    }
}

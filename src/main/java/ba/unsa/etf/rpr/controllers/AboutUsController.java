package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class AboutUsController {
    public BorderPane borderPaneId;
    public ImageView logoutIcon;
    public Button logoutId;
    public Button appointmentId;
    public ImageView appointmentImageId;
    OpenNewStage o= new OpenNewStage();

    public void logoutOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        o.openWindow(borderPaneId,"login");
    }

    public void logoutOnAction(ActionEvent actionEvent) throws IOException {
        o.openWindow(borderPaneId,"login");
    }

    public void appointmentOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        o.openWindow(borderPaneId,"mainWindow");
    }

    public void appointmentImageOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        o.openWindow(borderPaneId,"mainWindow");
    }
}

package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
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
    public void logoutOnAction(ActionEvent actionEvent) throws IOException {
        o.openWindow(borderPaneId,"login");
    }
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

    public void aboutTextOnMouseClicked(MouseEvent mouseEvent) throws  IOException{
        o.openWindow(borderPaneId,"aboutUs");
    }

    public void aboutImageOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        o.openWindow(borderPaneId,"aboutUs");
    }
}

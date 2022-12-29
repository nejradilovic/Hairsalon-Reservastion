package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;
public class MainWindowController {
    public Button logoutId;
    public BorderPane borderPaneId;
    public ImageView logoutIcon;
    public HBox stylingHBoxId;
    public Label stylingTextId;
    public ImageView stylingImageId;
    public void logoutOnAction(ActionEvent actionEvent) throws IOException {
        final Stage registrationStage=(Stage) borderPaneId.getScene().getWindow();
        Stage myStage=new Stage();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        loader.load();
        myStage.setTitle("LogIn");
        myStage.getIcons().add(new Image("/img/loginlogo.png"));
        myStage.setScene(new Scene(loader.getRoot(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.setResizable(false);
        myStage.show();
        registrationStage.hide();
    }
    public void logoutOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        final Stage registrationStage=(Stage) borderPaneId.getScene().getWindow();
        Stage myStage=new Stage();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        loader.load();
        myStage.setTitle("LogIn");
        myStage.getIcons().add(new Image("/img/loginlogo.png"));
        myStage.setScene(new Scene(loader.getRoot(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.setResizable(false);
        myStage.show();
        registrationStage.hide();
    }
    public void stylingHBoxIdOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        final Stage registrationStage=(Stage) borderPaneId.getScene().getWindow();
        Stage myStage=new Stage();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/styling.fxml"));
        loader.load();
        myStage.setTitle("LogIn");
        myStage.getIcons().add(new Image("/img/loginlogo.png"));
        myStage.setScene(new Scene(loader.getRoot(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.show();
        registrationStage.hide();
    }
}
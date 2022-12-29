package ba.unsa.etf.rpr.controllers;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class LoginController {
    public ColumnConstraints desnidio;
    public Hyperlink registration;
    public Button cancelButton;
    public  Button loginButton;
    public Text emptyInput;
    public  TextField usernameTextField;
    public  PasswordField passwordTextField;
    public  GridPane gridPane;

    public void cancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    public void registerUser(ActionEvent actionEvent) throws IOException {
        final Stage loginStage=(Stage) gridPane.getScene().getWindow();
        Stage myStage=new Stage();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/registration.fxml"));
        loader.load();
        myStage.setTitle("Registration");
        myStage.getIcons().add(new Image("/img/loginlogo.png"));
        myStage.setScene(new Scene(loader.getRoot(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.show();
        loginStage.hide();
    }
}

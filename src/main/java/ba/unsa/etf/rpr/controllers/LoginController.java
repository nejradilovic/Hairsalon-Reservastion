package ba.unsa.etf.rpr.controllers;


import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

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
}

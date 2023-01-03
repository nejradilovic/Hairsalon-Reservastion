package ba.unsa.etf.rpr.controllers;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

public class LoginController {
    public ColumnConstraints desnidio;
    public Hyperlink registration;
    public Button cancelButton;
    public  Button loginButton;
    public Text emptyInput;
    public  TextField usernameTextField;
    public  PasswordField passwordTextField;
    public  GridPane gridPane;
    OpenNewStage o=new OpenNewStage();
    public void cancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    public void registerUser(ActionEvent actionEvent) throws IOException {
        o.openWindow(gridPane,"registration");
    }
    public void loginOnAction(ActionEvent actionEvent) throws IOException{
        if(usernameTextField.getText().isBlank()==true && passwordTextField.getText().isBlank()==true){
            emptyInput.setText("Please enter your username and password.");
        }
        else if(usernameTextField.getText().isBlank()==true && passwordTextField.getText().isBlank()==false){
            emptyInput.setText("Please enter your username.");
        }
        else if(usernameTextField.getText().isBlank()==false && passwordTextField.getText().isBlank()==true){
            emptyInput.setText("Please enter your password.");
        }
        else if(usernameTextField.getText().isBlank()==false && passwordTextField.getText().isBlank()==false) {
            o.openWindow(gridPane,"welcome");
        }
    }
}

package ba.unsa.etf.rpr.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import java.io.IOException;


public class RegistrationController{
    public TextField firstnameEntry;
    public TextField lastnameEntry;
    public TextField emailEntry;
    public TextField phoneEntry;
    public TextField usernameEntry;
    public PasswordField passwordEntry;
    public Button signupButton;
    public Hyperlink loginLink;
    public Label invalidUsername;
    public GridPane gridPaneRegistration;
    OpenNewStage o=new OpenNewStage();
    public void initialize(){
        Platform.runLater(()->firstnameEntry.setFocusTraversable(false));
        String username=usernameEntry.getText();
        usernameEntry.textProperty().addListener((obs, oldValue, newValue)->{
            if(newValue.length()>=6)
                invalidUsername.setText("");
            else if(newValue.length()<6)
                invalidUsername.setText("Username must have atleast 6 characters");
        });
    }
    public void createAccount(ActionEvent actionEvent) throws IOException {
        o.openWindow(gridPaneRegistration, "login");
    }

    public void signupOnAction(ActionEvent actionEvent) throws IOException {
        if(usernameEntry.getText().length()<6) signupButton.setDisable(true);
        if(usernameEntry.getText().isBlank()==true || lastnameEntry.getText().isBlank()==true || firstnameEntry.getText().isBlank()==true || emailEntry.getText().isBlank()==true
                || phoneEntry.getText().isBlank()==true || passwordEntry.getText().isBlank()==true){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Missing fields");
            alert.setContentText("You have to fill in all fields in order to register!");
            alert.showAndWait();
        }
        else if(usernameEntry.getText().isBlank()==false && lastnameEntry.getText().isBlank()==false && firstnameEntry.getText().isBlank()==false && emailEntry.getText().isBlank()==false
                && phoneEntry.getText().isBlank()==false && passwordEntry.getText().isBlank()==false){
            o.openWindow(gridPaneRegistration, "welcome");
        }
    }
}

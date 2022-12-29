package ba.unsa.etf.rpr.controllers;

import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

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
}

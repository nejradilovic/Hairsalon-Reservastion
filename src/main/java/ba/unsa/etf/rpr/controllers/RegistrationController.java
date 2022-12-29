package ba.unsa.etf.rpr.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

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
    public void createAccount(ActionEvent actionEvent) throws IOException {
        final Stage registrationStage=(Stage) gridPaneRegistration.getScene().getWindow();
        Stage myStage=new Stage();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        loader.load();
        myStage.setTitle("LogIn");
        myStage.getIcons().add(new Image("/img/loginlogo.png"));
        myStage.setScene(new Scene(loader.getRoot(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.show();
        registrationStage.hide();
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
            final Stage mainStage = (Stage) gridPaneRegistration.getScene().getWindow();
            Stage myStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/welcome.fxml"));
            loader.load();
            myStage.setTitle("Seat&Style");
            myStage.getIcons().add(new Image("/img/loginlogo.png"));
            myStage.setScene(new Scene(loader.getRoot(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            myStage.show();
            mainStage.hide();
        }
    }
}

package ba.unsa.etf.rpr.controllers;
import ba.unsa.etf.rpr.dao.DaoFactory;
import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;
import ba.unsa.etf.rpr.domain.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;
/**
 *LoginController class is responsible for verifying and logging in users and admin.
 *It provides functionality for logging in with provided username and password.
 *@author Nejra Adilovic
 */
public class LoginController {
    public ColumnConstraints desnidio;
    public Hyperlink registration;
    public Button cancelButton;
    public  Button loginButton;
    public Text emptyInput;
    public  TextField usernameTextField;
    public  PasswordField passwordTextField;
    public  GridPane gridPane;
    @FXML
    void initialize() {
        usernameTextField.setFocusTraversable(false);
        passwordTextField.setFocusTraversable(false);
        usernameTextField.textProperty().addListener((obs, oldText, newText) -> {
            usernameTextField.setFocusTraversable(true);
            passwordTextField.setFocusTraversable(true);
        });
    }
    /**
     * Retrieves the stage of the current window and call the close() method to close it.
     * @param event actionEvent
     */
    public void cancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    public void registerUser(ActionEvent actionEvent) throws IOException {
        openDialog("Registration", "/fxml/registration.fxml", new RegistrationController());
    }
    /**
     * Defining action for login button
     * Opens two different windows depending on if you are an admin or user
     * @param actionEvent ActionEvent
     * @throws IOException
     */
    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        if(usernameTextField.getText().isBlank() && passwordTextField.getText().isBlank()){
            emptyInput.setText("Please enter your username and password.");
        }
        else if(usernameTextField.getText().isBlank() && !passwordTextField.getText().isBlank()){
            emptyInput.setText("Please enter your username.");
        }
        else if(!usernameTextField.getText().isBlank() && passwordTextField.getText().isBlank()){
            emptyInput.setText("Please enter your password.");
        }
        else if(usernameTextField.getText().isBlank()==false && passwordTextField.getText().isBlank()==false) {
            String username = usernameTextField.getText();
            String password = passwordTextField.getText();
            User user = DaoFactory.userDao().checkUser(username,password);
            if (user == null) {
                emptyInput.setText("Please, enter correct username and password!");
                usernameTextField.clear();
                passwordTextField.clear();
            }
            else if (user != null && !username.equals("nadilovic2")){
                openDialog("Welcome", "/fxml/welcome.fxml", new WelcomeController());
            }
            else {
                openDialog("Admin panel", "/fxml/admin.fxml", new AdminController());
            }
        }
    }
    /**
     * Opens a dialog window with the provided FXML file path
     * @param title String for window Title
     * @param file path of the FXML file
     * @param controller Object
     * @throws IOException in case of an error
     */
    private void openDialog(String title, String file, Object controller) throws IOException {
        final Stage homeStage = (Stage) gridPane.getScene().getWindow();
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(file));
        loader.setController(controller);
        stage.setTitle(title);
        stage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        homeStage.hide();
        stage.show();
    }
}

package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.dao.UserDaoSQLImpl;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HairsalonException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

/**
 *RegistrationController class is responsible for signing up new users.
 *@author Nejra Adilovic
 */
public class RegistrationController{
    public TextField firstnameEntry;
    public TextField lastnameEntry;
    public TextField emailEntry;
    public TextField phoneEntry;
    public TextField usernameEntry;
    public Label emailMessage;
    public PasswordField passwordEntry;
    public Button signupButton;
    public Hyperlink loginLink;
    public Label invalidUsername;
    public GridPane gridPaneRegistration;
    /**
     * Listener that makes sure that the username is over 6 characters
     * Removes focus from fields
     */
    public void initialize(){
        usernameEntry.setFocusTraversable(false);
        passwordEntry.setFocusTraversable(false);
        firstnameEntry.setFocusTraversable(false);
        lastnameEntry.setFocusTraversable(false);
        emailEntry.setFocusTraversable(false);
        phoneEntry.setFocusTraversable(false);
        firstnameEntry.textProperty().addListener((obs, oldText, newText) -> {
            lastnameEntry.setFocusTraversable(true);
            emailEntry.setFocusTraversable(true);
            phoneEntry.setFocusTraversable(true);
            usernameEntry.setFocusTraversable(true);
            passwordEntry.setFocusTraversable(true);
        });
        usernameEntry.textProperty().addListener((obs, oldValue, newValue)->{
            if(newValue.length()>=6)
                invalidUsername.setText("");
            else if(newValue.length()<6)
                invalidUsername.setText("Username must have atleast 6 characters");
        });
    }
    /**
     * checkEmail method checks if a given string is a valid email address
     * The method uses a regular expression to validate the email address.
     * @param emailField The string to be checked if it is a valid email address.
     * @return returns true if the given string is a valid email address, false otherwise
     */
    public boolean checkEmail(String emailField){
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(emailField);
        return matcher.matches();
    }
    /**
     * Opens the login window when you press on the login link
     * @throws IOException when there is a problem with loading the FXML file.
     */
    public void createAccount(ActionEvent actionEvent) throws IOException {
        final Stage mainStage = (Stage) gridPaneRegistration.getScene().getWindow();
        Stage myStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        loader.load();
        myStage.setTitle("Seat&Style");
        myStage.getIcons().add(new Image("/img/loginlogo.png"));
        myStage.setScene(new Scene(loader.getRoot(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.show();
        mainStage.hide();
    }
    /**
     * Defining action for sign up button
     * Opens the welcome page and enters you in the database if all the fields are correct
     * @param actionEvent ActionEvent
     * @throws IOException
     */
    public void signupOnAction(ActionEvent actionEvent) throws IOException, HairsalonException {
        if(usernameEntry.getText().isBlank() || lastnameEntry.getText().isBlank() || firstnameEntry.getText().isBlank() || emailEntry.getText().isBlank() || phoneEntry.getText().isBlank() || passwordEntry.getText().isBlank()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Missing fields");
            alert.setContentText("You have to fill in all fields in order to sign up!");
            alert.showAndWait();
        }
        else if(!usernameEntry.getText().isBlank() || !lastnameEntry.getText().isBlank() || !firstnameEntry.getText().isBlank() || !emailEntry.getText().isBlank() || !phoneEntry.getText().isBlank() || !passwordEntry.getText().isBlank()){
            String username = usernameEntry.getText();
            UserDaoSQLImpl u = new UserDaoSQLImpl();
            User user = new User();
            boolean flag = DaoFactory.userDao().checkUsername(username);
            if (flag) {
                invalidUsername.setText("Username already exists!");
            }
            else {
                boolean emailFlag=checkEmail(emailEntry.getText());
                if(!emailFlag) {
                    emailMessage.setText("Invalid e-mail format.");
                    emailEntry.clear();
                }
                else {
                    user.setPassword(passwordEntry.getText());
                    user.setUsername(usernameEntry.getText());
                    user.setLast_name(lastnameEntry.getText());
                    user.setFirst_name(firstnameEntry.getText());
                    user.setPhone(phoneEntry.getText());
                    user.setEmail(emailEntry.getText());
                    u.add(user);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Successful registration");
                    alert.setHeaderText(user.getUsername() + " you have successfully signed up!");
                    alert.showAndWait();
                    final Stage mainStage = (Stage) gridPaneRegistration.getScene().getWindow();
                    Stage myStage = new Stage();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
                    loader.load();
                    myStage.setTitle("Seat&Style");
                    myStage.getIcons().add(new Image("/img/loginlogo.png"));
                    myStage.setScene(new Scene(loader.getRoot(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
                    myStage.show();
                    mainStage.hide();
                }
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
        final Stage homeStage = (Stage) gridPaneRegistration.getScene().getWindow();
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(file));
        loader.setController(controller);
        stage.getIcons().add(new Image("/img/loginlogo.png"));
        stage.setTitle(title);
        stage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        homeStage.hide();
        stage.show();
    }
}

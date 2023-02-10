package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.UserDaoSQLImpl;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HairsalonException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static ba.unsa.etf.rpr.dao.AbstractDao.getConnection;

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
    public PasswordField passwordEntry;
    public Button signupButton;
    public Hyperlink loginLink;
    public Label invalidUsername;
    public GridPane gridPaneRegistration;
    OpenNewStage o=new OpenNewStage();
    /**
     * Listener that makes sure that the username is over 6 characters
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
        String username=usernameEntry.getText();
        usernameEntry.textProperty().addListener((obs, oldValue, newValue)->{
            if(newValue.length()>=6)
                invalidUsername.setText("");
            else if(newValue.length()<6)
                invalidUsername.setText("Username must have atleast 6 characters");
        });
    }
    /**
     * Opens the login window when you press on the login link
     * @throws IOException when there is a problem with loading the FXML file.
     */
    public void createAccount(ActionEvent actionEvent) throws IOException {
        o.openWindow(gridPaneRegistration, "login");
    }
    /**
     * Defining action for sign up button
     * Opens the welcome page and enters you in the database if all the fields are correct
     * @param actionEvent ActionEvent
     * @throws IOException
     */
    public void signupOnAction(ActionEvent actionEvent) throws IOException, HairsalonException {
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
            String username = usernameEntry.getText();
            UserDaoSQLImpl u=new UserDaoSQLImpl();
            User user=new User();
            boolean flag=checkUsername(username);
            if (flag) {
                invalidUsername.setText("The username you entered is already taken.");
            }
            else {
                user.setPassword(passwordEntry.getText());
                user.setUsername(usernameEntry.getText());
                user.setLast_name(lastnameEntry.getText());
                user.setFirst_name(firstnameEntry.getText());
                user.setPhone(phoneEntry.getText());
                user.setEmail(emailEntry.getText());
                u.add(user);
                o.openWindow(gridPaneRegistration, "welcome");
            }
        }
    }
    /**
     * Method that checks if the user with that username is already in the database
     */
    public boolean checkUsername(String username) {
        String sql = "SELECT * FROM USER WHERE username = ?";
        try {
            PreparedStatement s=getConnection().prepareStatement(sql);
            s.setString(1, username);
            ResultSet r = s.executeQuery();
            while(r.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

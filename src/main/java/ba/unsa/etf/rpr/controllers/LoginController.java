package ba.unsa.etf.rpr.controllers;
import ba.unsa.etf.rpr.dao.UserDaoSQLImpl;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static ba.unsa.etf.rpr.dao.AbstractDao.getConnection;
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
    OpenNewStage o=new OpenNewStage();
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
        o.openWindow(gridPane,"registration");
    }
    /**
     * Defining action for login button
     * Opens two different windows depending on if you are an admin or user
     * @param actionEvent ActionEvent
     * @throws IOException
     */
    public void loginOnAction(ActionEvent actionEvent) throws IOException {
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
            String username = usernameTextField.getText();
            String password = passwordTextField.getText();
            UserDaoSQLImpl u=new UserDaoSQLImpl();
            boolean flag=checkUser(username, password);
            if (!flag) {
                emptyInput.setText("Please, enter correct username and password!");
                usernameTextField.clear();
                passwordTextField.clear();
            }
            else {
                if(username.equals("nadilovic2")){
                    o.openWindow(gridPane,"admin");
                }
                else{
                    o.openWindow(gridPane, "welcome");
                }
            }
        }
    }
    /**
     * Method that checks if the user is in the database
     */
    public boolean checkUser(String username, String password) {
        String sql = "SELECT * FROM USER WHERE username = ? AND password = ?";
        try {
            PreparedStatement s=getConnection().prepareStatement(sql);
            s.setString(1, username);
            s.setString(2, password);
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

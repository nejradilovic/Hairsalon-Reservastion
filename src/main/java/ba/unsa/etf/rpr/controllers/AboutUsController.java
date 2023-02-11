package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

/**
 * AboutUsController gives you information about the app
 * @author Nejra Adilovic
 */
public class AboutUsController {
    public BorderPane borderPaneId;
    public ImageView logoutIcon;
    public Button logoutId;
    public Button appointmentId;
    public ImageView appointmentImageId;
    /**
     * Opens the login window when you press on the logout icon
     * @throws IOException when there is a problem with loading the FXML file.
     */
    public void logoutOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        final Stage mainStage = (Stage) borderPaneId.getScene().getWindow();
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
     * Opens the login window when you press on logout button
     * @throws IOException when there is a problem with loading the FXML file.
     */
    public void logoutOnAction(ActionEvent actionEvent) throws IOException {
        final Stage mainStage = (Stage) borderPaneId.getScene().getWindow();
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
     * Opens the my appointments window when you press on the text that says "My appointments"
     * @throws IOException when there is a problem with loading the FXML file.
     */
    public void appointmentOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        openDialog("Home page", "/fxml/mainWindow.fxml", new MainWindowController());
    }
    /**
     * Opens the my appointments window when you press on the icon calendar
     * @throws IOException when there is a problem with loading the FXML file.
     */
    public void appointmentImageOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        openDialog("Home page", "/fxml/mainWindow.fxml", new MainWindowController());
    }
    /**
     * Opens a dialog window with the provided FXML file path
     * @param title String for window Title
     * @param file path of the FXML file
     * @param controller Object
     * @throws IOException in case of an error
     */
    private void openDialog(String title, String file, Object controller) throws IOException {
        final Stage homeStage = (Stage) borderPaneId.getScene().getWindow();
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

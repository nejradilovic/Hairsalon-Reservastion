package ba.unsa.etf.rpr.controllers;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class WelcomeController {
    public ImageView appointmentId;
    public AnchorPane anchorPaneId;
    public ImageView aboutId;
    /**
     * Opens a dialog window with the provided FXML file path when you press on a certain part of the screen
     * @throws IOException when there is a problem with loading the FXML file.
     */
    public void mainWindowOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        openDialog("Home page", "/fxml/mainWindow.fxml", new MainWindowController());
    }
    /**
     * Opens a dialog window with the provided FXML file path when you press on a certain part of the screen
     * @throws IOException when there is a problem with loading the FXML file.
     */
    public void aboutOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        openDialog("About Seat&Style", "/fxml/aboutUs.fxml", new AboutUsController());
    }
    /**
     * Opens a dialog window with the provided FXML file path
     * @param title String for window Title
     * @param file path of the FXML file
     * @param controller Object
     * @throws IOException in case of an error
     */
    private void openDialog(String title, String file, Object controller) throws IOException {
        final Stage homeStage = (Stage) anchorPaneId.getScene().getWindow();
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(file));
        loader.setController(controller);
        stage.setTitle(title);
        stage.getIcons().add(new Image("/img/loginlogo.png"));
        stage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        homeStage.hide();
        stage.show();
    }
}

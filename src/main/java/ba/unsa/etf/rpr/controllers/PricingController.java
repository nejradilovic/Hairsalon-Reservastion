package ba.unsa.etf.rpr.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;
/**
 * PricingController class is responsible for giving you the pricing list
 * @author Nejra Adilovic
 */

public class PricingController {
    public BorderPane borderPaneId;
    /**
     * Opens the pricing list window when you press on the icon next to "Pricing list"
     * @throws IOException when there is a problem with loading the FXML file.
     */
    public void backOnMouseClicked(MouseEvent mouseEvent) throws IOException {
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
        stage.getIcons().add(new Image("/img/loginlogo.png"));
        stage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        homeStage.hide();
        stage.show();
    }
}

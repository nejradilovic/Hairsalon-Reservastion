package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.exceptions.HairsalonException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

/**
 * MainWindowController class methods open a dialog window with the provided FXML file path depending on which hairsalon service you chose
 * @throws IOException when there is a problem with loading the FXML file.
 */
public class MainWindowController {
    public Button logoutId;
    public BorderPane borderPaneId;
    public ImageView logoutIcon;
    public HBox stylingHBoxId;
    public Label stylingTextId;
    public ImageView stylingImageId;
    public Button aboutTextId;
    public ImageView aboutImageId;
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
     * Opens the styling booking window
     * @throws IOException when there is a problem with loading the FXML file.
     */
    public void stylingHBoxIdOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        openDialog("Styling", "/fxml/styling.fxml", new StylingController());
    }
    /**
     * Opens the coloring booking window
     * @throws IOException when there is a problem with loading the FXML file.
     */
    public void coloringHBoxIdOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        openDialog("Coloring", "/fxml/coloring.fxml", new ColoringController());
    }
    /**
     * Opens the treatment booking window
     * @throws IOException when there is a problem with loading the FXML file.
     */
    public void treatmentHBoxIdOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        openDialog("Treatment", "/fxml/treatment.fxml", new TreatmentController());
    }
    /**
     * Opens the extensions booking window
     * @throws IOException when there is a problem with loading the FXML file.
     */
    public void extensionsHBoxIdOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        openDialog("Extensions", "/fxml/extensions.fxml", new ExtensionsController());
    }
    /**
     * Opens the about us window when you press on the text that says "About Seat&Style"
     * @throws IOException when there is a problem with loading the FXML file.
     */
    public void aboutTextOnMouseClicked(MouseEvent mouseEvent) throws  IOException{
        openDialog("About Seat&Style", "/fxml/aboutUs.fxml", new AboutUsController());
    }
    /**
     * Opens the about us window when you press on the icon next to "About Seat&Style"
     * @throws IOException when there is a problem with loading the FXML file.
     */
    public void aboutImageOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        openDialog("About Seat&Style", "/fxml/aboutUs.fxml", new AboutUsController());
    }
    /** Opens the pricing list window when you press on the text that says "Pricing list"
     *  @throws IOException when there is a problem with loading the FXML file.
     */
    public void pricingListTextOnMouseClicked(MouseEvent mouseEvent) throws  IOException{
        openDialog("Pricing list", "/fxml/pricing.fxml", new PricingController());
    }
    /**
     * Opens the pricing list window when you press on the icon next to "Pricing list"
     * @throws IOException when there is a problem with loading the FXML file.
     */
    public void pricingListImageOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        openDialog("Pricing list", "/fxml/pricing.fxml", new PricingController());
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

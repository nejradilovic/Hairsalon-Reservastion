package ba.unsa.etf.rpr.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class OpenNewStage {
    public<Tip extends Pane> void openWindow(Tip pane, String name) throws IOException {
        final Stage mainStage = (Stage) pane.getScene().getWindow();
        Stage myStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/"+name+".fxml"));
        loader.load();
        myStage.setTitle("Seat&Style");
        myStage.getIcons().add(new Image("/img/loginlogo.png"));
        myStage.setScene(new Scene(loader.getRoot(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        myStage.show();
        mainStage.hide();
    }
}

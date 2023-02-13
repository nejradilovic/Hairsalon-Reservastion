package ba.unsa.etf.rpr.controllers;

import static java.lang.String.valueOf;
import ba.unsa.etf.rpr.business.AppointmentsManager;
import ba.unsa.etf.rpr.business.StylistManager;
import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.Appointments;
import ba.unsa.etf.rpr.domain.Stylist;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HairsalonException;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;
/**
 * AdminController class is responsible for giving you insight into users, stylists and appointments
 * @author Nejra Adilovic
 */
public class AdminController {
    public TableColumn<User, Integer> userIdColumn;
    public TableColumn<User, String> firstNameColumn;
    public TableColumn<User, String> lastNameColumn;
    public TableColumn<User, String> emailColumn;
    public TableColumn<User, String> phoneNumColumn;
    public TableColumn<User, String> passwordColumn;
    public TableColumn<User, String> usernameColumn;
    public TableColumn<User, Boolean> adminColumn;
    public TableColumn<Stylist, Integer> stylistIdColumn;
    public TableColumn<Stylist, String> first_nameColumn;
    public TableColumn<Stylist, String> last_nameColumn;
    public TableColumn<Stylist, String> phoneColumn;
    public TableColumn<Appointments, Integer> appointmentsIdColumn;
    public TableColumn<Appointments, String> serviceColumn;
    public TableColumn<Appointments, Date> timeColumn;
    public TableColumn<Appointments, Integer> durationColumn;
    public TableColumn<Appointments, String> priceColumn;

    public TableColumn<Appointments, String> userIdfkColumn;
    public TableColumn<Appointments, String> stylistIdfkColumn;

    public BorderPane borderPaneId;
    public Button deleteId;
    public Button editButton;
    public Button addStylistId;

    public TableView<Stylist> stylistTable;
    public TableView<User> userTable;
    public TableView<Appointments> appointmentsTable;

    UserManager userManager=new UserManager();
    StylistManager stylistManager=new StylistManager();
    AppointmentsManager appointmentsManager=new AppointmentsManager();

    /**
     * Opens the login window when you press on the icon
     * @throws IOException when there is a problem with loading the FXML file.
     */
    public void logoutImageOnMouseClicked(MouseEvent mouseEvent) throws IOException {
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
     * Opens the login window when you press on the login text
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
     * Refreshes stylist table with current data
     */
    void refreshStylist(){
        try{
            stylistTable.setItems(FXCollections.observableList(stylistManager.getAll()));
            stylistTable.refresh();
        } catch (HairsalonException e){
            e.printStackTrace();
        }
    }
    /**
     * Refreshes user table with current data
     */
    void refreshUser(){
        try{
            userTable.setItems(FXCollections.observableList(userManager.getAll()));
            userTable.refresh();
        } catch (HairsalonException e){
            e.printStackTrace();
        }
    }
    /**
     * Refreshes appointments table with current data
     */
    void refreshAppointments(){
        try{
            appointmentsTable.setItems(FXCollections.observableList(appointmentsManager.getAll()));
            appointmentsTable.refresh();
        } catch (HairsalonException e){
            e.printStackTrace();
        }
    }
    /**
     *Initializes the userTable, stylistTable and appointmentsTable with values from database for users, rooms and reservations.
     */
    public void initialize(){
        userIdColumn.setCellValueFactory(cellData -> {
            User user = cellData.getValue();
            return new SimpleIntegerProperty(user.getId()).asObject();
        });
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<User,String>("first_name"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<User,String>("last_name"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<User,String>("email"));
        phoneNumColumn.setCellValueFactory(new PropertyValueFactory<User,String>("phone"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<User,String>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<User,String>("password"));
        adminColumn.setCellValueFactory(new PropertyValueFactory<User, Boolean>("admin"));
        refreshUser();

        stylistIdColumn.setCellValueFactory(cellData -> {
            Stylist stylist = cellData.getValue();
            return new SimpleIntegerProperty(stylist.getId()).asObject();
        });
        first_nameColumn.setCellValueFactory(new PropertyValueFactory<Stylist,String>("first_name"));
        last_nameColumn.setCellValueFactory(new PropertyValueFactory<Stylist,String>("last_name"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<Stylist,String>("phone"));
        refreshStylist();

        appointmentsIdColumn.setCellValueFactory(cellData -> {
            Appointments appointments = cellData.getValue();
            return new SimpleIntegerProperty(appointments.getId()).asObject();
        });
        serviceColumn.setCellValueFactory(new PropertyValueFactory<Appointments,String>("service"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<Appointments,Date>("time"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<Appointments,Integer>("duration"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Appointments,String>("price"));
        userIdfkColumn.setCellValueFactory(param -> new SimpleStringProperty((valueOf(param.getValue().getUser().getId()))));
        stylistIdfkColumn.setCellValueFactory(param -> new SimpleStringProperty((valueOf(param.getValue().getStylist().getId()))));
        refreshAppointments();
    }
}

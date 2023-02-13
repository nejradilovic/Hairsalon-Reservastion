package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.AppointmentsManager;
import ba.unsa.etf.rpr.business.StylistManager;
import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.dao.AppointmentsDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Appointments;
import ba.unsa.etf.rpr.domain.Stylist;
import ba.unsa.etf.rpr.exceptions.HairsalonException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import static ba.unsa.etf.rpr.controllers.LoginController.user;

import java.io.IOException;
import java.sql.Array;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;
/**
 *StylingController class is responsible for scheduling an appointment for hair styling.
 *@author Nejra Adilovic
 */
public class StylingController{
    public BorderPane borderPaneId;
    private ArrayList<String> services = new ArrayList<>();
    public DatePicker datePickerId;
    public Button cancelId;
    public Label priceLabel;
    public Label priceLabelFixed;
    public Label durationLabel;
    public Button confirmId;
    public Label durationLabelFixed;
    public ComboBox<String> serviceId;
    public ComboBox<String> stylistPickId;
    private final StylistManager stylistManager = new StylistManager();
    private final List<String> listaStylista;
    {
        try {
            listaStylista = stylistManager.getAllNames();
        } catch (HairsalonException e) {
            throw new RuntimeException(e);
        }
    }
    private final ObservableList<String> stylists = FXCollections.observableArrayList(listaStylista);
    /**
     * Constructor to add services in ComboBox
     */
    public StylingController(){
        services.add("Haircut + Blowout (short hair S)");
        services.add("Haircut + Blowout (medium hair M)");
        services.add("Haircut + Blowout (long hair L)");
        services.add("Haircut + Blowout (extra long hair XL)");
    }
    /**
     * Initializes ComboBox for choosing the desired service
     * Initializes ComboBox for choosing the desired stylist
     * Initializes DatePicker for choosing the desired date
     */
    @FXML
    public void initialize(){
        serviceId.setItems(FXCollections.observableList(services));
        stylistPickId.setItems(stylists);
        initializeDatePicker();
        initializeServicePick();
    }
    /**
     * Initializing the date picker.
     */
    private void initializeDatePicker() {
        final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(final DatePicker datePicker) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item.isBefore(LocalDate.now())) {
                            setDisable(true);
                            setStyle("-fx-background-color: #B6B6B4;");
                        }
                    }
                };
            }
        };
        datePickerId.setDayCellFactory(dayCellFactory);
    }
    /**
     * cancelButtonOnAction goes back to the main screen.
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    public void cancelButtonOnAction(ActionEvent actionEvent) throws IOException {
        openDialog("Home page", "/fxml/mainWindow.fxml", new MainWindowController());
    }
    /**
     * initializeServicePick gives you the price and duration of the selected service
     */
    public void initializeServicePick(){
        serviceId.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue)->{
                String s=services.get(Integer.parseInt(newValue.toString()));
                if (s.contains("S")) {
                    priceLabel.setText("20$");
                    durationLabel.setText("30 min");
                } else if (s.contains("M")) {
                    priceLabel.setText("30$");
                    durationLabel.setText("45 min");
                } else if (s.contains("L") && !s.contains("extra")) {
                    priceLabel.setText("45$");
                    durationLabel.setText("60 min");
                } else if (s.contains("XL")) {
                    priceLabel.setText("55$");
                    durationLabel.setText("90 min");
                }

        });
    }
    /**
     * confirmButtonOnAction adds your appointment to the db and makes sure that the reservation is valid
     * @param actionEvent the action event
     * @throws HairsalonException in case of problems with db
     */
    public void confirmButtonOnAction(ActionEvent actionEvent) throws HairsalonException {
        if(serviceId.getValue().isEmpty() || stylistPickId.getValue()==null  || datePickerId.getValue()==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Missing fields");
            alert.setContentText("You have to fill in all fields in order to book an appointment!");
            alert.showAndWait();
        }
        else {
            java.sql.Date time = Date.valueOf(datePickerId.getValue());
            String service = serviceId.getValue();
            String s = stylistPickId.getValue();
            StylistManager stylistManager = new StylistManager();
            String[] arrOfStr = s.split(" ", 2);
            Stylist stylist = stylistManager.getByName(arrOfStr[0], arrOfStr[1]);
            AppointmentsDaoSQLImpl a = new AppointmentsDaoSQLImpl();
            Appointments appointments = new Appointments();
            appointments.setTime(time);
            appointments.setService(service);
            appointments.setUser(user);
            appointments.setStylist(stylist);
            if (service.contains("S")) {
                appointments.setPrice("20$");
                appointments.setDuration(30);
            } else if (service.contains("M")) {
               appointments.setPrice("30$");
               appointments.setDuration(45);
            } else if (service.contains("L") && !service.contains("extra")) {
               appointments.setPrice("45$");
               appointments.setDuration(60);
            } else if (service.contains("XL")) {
               appointments.setPrice("55$");
               appointments.setDuration(90);
            }
            a.add(appointments);
            String formattedDate = new SimpleDateFormat("dd-MM-yyyy").format(time);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Appointment information");
            alert.setHeaderText(appointments.getUser().getUsername() + " you have successfully booked an appointment!");
            alert.setContentText(" Service : " + appointments.getService() + "\n Price : " + appointments.getPrice() + "\n Date : " + formattedDate
                    + "\n Duration : " + appointments.getDuration() + " minutes \n Stylist : " + appointments.getStylist().getFirst_name() + " " + appointments.getStylist().getLast_name() + "\n Stylist contact : " + appointments.getStylist().getPhone());
            alert.showAndWait();
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
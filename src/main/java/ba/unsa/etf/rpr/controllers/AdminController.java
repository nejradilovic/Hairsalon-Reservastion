package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.AppointmentsManager;
import ba.unsa.etf.rpr.business.StylistManager;
import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.dao.Dao;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Appointments;
import ba.unsa.etf.rpr.domain.Stylist;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HairsalonException;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Date;
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
    public BorderPane borderPaneId;
    OpenNewStage o=new OpenNewStage();

    public TableView<Stylist> stylistTable;
    public TableView<User> userTable;
    public TableView<Appointments> appointmentsTable;

    UserManager userManager=new UserManager();
    StylistManager stylistManager=new StylistManager();
    AppointmentsManager appointmentsManager=new AppointmentsManager();
    void refreshStylist(){
        try{
            stylistTable.setItems(FXCollections.observableList(stylistManager.getAll()));
            stylistTable.refresh();
        } catch (HairsalonException e){
            e.printStackTrace();
        }
    }
}

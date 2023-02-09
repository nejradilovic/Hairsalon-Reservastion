package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.business.StylistManager;
import ba.unsa.etf.rpr.business.AppointmentsManager;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.domain.Stylist;
import ba.unsa.etf.rpr.domain.Appointments;
import ba.unsa.etf.rpr.exceptions.HairsalonException;
import org.apache.commons.cli.*;
import java.io.PrintWriter;
import java.util.*;


public class App {
    private static final Option getUsers = new Option("getU", "get-users", false, "Printing all users from database");

    private static final Option getAppointments = new Option("getA", "get-appointments", false, "Printing all appointments from database");
    private static final Option getStylists = new Option("getS", "get-stylists", false, "Printing all stylists from database");
    private static final Option addStylist = new Option("s", "add-stylist", false, "Adding a new stylist to database");
    private static final Option deleteStylist = new Option("delS", "delete-stylist", false, "Deleting a stylist from database");
    private static final Option updateStylist = new Option("update", "update-stylist",false, "Updating stylist from database");

}
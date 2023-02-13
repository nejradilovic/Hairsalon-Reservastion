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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * CLI (Command Line Interface) implementation in following class
 * Manipulate data through command line and database
 * @author Nejra Adilovic
 */
public class App {
    /**
     * Defining final variables to describe all code having options
     */
    private static final Option getUsers = new Option("getU", "get-users", false, "Printing all users from database");
    private static final Option getAppointments = new Option("getA", "get-appointments", false, "Printing all appointments from database");
    private static final Option getStylists = new Option("getS", "get-stylists", false, "Printing all stylists from database");
    private static final Option addStylist = new Option("add", "add-stylist", false, "Adding new stylist to database");
    private static final Option deleteStylist = new Option("delete", "delete-stylist", false, "Deleting stylist from database");
    private static final Option updateStylist = new Option("update", "update-stylist",false, "Updating stylist from database");
    /**
     * Printing on console screen how to properly use commands.
     * @param options available options
     */
    public static void printFormattedOptions(Options options) {
        HelpFormatter helpFormatter = new HelpFormatter();
        PrintWriter printWriter = new PrintWriter(System.out);
        helpFormatter.printUsage(printWriter, 150, "java -jar projekatRPR-cli-jar-with-dependencies.jar [option] (parameters)");
        helpFormatter.printOptions(printWriter, 150, options, 2, 7);
        printWriter.close();
    }
    /**
     * Adding options that can be used on console screen.
     * @return all options
     */
    public static Options addOptions() {
        Options options = new Options();
        options.addOption(addStylist);
        options.addOption(deleteStylist);
        options.addOption(getStylists);
        options.addOption(getUsers);
        options.addOption(getAppointments);
        options.addOption(updateStylist);
        return options;
    }
    /**
     * Manipulates with console screen commands
     * @param args String[]
     * @throws Exception in case of an error
     */
    public static void main(String[] args) throws Exception {
        Options options = addOptions();

        CommandLineParser commandLineParser = new DefaultParser();

        CommandLine cl = commandLineParser.parse(options, args);

        if((cl.hasOption(addStylist.getOpt()))) {
            try {
                StylistManager stylistManager = new StylistManager();
                System.out.println("Input in");
                Stylist stylist = new Stylist();
                stylist.setFirst_name(cl.getArgList().get(0));
                stylist.setLast_name(cl.getArgList().get(1));
                stylist.setPhone(cl.getArgList().get(2));
                stylistManager.add(stylist);
                System.out.println("New stylist successfully added to database!");
            }
            catch(Exception e){
                System.out.println("Error. Invalid parameters, please follow these guidelines when adding a stylist:\n" +
                        "Format: \"First_name\" \"Last_name\" \"Phone\"");
            }
        }
        else if(cl.hasOption(updateStylist.getOpt())){
            try {
                StylistManager stylistManager = new StylistManager();
                System.out.println("Input in");
                List<Stylist> list=stylistManager.getAll();
                List<Integer> ids= new ArrayList<>();
                for(int i=0; i<list.size(); i++){
                    Stylist stylist=list.get(i);
                    ids.add(stylist.getId());
                }
                if(ids.contains(Integer.valueOf(cl.getArgList().get(0)))) {
                    Stylist stylist = new Stylist();
                    stylist.setId(Integer.parseInt(cl.getArgList().get(0)));
                    stylist.setFirst_name(cl.getArgList().get(1));
                    stylist.setLast_name(cl.getArgList().get(2));
                    stylist.setPhone(cl.getArgList().get(3));
                    stylistManager.update(stylist);
                    System.out.println("Stylist successfully updated!");
                }
                else{
                    System.out.println("The given id doesn't exist in the database!");
                }
            }
            catch(Exception e){
                System.out.println("Error. Invalid parameters, please follow these guidelines when updating a stylist:\n" +
                        "Format: \"Stylist_id\" \"First_name\" \"Last_name\" \"Phone\"");
            }
        }
        else if(cl.hasOption(deleteStylist.getOpt())) {
            try {
                StylistManager stylistManager = new StylistManager();
                System.out.println("Input in");
                List<Stylist> list = stylistManager.getAll();
                List<Integer> ids = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    Stylist stylist = list.get(i);
                    ids.add(stylist.getId());
                }
                if(ids.contains(Integer.valueOf(cl.getArgList().get(0)))) {
                    stylistManager.delete(Integer.parseInt(cl.getArgList().get(0)));
                    System.out.println("Stylist successfully deleted from database!");
                } else {
                    System.out.println("The given id doesn't exist in the database!");
                }
            } catch (Exception e) {
                System.out.println("Error. Invalid parameters, please follow these guidelines when deleting a stylist:\n" +
                        "Format: \"Stylist_id\"");
            }
        }
        else if(cl.hasOption(getStylists.getOpt())){
            StylistManager stylistManager = new StylistManager();
            stylistManager.getAll().forEach(c -> System.out.println(c.getFirst_name() + " ; " + c.getLast_name() + " ; " +c.getPhone()));
        }
        else if(cl.hasOption(getUsers.getLongOpt())){
            UserManager userManager = new UserManager();
            userManager.getAll().forEach(c -> System.out.println(c.getId()
                    + " ; " + c.getFirst_name() + " ; " + c.getLast_name() + " ; " + c.getEmail() + " ; " + c.getPhone()
                    + " ; " + c.getUsername() + " ; " + c.getPassword() + " ; " + c.isAdmin()));

        }
        else if(cl.hasOption(getAppointments.getOpt())){
            AppointmentsManager appointmentsManager = new AppointmentsManager();
            appointmentsManager.getAll().forEach(c -> System.out.println(c.getId()+ " ; " + " ; " + c.getService() + " ; " + c.getPrice() + " ; " + c.getTime() + " ; " + c.getDuration()
                    + " ; " + c.getUser().getUsername() + c.getStylist().getFirst_name()));
        }
        else {
            printFormattedOptions(options);
            System.exit(-1);
        }
    }
}
package ba.unsa.etf.rpr.dao;

import java.sql.Connection;
/**
 * Factory method for singleton implementation of DAOs
 *
 * @author Nejra Adilovic
 */

public class DaoFactory {
    private static final UserDao userDao = new UserDaoSQLImpl();
    private static final StylistDao stylistDao = new StylistDaoSQLImpl();
    private static final AppointmentsDao appointmentsDao = new AppointmentsDaoSQLImpl();

    /**
     * Private constructor to prevent instantiation of this class
     */
    private DaoFactory(){
    }
    /**
     * A singleton instance of the UserDao class, which is used to access and manipulate user data in a database.
     * @return userDao UserDao
     */
    public static UserDao userDao(){
        return userDao;
    }
    /**
     * A singleton instance of the StylistDao class, which is used to access and manipulate stylist data in a database.
     * @return stylistDao StylistDao
     */
    public static StylistDao stylistDao(){
        return stylistDao;
    }
    /**
     * A singleton instance of the AppointmentsDao class, which is used to access and manipulate appointments data in a database.
     * @return appointmentsDao AppointmentsDao
     */
    public static AppointmentsDao appointmentsDao(){
        return appointmentsDao;
    }
}

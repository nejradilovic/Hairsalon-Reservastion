package ba.unsa.etf.rpr.dao;

/**
 * Factory method for singleton implementation of DAOs
 *
 * @author Nejra Adilovic
 */

public class DaoFactory {
    private static final UserDao userDao = new UserDaoSQLImpl();
    private static final StylistDao stylistDao = new StylistDaoSQLImpl();
    private static final AppointmentsDao appointmentsDao = new AppointmentsDaoSQLImpl();

    private DaoFactory(){
    }

    public static UserDao userDao(){
        return userDao;
    }

    public static StylistDao stylistDao(){
        return stylistDao;
    }

    public static AppointmentsDao appointmentsDao(){
        return appointmentsDao;
    }
}

package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HairsalonException;

import java.util.List;

/**
 * Dao interface for User domain bean
 *
 * @author Nejra Adilović
 */
public interface UserDao extends Dao<User> {
    User getByFirstName(String first_name) throws HairsalonException;
    User getByLastName(String last_name) throws HairsalonException;
    User getByUsername(String username) throws HairsalonException;
    User getByAdmin(boolean admin) throws HairsalonException;
    /**
     * Returns user whose username and password are given as parameters.
     * @param username search String for username of user
     * @param password search String for password of user
     * @return User instance
     */
    public User checkUser(String username, String password);

    /**
     * Returns true if username, given as parameter, exists in database.
     * @param username search String for username
     * @return boolean
     */
    public boolean checkUsername(String username);
}

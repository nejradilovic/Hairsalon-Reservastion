package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HairsalonException;


/**
 * Dao interface for User domain bean
 *
 * @author Nejra Adilovic
 */
public interface UserDao extends Dao<User> {
    /**
     * Fetches User object from table USER defined by given first name.
     * @param first_name String
     * @return User
     * @throws HairsalonException thrown in case of problem with db
     */
    User getByFirstName(String first_name) throws HairsalonException;
    /**
     * Fetches User object from table USER defined by given last name.
     * @param last_name String
     * @return User
     * @throws HairsalonException thrown in case of problem with db
     */
    User getByLastName(String last_name) throws HairsalonException;
    /**
     * Fetches User object from table USER defined by given username.
     * @param username String
     * @return User
     * @throws HairsalonException thrown in case of problem with db
     */
    User getByUsername(String username) throws HairsalonException;
    /**
     * Fetches User object from table USER defined by given boolean depending on if the user is an admin.
     * @param admin boolean
     * @return User
     * @throws HairsalonException thrown in case of problem with db
     */
    User getByAdmin(boolean admin) throws HairsalonException;
    /**
     * Returns user whose username and password are given as parameters.
     * @param username search String for username of user
     * @param password search String for password of user
     * @return User instance
     */
    User checkUser(String username, String password);

    /**
     * Returns true if username, given as parameter, exists in database.
     * @param username search String for username
     * @return boolean
     */
    boolean checkUsername(String username);
    /**
     * Fetches User object from table USER defined by username and password given as parameter
     * @param username String value that represents username
     * @param password String value that represents password
     * @return int value for id
     * @throws HairsalonException in case of an error
     */
    int getLoggedInId(String username, String password) throws HairsalonException;
}

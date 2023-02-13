package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HairsalonException;


import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * MySQL implementation of the DAO
 * @author Nejra Adilovic
 */
public class UserDaoSQLImpl extends AbstractDao<User> implements UserDao{
    private static  UserDaoSQLImpl instance = null;
    /**
     * Private constructor for the UserDaoSQLImpl class.
     * This constructor initializes the parent class  with the table name.
     */
    public UserDaoSQLImpl() {
        super("USER");
    }
    /**
     * @return UserDaoSQLImpl
     * We don't need more than one object for CRUD operations on table 'USER' so we will use Singleton
     * This method will call private constructor in instance==null and then return that instance
     */
    public static UserDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new UserDaoSQLImpl();
        return instance;
    }
    /**
     * Removes the singleton instance of the UserDaoSQLImpl class.
     */
    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }
    /**
     *Maps a row from the result set to a User object
     *@param rs The result set from the database query
     *@return A User object with properties set according to the values in the result set
     *@throws HairsalonException if there is an error when retrieving values from the result set
     */
    @Override
    public User row2object(ResultSet rs) throws HairsalonException {
        try {
            User user = new User();
            user.setId(rs.getInt("user_id"));
            user.setFirst_name(rs.getString("first_name"));
            user.setLast_name(rs.getString("last_name"));
            user.setEmail(rs.getString("email"));
            user.setPhone(rs.getString("phone"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setAdmin(rs.getBoolean("admin"));
            return user;
        } catch (SQLException e) {
            throw new HairsalonException(e.getMessage(), e);
        }
    }
    /**
     * @param object - object to be mapped
     * @return map representation of object
     */
    @Override
    public Map<String, Object> object2row(User object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("user_id", object.getId());
        row.put("first_name", object.getFirst_name());
        row.put("last_name", object.getLast_name());
        row.put("email", object.getEmail());
        row.put("phone", object.getPhone());
        row.put("username", object.getUsername());
        row.put("password", object.getPassword());
        row.put("admin", object.isAdmin());
        return row;
    }
    /**
     * Lists all users from table USER in database that have the desired first name
     * @param first_name
     * @return List of all users with the desired first name
     */
    @Override
    public User getByFirstName(String first_name) throws HairsalonException {
        try {
            List<User> users = executeQuery("SELECT * FROM USER WHERE first_name = ?", new Object[]{first_name});
            return users.get(0);
        } catch (HairsalonException e) {
            throw new HairsalonException(e.getMessage(), e);
        }
    }
    /**
     * Lists all users from table USER in database that have the desired last name
     * @param last_name
     * @return List of all users with the desired last name
     */
    @Override
    public User getByLastName(String last_name) throws HairsalonException {
        try {
            List<User> users = executeQuery("SELECT * FROM USER WHERE last_name = ?", new Object[]{last_name});
            return users.get(0);
        } catch (HairsalonException e) {
            throw new HairsalonException(e.getMessage(), e);
        }
    }
    /**
     * Lists all users from table USER in database that have the desired username
     * @param username
     * @return List of all users with the desired username
     */
    @Override
    public User getByUsername(String username) throws HairsalonException {
        try {
            List<User> users = executeQuery("SELECT * FROM USER WHERE username = ?", new Object[]{username});
            return users.get(0);
        } catch (HairsalonException e) {
            throw new HairsalonException(e.getMessage(), e);
        }
    }
    /**
     * Lists all users from table USER in database that are admins
     * @param admin String
     * @return boolean
     * @throws HairsalonException thrown in case of problem with db
     */
    @Override
    public User getByAdmin(boolean admin) throws HairsalonException {
        try {
            List<User> users = executeQuery("SELECT * FROM USER WHERE admin = ?", new Object[]{admin});
            return users.get(0);
        } catch (HairsalonException e) {
            throw new HairsalonException(e.getMessage(), e);
        }
    }
    /**
     * Returns user whose username and password are given as parameters.
     * @param username search String for username of user
     * @param password search String for password of user
     * @return User instance
     */
    public User checkUser(String username, String password) {
        String sql = "SELECT * FROM USER WHERE username = ? AND password = ?";
        User user = null;
        try {
            List<User> u = DaoFactory.userDao().getAll();
            PreparedStatement s=getConnection().prepareStatement(sql);
            s.setString(1, username);
            s.setString(2, password);
            ResultSet r = s.executeQuery();

            if(!r.next()) return null;

            user = row2object(r);
            return user;


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (HairsalonException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
    /**
     * Returns true if username, given as parameter, exists in database.
     *
     * @param username search String for username
     * @return boolean
     */
    public boolean checkUsername(String username) {
        String sql = "SELECT * FROM USER WHERE username = ?";
        try {
            PreparedStatement s=getConnection().prepareStatement(sql);
            s.setString(1, username);
            ResultSet r = s.executeQuery();
            while(r.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * Fetches User object from table USER defined by username and password given as parameter
     * @param username String value that represents username
     * @param password String value that represents password
     * @return int value for id
     * @throws HairsalonException in case of an error
     */
    public int getLoggedInId(String username, String password) throws HairsalonException {
        try {
            List<User> users = executeQuery("SELECT * FROM USER WHERE username = ? AND password = ?", new Object[]{username, password});
            if (users.isEmpty()) return 0;
            return users.get(0).getId();
        } catch (HairsalonException e) {
            throw new HairsalonException(e.getMessage(), e);
        }
    }
}
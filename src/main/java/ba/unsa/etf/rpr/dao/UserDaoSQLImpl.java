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

}
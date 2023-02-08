package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.HairsalonException;


import java.sql.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * MySQL implementation of the DAO
 * @author Nejra Adilovic
 */
public class UserDaoSQLImpl extends AbstractDao<User> implements UserDao{
    public UserDaoSQLImpl() {
        super("USER");
    }

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
}
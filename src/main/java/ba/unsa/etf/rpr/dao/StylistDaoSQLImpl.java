package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Stylist;
import ba.unsa.etf.rpr.exceptions.HairsalonException;

import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * MySQL implementation of the DAO
 * @author Nejra Adilovic
 */
public class StylistDaoSQLImpl extends AbstractDao<Stylist> implements StylistDao{
    private static  StylistDaoSQLImpl instance = null;
    /**
     * Private constructor for the StylistDaoSQLImpl class.
     * This constructor initializes the parent class  with the table name.
     */
    StylistDaoSQLImpl() {
        super("STYLIST");
    }
    /**
     * @return StylistDaoSQLImpl
     * We don't need more than one object for CRUD operations on table 'STYLIST' so we will use Singleton
     * This method will call private constructor in instance==null and then return that instance
     */
    public static StylistDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new StylistDaoSQLImpl();
        return instance;
    }
    /**
     * Removes the singleton instance of the StylistDaoSQLImpl class.
     */
    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }
    /**
     *Maps a row from the result set to a Stylist object
     *@param rs The result set from the database query
     *@return A Stylist object with properties set according to the values in the result set
     *@throws HairsalonException if there is an error when retrieving values from the result set
     */
    @Override
    public Stylist row2object(ResultSet rs) throws HairsalonException {
        try {
            Stylist stylist = new Stylist();
            stylist.setId(rs.getInt("stylist_id"));
            stylist.setFirst_name(rs.getString("first_name"));
            stylist.setLast_name(rs.getString("last_name"));
            stylist.setPhone(rs.getString("phone"));
            return stylist;
        } catch (SQLException e) {
            throw new HairsalonException(e.getMessage(), e);
        }
    }
    /**
     * @param object - object to be mapped
     * @return map representation of object
     */
    @Override
    public Map<String, Object> object2row(Stylist object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("stylist_id", object.getId());
        row.put("first_name", object.getFirst_name());
        row.put("last_name", object.getLast_name());
        row.put("phone", object.getPhone());
        return row;
    }
}

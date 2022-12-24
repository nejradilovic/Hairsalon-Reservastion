package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Stylist;
import ba.unsa.etf.rpr.exceptions.HairsalonException;

import java.sql.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * MySQL implementation of the DAO
 * @author Nejra Adilovic
 */
public class StylistDaoSQLImpl extends AbstractDao<Stylist> implements StylistDao{
    public StylistDaoSQLImpl() {
        super("STYLIST");
    }

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

package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Stylist;
import ba.unsa.etf.rpr.exceptions.HairsalonException;

import java.util.List;

/**
 * Dao interface for Stylist domain bean
 *
 * @author Nejra Adilović
 */
public interface StylistDao extends Dao<Stylist> {
    /**
     * Fetches Stylist object form table STYLIST defined by given name (first_name and last_name).
     * @param first_name String
     * @param last_name String
     * @return Stylist object defined by given name
     * @throws HairsalonException thrown in case of problem with db
     */
    Stylist getByName(String first_name, String last_name) throws HairsalonException;
    /**
     * Fetches all names of stylists from table STYLIST and stores it in a list.
     * @return List of all stylists names
     * @throws HairsalonException thrown in case of problem with db
     */
    List<String> getAllNames() throws HairsalonException;
}

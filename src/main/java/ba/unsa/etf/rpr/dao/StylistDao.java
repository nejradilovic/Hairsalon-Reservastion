package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Stylist;
import ba.unsa.etf.rpr.exceptions.HairsalonException;

/**
 * Dao interface for Stylist domain bean
 *
 * @author Nejra Adilović
 */
public interface StylistDao extends Dao<Stylist> {
    Stylist getByFirst_name(String ime) throws HairsalonException;

}

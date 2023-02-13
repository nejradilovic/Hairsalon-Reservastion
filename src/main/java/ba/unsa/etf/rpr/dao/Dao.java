package ba.unsa.etf.rpr.dao;

import java.util.List;
import ba.unsa.etf.rpr.exceptions.HairsalonException;
/**
 * Root interface for all DAO classes
 *@param <T>
 * @author Nejra Adilović
 */
public interface Dao<T> {

    /**
     * get entity from database base on ID
     * @param id primary key of entity
     * @return Entity from database
     * @throws HairsalonException in case of problems with db
     */
    T getById(int id) throws HairsalonException;

    /**
     * Saves entity into database
     * @param item bean for saving to database
     * @return saved item with id field populated
     * @throws HairsalonException in case of problems with db
     */
    T add(T item) throws HairsalonException;

    /**
     * Fully updates entity in database based on id (primary) match.
     * @param item - bean to be updated. id must be populated
     * @return updated version of bean
     * @throws HairsalonException in case of problems with db
     */
    T update(T item) throws HairsalonException;

    /**
     * Hard delete of item from database with given id
     * @param id - primary key of entity
     * @throws HairsalonException in case of problems with db
     */
    void delete(int id) throws HairsalonException;

    /**
     * Lists all entities from database. WARNING: Very slow operation because it reads all records.
     * @return List of entities from database
     * @throws HairsalonException in case of problems with db
     */
    List<T> getAll() throws HairsalonException;
}

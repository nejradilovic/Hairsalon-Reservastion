package ba.unsa.etf.rpr.domain;

import ba.unsa.etf.rpr.business.StylistManager;
import ba.unsa.etf.rpr.dao.StylistDao;
import ba.unsa.etf.rpr.exceptions.HairsalonException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

/**
 * Tests for Stylist class
 * @author Nejra Adilovic
 */
public class StylistTest {
    private StylistManager stylistManager;
    /**
     * Mock test for Stylist
     * StylistDao is annotated with @Mock, which means it will be mocked using the Mockito framework.
     */
    @Mock
    private StylistDao stylistDao;
    public Stylist stylist = new Stylist("Sara", "Biogradlic",  "062001333");

    /**
     * MockitoAnnotations.openMocks method is called to initialize the mock objects and a new instance of the StylistManager is created.
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        stylistManager = new StylistManager();
    }

    /**
     * Tests the add method of the StylistDao
     * Calls the add method with the stylist object as a parameter
     * Verifies that the add method was called with the stylist object by calling verify(stylistDao).add(stylist)
     * @throws HairsalonException in case of problems with db
     */
    @Test
    public void addTest() throws HairsalonException {
        stylistDao.add(stylist);
        verify(stylistDao).add(stylist);
    }

    /**
     * Updates first_name of stylist object, calls the update method of StylistDao with the stylist object as a parameter
     * Verifies that the update method was called with the stylist object by calling verify(stylistDao).update(stylist).
     * @throws Exception in case of problems with db
     */
    @Test
    void updateTest() throws Exception {
        stylist.setFirst_name("Sarah");
        stylistDao.update(stylist);
        verify(stylistDao).update(stylist);
    }
    /**
     * Test for setters and getters in Stylist
     */
    @Test
    public void testStylistSettersAndGetters() {
        Stylist stylist = new Stylist();
        stylist.setFirst_name("Sara");
        stylist.setLast_name("Biogradlic");
        stylist.setPhone("062001333");
        assertEquals("Sara", stylist.getFirst_name());
        assertEquals("Biogradlic", stylist.getLast_name());
        assertEquals("062001333", stylist.getPhone());
    }
    /**
     * Test for constructor in Stylist
     */
    @Test
    public void testStylistConstructor() {
        Stylist stylist = new Stylist("Sara", "Biogradlic",  "062001333");
        assertEquals("Sara", stylist.getFirst_name());
        assertEquals("Biogradlic", stylist.getLast_name());
        assertEquals("062001333", stylist.getPhone());
    }
    /**
     * Test for equals method in Stylist
     */
    @Test
    public void testEquals() {
        Stylist stylist1 = new Stylist("Sara", "Biogradlic", "062001333");
        Stylist stylist2 = new Stylist("Sara", "Biogradlic", "062001333");
        assertEquals(stylist1, stylist2);
    }
    /**
     * Test for toString method in Stylist
     */
    @Test
    public void testToString()
    {
        Stylist stylist = new Stylist("Sara", "Biogradlic", "062001333");
        String expected = "Stylist{" +
                "stylist_id=0" +
                ", first_name='Sara" + '\'' +
                ", last_name='Biogradlic" + '\'' +
                ", phone='062001333" + '\'' +
                '}';
        assertEquals(expected, stylist.toString());
    }
}

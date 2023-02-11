package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.business.StylistManager;
import ba.unsa.etf.rpr.domain.Stylist;
import ba.unsa.etf.rpr.exceptions.HairsalonException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class StylistDaoTest {
    private StylistManager stylistManager;
    /**
     * Mock test for Stylist
     */
    @Mock
    private StylistDao stylistDao;
    public Stylist stylist = new Stylist("Sara", "Biogradlic",  "062001333");
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        stylistManager = new StylistManager();
    }
    @Test
    public void addTest() throws HairsalonException {
        stylistDao.add(stylist);
        verify(stylistDao).add(stylist);
    }
    @Test
    void updateTest() throws Exception {
        stylist.setFirst_name("Sarah");
        stylistDao.update(stylist);
        verify(stylistDao).update(stylist);
    }
    /**
     * Test for setters and getters for Stylist
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
     * Test for constructor for Stylist
     */
    @Test
    public void testStylistConstructor() {
        Stylist stylist = new Stylist("Sara", "Biogradlic",  "062001333");
        assertEquals("Sara", stylist.getFirst_name());
        assertEquals("Biogradlic", stylist.getLast_name());
        assertEquals("062001333", stylist.getPhone());
    }
    /**
     * Test for equals method for Stylist
     */
    @Test
    public void testEquals() {
        Stylist stylist1 = new Stylist("Sara", "Biogradlic", "062001333");
        Stylist stylist2 = new Stylist("Sara", "Biogradlic", "062001333");
        assertEquals(stylist1, stylist2);
    }
    /**
     * Test for toString method for Stylist
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

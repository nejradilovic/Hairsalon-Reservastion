import ba.unsa.etf.rpr.business.StylistManager;
import ba.unsa.etf.rpr.domain.Stylist;
import ba.unsa.etf.rpr.exceptions.HairsalonException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StylistManagerTest {
    StylistManager stylistManager = new StylistManager();
    @Test
    void testGetAll(){
        assertDoesNotThrow(() -> { stylistManager.getAll(); });
    }
    @Test
    void testDeleteStylist(){
        Stylist stylist = new Stylist();
        stylist.setFirst_name("Sara");
        stylist.setLast_name("Biogradlic");
        stylist.setPhone("062001333");
        boolean deleted=false;
        try {
            stylistManager.add(stylist);
            List<Stylist> lista = stylistManager.getAll();
            for(Stylist s: lista){
                if(s.getPhone().equals("062001333")){
                    stylistManager.delete(s.getId());
                    deleted=true;
                    break;
                }
            }
        } catch (HairsalonException e) {
            throw new RuntimeException(e);
        }
        assertTrue(deleted);
    }
    @Test
    void testAddStylist(){
        Stylist stylist = new Stylist();
        stylist.setFirst_name("Sara");
        stylist.setLast_name("Biogradlic");
        stylist.setPhone("062001333");
        boolean added=false;
        try {
            stylistManager.add(stylist);
            List<Stylist> lista = stylistManager.getAll();
            for(Stylist s: lista){
                if(s.getPhone().equals("062001333")){
                    stylistManager.delete(s.getId());
                    added=true;
                    break;
                }
            }
        } catch (HairsalonException e) {
            throw new RuntimeException(e);
        }
        assertTrue(added);
    }
}

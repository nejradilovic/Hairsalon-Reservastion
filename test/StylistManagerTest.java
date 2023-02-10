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

}

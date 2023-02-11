package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserDaoTest {
    /**
     * Test for setters and getters for User
     */
    @Test
    public void testUserSettersAndGetters() {
        User user = new User();
        user.setFirst_name("Sara");
        user.setLast_name("Biogradlic");
        user.setPhone("062001333");
        user.setEmail("sbiogradlic1@gmail.com");
        user.setAdmin(false);
        user.setUsername("sbiogradlic1");
        user.setPassword("stajeovoovo");
        assertEquals("Sara", user.getFirst_name());
        assertEquals("Biogradlic", user.getLast_name());
        assertEquals("062001333", user.getPhone());
        assertEquals("sbiogradlic1@gmail.com", user.getEmail());
        assertEquals("sbiogradlic1", user.getUsername());
        assertEquals("stajeovoovo", user.getPassword());
        assertFalse(user.isAdmin(), "false");
    }
    /**
     * Test for constructor for User
     */
    @Test
    public void testUserConstructor() {
        User user = new User("Sara", "Biogradlic", "sbiogradlic1@gmail.com", "062001333", "stajeovoovo", "sbiogradlic1", false);
        assertEquals("Sara", user.getFirst_name());
        assertEquals("Biogradlic", user.getLast_name());
        assertEquals("062001333", user.getPhone());
        assertEquals("sbiogradlic1@gmail.com", user.getEmail());
        assertEquals("sbiogradlic1", user.getUsername());
        assertEquals("stajeovoovo", user.getPassword());
        assertFalse(user.isAdmin(), "false");
    }
    /**
     * Test for equals method for User
     */
    @Test
    public void testEquals() {
        User user1 = new User("Sara", "Biogradlic", "sbiogradlic1@gmail.com", "062001333", "stajeovoovo", "sbiogradlic1", false);
        User user2 = new User("Sara", "Biogradlic", "sbiogradlic1@gmail.com", "062001333", "stajeovoovo", "sbiogradlic1", false);
        assertEquals(user1, user2);
    }
    /**
     * Test for toString method for User
     */
    @Test
    public void testToString()
    {
        User user = new User("Sara", "Biogradlic", "sbiogradlic1@gmail.com", "062001333", "stajeovoovo", "sbiogradlic1", false);
        String expected = "User{" +
                "user_id=0" +
                ", first_name='Sara" + '\'' +
                ", last_name='Biogradlic" + '\'' +
                ", email='sbiogradlic1@gmail.com" + '\'' +
                ", phone='062001333" + '\'' +
                ", username='sbiogradlic1" + '\'' +
                ", password='stajeovoovo" + '\'' +
                ", admin=false" +
                '}';
        assertEquals(expected, user.toString());
    }
}
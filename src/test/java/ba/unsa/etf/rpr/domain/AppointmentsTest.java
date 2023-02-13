package ba.unsa.etf.rpr.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Tests for Appointments class
 * @author Nejra Adilovic
 */
public class AppointmentsTest {
    /**
     * Test for setters and getters in Appointments
     */
    @Test
    public void testAppointmentsSettersAndGetters() {
        Appointments appointments = new Appointments();
        java.sql.Date appointmentDate = java.sql.Date.valueOf(LocalDate.of(2023, Month.FEBRUARY, 14));
        appointments.setService("Extensions");
        appointments.setTime(appointmentDate);
        appointments.setDuration(120);
        appointments.setPrice("130$");
        appointments.setUser(new User());
        appointments.setStylist(new Stylist());
        assertEquals("Extensions", appointments.getService());
        assertEquals(java.sql.Date.valueOf(LocalDate.of(2023, Month.FEBRUARY, 14)),appointments.getTime());
        assertEquals(120, appointments.getDuration());
        assertEquals("130$", appointments.getPrice());
        assertNotNull(appointments.getStylist());
        assertNotNull(appointments.getUser());
    }
    /**
     * Test for toString method in Appointments
     */
    @Test
    public void testToString()
    {
        Appointments appointments = new Appointments();
        String expected = "Appointments{" +
                "appointments_id=" + appointments.getId() +
                ", service='" + appointments.getService() + '\'' +
                ", time=" + appointments.getTime() +
                ", duration=" + appointments.getDuration() +
                ", price='" + appointments.getPrice() + '\'' +
                ", user_id=" + appointments.getUser() +
                ", stylist_id=" + appointments.getStylist() +
                '}';
        assertEquals(expected, appointments.toString());
    }
}

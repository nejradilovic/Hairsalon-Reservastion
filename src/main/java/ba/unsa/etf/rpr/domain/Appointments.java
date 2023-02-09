package ba.unsa.etf.rpr.domain;

import java.util.Date;
import java.util.Objects;
/**
 * Class that contains information about scheduled appointments made for Seat&Style.
 * Bean for Appointments
 * @author Nejra Adilovic
 */

public class Appointments implements Idable{
    private int appointments_id;
    private String service;
    private Date time;
    private int duration;
    private String price;
    private User user;
    private Stylist stylist;
    @Override
    public int getId() {
        return appointments_id;
    }
    @Override
    public void setId(int appointments_id) {
        this.appointments_id = appointments_id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Stylist getStylist() {
        return stylist;
    }

    public void setStylist(Stylist stylist) {
        this.stylist = stylist;
    }

    @Override
    public String toString() {
        return "Appointments{" +
                "appointments_id=" + appointments_id +
                ", service='" + service + '\'' +
                ", time=" + time +
                ", duration=" + duration +
                ", price='" + price + '\'' +
                ", user_id=" + user +
                ", stylist_id=" + stylist +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointments that = (Appointments) o;
        return appointments_id == that.appointments_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointments_id, service, time, duration, price, user, stylist);
    }
}

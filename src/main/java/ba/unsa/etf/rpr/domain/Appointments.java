package ba.unsa.etf.rpr.domain;

import java.util.Date;
import java.util.Objects;

public class Appointments {
    private int appointments_id;
    private String service;
    private Date time;
    private int duration;
    private String price;
    private int user_id;
    private int stylist_id;

    public int getAppointments_id() {
        return appointments_id;
    }

    public void setAppointments_id(int appointments_id) {
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getStylist_id() {
        return stylist_id;
    }

    public void setStylist_id(int stylist_id) {
        this.stylist_id = stylist_id;
    }

    @Override
    public String toString() {
        return "Appointments{" +
                "appointments_id=" + appointments_id +
                ", service='" + service + '\'' +
                ", time=" + time +
                ", duration=" + duration +
                ", price='" + price + '\'' +
                ", user_id=" + user_id +
                ", stylist_id=" + stylist_id +
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
        return Objects.hash(appointments_id, service, time, duration, price, user_id, stylist_id);
    }
}

package ba.unsa.etf.rpr.domain;

import java.util.Date;
import java.util.Objects;
/**
 * Class that contains information about scheduled appointments made
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
    /**
     * Parameterized constructor
     * @param service String value
     * @param time Date value
     * @param duration int value
     * @param price String value
     * @param user User value
     * @param stylist Stylist value
     */
    public Appointments(String service, Date time, int duration, String price, User user, Stylist stylist) {
        this.service = service;
        this.time = time;
        this.duration = duration;
        this.price = price;
        this.user = user;
        this.stylist = stylist;
    }
    /**
     * no-arg constructor
     */
    public Appointments(){
    }
    /**
     * gets the value of appointments_id
     * @return int value
     */
    @Override
    public int getId() {
        return appointments_id;
    }
    /**
     * sets or updates the value of stylist_id
     * @param appointments_id int value
     */
    @Override
    public void setId(int appointments_id) {
        this.appointments_id = appointments_id;
    }
    /**
     * gets the value of service
     * @return String value
     */
    public String getService() {
        return service;
    }
    /**
     * sets or updates the value of first_name
     * @param service String value
     */
    public void setService(String service) {
        this.service = service;
    }
    /**
     * gets the value of time
     * @return Date value
     */
    public Date getTime() {
        return time;
    }
    /**
     * sets or updates the value of time
     * @param time Date value
     */
    public void setTime(Date time) {
        this.time = time;
    }
    /**
     * gets the value of duration
     * @return int value
     */
    public int getDuration() {
        return duration;
    }
    /**
     * sets or updates the value of duration
     * @param duration int value
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }
    /**
     * gets the value of price
     * @return String value
     */
    public String getPrice() {
        return price;
    }
    /**
     * sets or updates the value of price
     * @param price String value
     */
    public void setPrice(String price) {
        this.price = price;
    }
    /**
     * gets the value of user
     * @return User value
     */
    public User getUser() {
        return user;
    }
    /**
     * sets or updates the value of user
     * @param user User value
     */
    public void setUser(User user) {
        this.user = user;
    }
    /**
     * gets the value of stylist
     * @return Stylist value
     */
    public Stylist getStylist() {
        return stylist;
    }
    /**
     * sets or updates the value of stylist
     * @param stylist Stylist value
     */
    public void setStylist(Stylist stylist) {
        this.stylist = stylist;
    }
    /**
     * returns the String representation of the object.
     * @return String value
     */
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
    /**
     * compares two strings, and returns true if the strings are equal, and false if not
     * @param o Object
     * @return boolean value
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointments that = (Appointments) o;
        return appointments_id == that.appointments_id;
    }
    /**
     * generating an integer value by a hashing algorithm.
     * @return integer value
     */
    @Override
    public int hashCode() {
        return Objects.hash(appointments_id, service, time, duration, price, user, stylist);
    }
}

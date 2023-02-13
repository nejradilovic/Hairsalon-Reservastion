package ba.unsa.etf.rpr.domain;

import java.util.Objects;
/**
 * Holds information about Stylist
 * Bean for Stylist
 * @author Nejra Adilović
 */

public class Stylist implements Idable{
    private int stylist_id;
    private String first_name,last_name,phone;
    /**
     * no-arg constructor
     */
    public Stylist(){}
    /**
     * Parameterized constructor
     * @param first_name String value
     * @param last_name String value
     * @param phone String value
     */
    public Stylist(String first_name, String last_name, String phone) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
    }
    /**
     * gets the value of stylist_id
     * @return int value
     */
    @Override
    public int getId() {
        return stylist_id;
    }
    /**
     * sets or updates the value of stylist_id
     * @param stylist_id int value
     */
    @Override
    public void setId(int stylist_id) {
        this.stylist_id = stylist_id;
    }
    /**
     * gets the value of first_name
     * @return String value
     */
    public String getFirst_name() {
        return first_name;
    }
    /**
     * sets or updates the value of first_name
     * @param first_name String value
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * gets the value of last_name
     * @return String value
     */
    public String getLast_name() {
        return last_name;
    }
    /**
     * sets or updates the value of last_name
     * @param last_name String value
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    /**
     * gets the value of phone
     * @return String value
     */
    public String getPhone() {
        return phone;
    }
    /**
     * sets or updates the value of phone
     * @param phone String value
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
     * returns the String representation of the object.
     * @return String value
     */
    @Override
    public String toString() {
        return "Stylist{" +
                "stylist_id=" + stylist_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", phone='" + phone + '\'' +
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
        Stylist stylist = (Stylist) o;
        return stylist_id == stylist.stylist_id;
    }
    /**
     * generating an integer value by a hashing algorithm.
     * @return integer value
     */
    @Override
    public int hashCode() {
        return Objects.hash(stylist_id, first_name, last_name, phone);
    }
}

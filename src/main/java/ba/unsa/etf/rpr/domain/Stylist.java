package ba.unsa.etf.rpr.domain;

import java.util.Objects;
/**
 * Holds information about Stylist for Seat&Style
 * Bean for Stylist
 * @author Nejra Adilović
 */

public class Stylist implements Idable{
    private int stylist_id;
    private String first_name,last_name,phone;

    @Override
    public int getId() {
        return stylist_id;
    }
    @Override
    public void setId(int stylist_id) {
        this.stylist_id = stylist_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Stylist{" +
                "stylist_id=" + stylist_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stylist stylist = (Stylist) o;
        return stylist_id == stylist.stylist_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stylist_id, first_name, last_name, phone);
    }
}

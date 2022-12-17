package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Appointments;

import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class AppointmentsDaoSQLImpl implements AppointmentsDao{
    private Connection connection;
    public AppointmentsDaoSQLImpl(){
        try {
            FileReader reader = new FileReader("src/main/resources/db.properties");
            Properties p = new Properties();
            p.load(reader);
            String s1=p.getProperty("user");
            String s2=p.getProperty("password");
            String s3=p.getProperty("url");
            this.connection = DriverManager.getConnection(s3,s1,s2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public Appointments getById(int id) {
        String query = "SELECT * FROM APPOINTMENTS WHERE appointments_id = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){ // result set is iterator.
                Appointments appointments = new Appointments();
                appointments.setAppointments_id(rs.getInt("appointments_id"));
                appointments.setService(rs.getString("service"));
                appointments.setTime(rs.getDate("time"));
                appointments.setDuration(rs.getInt("duration"));
                appointments.setPrice(rs.getString("price"));
                appointments.setUser(new UserDaoSQLImpl().getById(rs.getInt("user_id")));
                appointments.setStylist(new StylistDaoSQLImpl().getById(rs.getInt("stylist_id")));
                rs.close();
                return appointments;
            }else{
                return null; // if there is no elements in the result set return null
            }
        }catch (SQLException e){
            e.printStackTrace(); // poor error handling
        }
        return null;
    }
    private int getMaxId(){
        int id=1;
        try {
            PreparedStatement statement = this.connection.prepareStatement("SELECT MAX(id)+1 FROM appointments");
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                id = rs.getInt(1);
                rs.close();
                return id;
            }
        } catch (SQLException e) {
            System.out.println("Problem pri radu sa bazom podataka");
            System.out.println(e.getMessage());
        }
        return id;
    }
    @Override
    public Appointments add(Appointments item) {
        int appointments_id = getMaxId();
        try {
            PreparedStatement stmt = this.connection.prepareStatement("INSERT INTO APPOINTMENTS VALUES (appointments_id, item.getService(), item.getTime(), item.getDuration(), item.getPrice(), item.getUser().getUser_id(), item.getStylist().getStylist_id()");
            stmt.executeUpdate();
            item.setAppointments_id(appointments_id);
            return item;
        } catch (SQLException e) {
            System.out.println("Problem pri radu sa bazom podataka");
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Appointments update(Appointments item) {
        try{
            PreparedStatement stmt = this.connection.prepareStatement("UPDATE APPOINTMENTS SET service=?, time=?, duration=?, price=?, user=?, stylist=? WHERE appointments_id=?");
            stmt.setString(1, item.getService());
            stmt.setDate(2, (Date) item.getTime());
            stmt.setInt(3, item.getDuration());
            stmt.setString(4, item.getPrice());
            stmt.setInt(5, item.getUser().getUser_id());
            stmt.setInt(6, item.getStylist().getStylist_id());
            stmt.executeUpdate();
            return item;
        }
        catch (SQLException e){
            System.out.println("Problem pri radu sa bazom podataka");
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void delete(int appointments_id) {
        try{
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM APPOINTMENTS WHERE appointments_id=?");
            stmt.setInt(1, appointments_id);
            stmt.executeUpdate();
        }catch (SQLException e){
            System.out.println("Problem pri radu sa bazom podataka");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Appointments> getAll() {
        List<Appointments> appointments = new ArrayList<>();
        try{
            PreparedStatement stmt =  this.connection.prepareStatement("SELECT * FROM APPOINTMENTS");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Appointments reservations1 = new Appointments();
                reservations1.setAppointments_id(rs.getInt("appointments_id"));

            }
        }
        catch (SQLException e){
            System.out.println("Problem pri radu sa bazom podataka");
            System.out.println(e.getMessage());
        }
        return appointments;
    }
}

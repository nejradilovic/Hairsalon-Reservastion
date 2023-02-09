package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Appointments;
import ba.unsa.etf.rpr.exceptions.HairsalonException;

import java.sql.*;
import java.util.Map;
import java.util.TreeMap;


public class AppointmentsDaoSQLImpl extends AbstractDao<Appointments> implements AppointmentsDao{
    private static  AppointmentsDaoSQLImpl instance = null;
    private AppointmentsDaoSQLImpl() {
        super("APPOINTMENTS");
    }
    public static AppointmentsDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new AppointmentsDaoSQLImpl();
        return instance;
    }
    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }
    @Override
    public Appointments row2object(ResultSet rs) throws HairsalonException {
        try{
            Appointments appointments = new Appointments();
            appointments.setId(rs.getInt("appointments_id"));
            appointments.setService(rs.getString("service"));
            appointments.setTime(rs.getDate("time"));
            appointments.setDuration(rs.getInt("duration"));
            appointments.setPrice(rs.getString("price"));
            appointments.setUser(DaoFactory.userDao().getById(rs.getInt("user_id")));
            appointments.setStylist(DaoFactory.stylistDao().getById(rs.getInt("stylist_id")));
            return appointments;
        } catch (Exception e){
            throw new HairsalonException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Appointments object) {
        Map<String, Object> item = new TreeMap<>();
        item.put("appointments_id", object.getId());
        item.put("service", object.getService());
        item.put("time", object.getTime());
        item.put("duration", object.getDuration());
        item.put("price", object.getPrice());
        item.put("user_id", object.getUser().getId());
        item.put("stylist_id", object.getStylist().getId());
        return item;
    }
}

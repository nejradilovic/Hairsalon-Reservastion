package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Stylist;

import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class StylistDaoSQLImpl implements StylistDao{
    private Connection connection;
    public StylistDaoSQLImpl(){
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
    public Stylist getById(int id) {
        String query = "SELECT * FROM STYLIST WHERE stylist_id = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){ // result set is iterator.
                Stylist stylists = new Stylist();
                stylists.setStylist_id(rs.getInt("stylist_id"));
                stylists.setFirst_name(rs.getString("first_name"));
                stylists.setLast_name(rs.getString("last_name"));
                stylists.setPhone(rs.getString("phone"));
                rs.close();
                return stylists;
            }else{
                return null; // if there is no elements in the result set return null
            }
        }catch (SQLException e){
            e.printStackTrace(); // poor error handling
        }
        return null;
    }
    @Override
    public Stylist add(Stylist item) {
        String insert = "INSERT INTO STYLIST(first_name, last_name, phone) VALUES(?,?,?)";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, item.getFirst_name());
            stmt.setString(2, item.getLast_name());
            stmt.setString(3, item.getPhone());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            rs.next(); // we know that there is one key
            item.setStylist_id(rs.getInt(1)); //set id to return it back
            return item;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Stylist update(Stylist item) {
        String insert = "UPDATE STYLIST SET first_name = ?,last_name = ?,phone=? " +
                "WHERE stylist_id=? ";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(1, item.getFirst_name());
            stmt.setObject(2, item.getLast_name());
            stmt.setObject(3, item.getPhone());
            stmt.executeUpdate();
            return item;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public void delete(int id) {
        String insert = "DELETE FROM STYLIST WHERE stylist_id = ?";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(1, id);
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Stylist> getAll() {
        String query = "SELECT * FROM STYLIST";
        List<Stylist> stylists= new ArrayList<>();
        try{
            PreparedStatement stmt = this.connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){ // result set is iterator.
                Stylist stylist = new Stylist();
                stylist.setStylist_id(rs.getInt("stylist_id"));
                stylist.setFirst_name(rs.getString("first_name"));
                stylist.setLast_name(rs.getString("last_name"));
                stylist.setPhone(rs.getString("phone"));
                stylists.add(stylist);
            }
            rs.close();
        }catch (SQLException e){
            e.printStackTrace(); // poor error handling
        }
        return stylists;
    }
}

package assignment2;


import static java.lang.System.out;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class customerDAO {

	String dbURL = "jdbc:postgresql://ec2-18-204-142-254.compute-1.amazonaws.com/d5ivvm39oh719k";
    String user = "cqrczajvwzbsyn";
    String pass = "a9510d4ab2b0cf12aea03b2c8811e6e818edc93b5dd99fee6f9e303bfc3654cd";
    protected Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(dbURL, user, pass);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return con;

    }
    public void addService (customer cs,report rp) throws SQLException {

        // try-with-resource statement will auto close the connection.
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement
            		 ("insert into customer(nric,name,phone,email) values(?,?,?,?)");
        			PreparedStatement ps2 = con.prepareStatement
            		 ("insert into report(catogary,date,item,price,subject,message,nric) values(?,?,?,?,?,?,?)"))
        
        {
        	ps.setString(1, cs.getId());
        	ps.setString(2, cs.getCustname());
        	ps.setString(3, cs.getCustphone());
        	ps.setString(4, cs.getCusteemail());
        	
        	ps2.setString(1, rp.getCategory());
            ps2.setDate(2, rp.getVisitdate());
            ps2.setString(3, rp.getItem());
            ps2.setDouble(4, rp.getPrice());
            ps2.setString(5, rp.getSubject());
            ps2.setString(6, rp.getMessage());
            ps2.setString(7, rp.getNric());
            ps2.executeUpdate();
            out.println(ps);

            ps.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean deleteService(String id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("delete from customer where nric=?");
        		PreparedStatement ps2 = connection.prepareStatement("delete from report where nric=?");) {
            ps.setString(1, id);
            ps2.setString(1, id);
            rowDeleted = ps.executeUpdate() > 0;
            rowDeleted = ps2.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    public void updateService (customer cs,report rp) throws SQLException {

        // try-with-resource statement will auto close the connection.
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement
        		("update customer set name=?,phone=?,email=? WHERE nric=?");
        			PreparedStatement ps2 = con.prepareStatement
            		 ("update report set date=?,item=?,price=?,subject=?,message=? WHERE nric=?"))
        
        {
        
        	ps.setString(1, cs.getCustname());
        	ps.setString(2, cs.getCustphone());
        	ps.setString(3, cs.getCusteemail());
        	ps.setString(4, cs.getId());
        	
        	
            ps2.setDate(1, rp.getVisitdate());
            ps2.setString(2, rp.getItem());
            ps2.setDouble(3, rp.getPrice());
            ps2.setString(4, rp.getSubject());
            ps2.setString(5, rp.getMessage());
            ps2.setString(6, rp.getNric());
            ps2.executeUpdate();
            out.println(ps);
            out.println(ps2);

            ps.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

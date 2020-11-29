import java.sql.*;

public class PatientDB {

    Connection conn;

    public PatientDB() throws SQLException {
        String dbUrl = "postgres://gscutarqgzlggf:95e80e5f025008c056f6a0da7a25d021fc22f8d057e23690eff26dfa68b4d783@ec2-176-34-123-50.eu-west-1.compute.amazonaws.com:5432/d7iqi2f4eilmd9";
        try {
            // Registers the driver
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
        }
        conn = DriverManager.getConnection(dbUrl);
    }

    public void createTablePatients() {
        try {
            Statement s = conn.createStatement();
            String sqlStr = "create table patients (id SERIAL PRIMARY KEY, familyname varchar(128) NOT NUll, givenname varchar(128) NOT NULL, phonenumber varchar(32));";
            s.execute(sqlStr);
            s.close();
        }
        catch (Exception e) { }
    }

    public void insertPatient(String famName, String gvnName, String phoNum) {
        try {
            Statement s = conn.createStatement();
            String sqlStr = "insert into patients (familyname,givenname,phonenumber) values ('" + famName + "','" + gvnName + "','" + phoNum + "');";
            s.execute(sqlStr);
            s.close();
        }
        catch (Exception e) { }
    }

    public String getPatient(int gvnID) {
        String response = null;
        try {
            Statement s = conn.createStatement();
            String sqlStr = "SELECT * FROM patients WHERE id=" + gvnID + ";";
            ResultSet rset = s.executeQuery(sqlStr);
            
            while (rset.next()) {
                response =  rset.getInt("id") + " " + rset.getString("familyname") + " " + rset.getString("givenname") + " " + rset.getString("phonenumber");
            }
            rset.close();
            s.close();
        }
        catch (Exception e) { }
        return response;
    }

}
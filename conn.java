package hospital.management;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class conn {

     public Connection connection;

     public Statement statement;
    
    public conn(){

        try {
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_system", "root" ,"khabib");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



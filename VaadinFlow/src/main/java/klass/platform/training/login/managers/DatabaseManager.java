package klass.platform.training.login.managers;


import javax.xml.transform.Result;
import java.sql.*;

public class DatabaseManager {

    public static void main(String[] args) throws Exception {
        try (
                // 1. Allocating a Database 'Connection' Object
                // -----------------------------------------------
                // Explanation ... :
                // - A Connection represents a session with a specific database.
                // - Within the context of a connection, SQL statements are executed and results are returned.
                // DatabaseUtil( String databaseUrl , String user , String password)


                Connection connect = DriverManager.getConnection(
                        "jdbc:mariadb://localhost:3306/userDB", "root", "Klass001"
                );

                // 2. Allocating a 'Statement' Object in the Connection.
                // -----------------------------------------------------
                // Explanation ...:
                // - A Statement object is used for executing a static SQL statement & obtaining the results produced by it
                // createStatement
                // - SQL statements without parameters are normally executed using Statement Objects.
                // ???

                Statement statement = connect.createStatement();

        ) {
            // 3. SQL statements (Queries)
            // ----------------------

            // a. (Create) A User.
            String userCreateQuery = "INSERT users(name,password) VALUES ('PERSON TEST' , 'PASSWORD TEST')";
            System.out.println("The SQL query is: " + userCreateQuery);      // For Debugging Purposes
            int userCreated = statement.executeUpdate(userCreateQuery);
            System.out.println(userCreated + " records affected.");

            // b. Issue a SELECT to check the results of '(Create) A User.'
            String userShow = "SELECT * FROM users";
            System.out.println(userShow + "This is the SQL query to display all Users in the database");
            ResultSet rset = statement.executeQuery(userShow);
            while (rset.next()) {
                System.out.println(rset.getInt("id") + ","
                        + rset.getString("name") + ","
                        + rset.getString("password") + ",");
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        // 4. Close the resources - Done automatically by try-with-resources
        // statement.close();

    }
}




